package ra.model.dao;

import ra.model.entity.Blog;

import java.util.List;

public interface IBlogDao {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
