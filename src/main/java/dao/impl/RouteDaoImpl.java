package dao.impl;

import dao.RouteDao;
import domain.Route;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-15:00
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
//        String sql = "select count(*) from tab_route where cid = ?";
        //定义sql模板
        String sql = "select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        //判断参数是否有值
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);//添加 ? 对应的值 cid
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");//添加 ? 对应的值 rname
        }
        sql = sb.toString();

        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {

        //String sql = "select * from tab_route where cid = ? limit ?,?";

        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        //判断参数是否有值
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);//添加 ? 对应的值 cid
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");//添加 ? 对应的值 rname
        }
        sb.append(" limit ? , ? ");//分页条件


        params.add(start);
        params.add(pageSize);

        sql = sb.toString();

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ? ";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);

    }

    @Override
    public List<Route> findByPageAll(int cid, int start, int pageSize) {
        String sql = "select * from tab_route where cid = ? limit ? , ?";

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid, start, pageSize);
    }

    @Override
    public int findTotalCountAll(int cid) {
        String sql = "select count(*) from tab_route where cid = ?";
        return template.queryForObject(sql, Integer.class, cid);
    }
}
