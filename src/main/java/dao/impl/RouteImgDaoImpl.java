package dao.impl;

import dao.RouteImgDao;
import domain.Category;
import domain.RouteImg;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-26-11:35
 */
public class RouteImgDaoImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {

        String sql = "select * from tab_route_img where rid = ? ";

        return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);

    }
}
