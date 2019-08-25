package dao;

import domain.Category;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-10:38
 */
public interface CategoryDao {

    /**
     * 查询所有类别
     *
     * @return
     */
    public List<Category> findAll();

}
