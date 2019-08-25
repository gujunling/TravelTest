package service.impl;

import dao.RouteDao;
import dao.impl.RouteDaoImpl;
import domain.PageBean;
import domain.Route;
import service.RouteService;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-14:46
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao dao = new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {

        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示的条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCout = dao.findTotalCount(cid);
        pb.setTotalCount(totalCout);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;  //开始的记录数
        List<Route> list = dao.findByPage(cid, start, pageSize);
        pb.setList(list);
        //设置总页数= 总记录数/每页显示条数
        int totalPage = totalCout % pageSize == 0 ? totalCout / pageSize : (totalCout / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
