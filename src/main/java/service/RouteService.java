package service;

import domain.PageBean;
import domain.Route;

/**
 * 旅游线路
 *
 * @author gjq
 * @create 2019-08-25-14:45
 */
public interface RouteService {

    /**
     * 根据类别进行分页查询
     *
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据id查询一个旅游线路的信息
     *
     * @param rid
     * @return
     */
    public Route findOne(String rid);

    public PageBean<Route> pageQueryAll(int cid, int currentPage, int pageSize);

}
