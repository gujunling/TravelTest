package dao.impl;

import dao.CategoryDao;
import domain.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-10:38
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有类别
     *
     * @return
     */
    @Override
    public List<Category> findAll() {

        String sql = "select * from tab_category ";

        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
