package dao.impl;

import dao.SellerDao;
import domain.RouteImg;
import domain.Seller;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-26-11:47
 */
public class SellerDaoImpl implements SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findById(int id) {
        String sql = "select * from tab_seller where sid = ? ";

        return template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), id);

    }
}
