package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Blog;
import ra.model.service.IBlogService;

import java.util.List;

@Controller
@RequestMapping({"blogController", "/"})
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping({"showList", ""})
    public ModelAndView getList(Model model) {
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog");
        modelAndView.addObject("blog", blogs);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView add(@PathVariable("id") Long id) {
        return new ModelAndView("/edit", "blog", blogService.findById(id));
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        return new ModelAndView("/blogDetail", "blog", blogService.findById(id));
    }


}