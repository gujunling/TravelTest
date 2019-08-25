package service;

import domain.Category;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-10:39
 */
public interface CategoryService {

    /**
     * 查询所有类别
     *
     * @return
     */
    public List<Category> findAll();
}
