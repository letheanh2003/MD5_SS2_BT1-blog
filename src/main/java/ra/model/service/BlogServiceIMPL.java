package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dao.IBlogDao;
import ra.model.entity.Blog;

import java.util.List;

@Service
public class BlogServiceIMPL implements IBlogService {
    @Autowired
    private IBlogDao blogDao;

    @Override
    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogDao.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogDao.remove(id);
    }
}
