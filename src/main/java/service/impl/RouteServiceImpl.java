package service.impl;

import dao.RouteDao;
import dao.RouteImgDao;
import dao.SellerDao;
import dao.impl.RouteDaoImpl;
import dao.impl.RouteImgDaoImpl;
import dao.impl.SellerDaoImpl;
import domain.PageBean;
import domain.Route;
import domain.RouteImg;
import domain.Seller;
import service.RouteService;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-14:46
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();

    private RouteImgDao routeImgDao = new RouteImgDaoImpl();

    private SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {

        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示的条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCout = routeDao.findTotalCount(cid, rname);
        pb.setTotalCount(totalCout);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;  //开始的记录数
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pb.setList(list);
        //设置总页数= 总记录数/每页显示条数
        int totalPage = totalCout % pageSize == 0 ? totalCout / pageSize : (totalCout / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }


    @Override
    public Route findOne(String rid) {

        //根据id去route表中查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));

        //根据route的rid查询图片集合信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());

        //将集合设置到route对象中
        route.setRouteImgList(routeImgList);

        //根据route的sid查询商家信息
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        return route;
    }

    @Override
    public PageBean<Route> pageQueryAll(int cid, int currentPage, int pageSize) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = routeDao.findTotalCountAll(cid);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        List<Route> list = routeDao.findByPageAll(cid,start,pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
