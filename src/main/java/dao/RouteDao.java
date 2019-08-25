package dao;

import domain.Route;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-25-14:59
 */
public interface RouteDao {


    /**
     * 根据cid查询总记录数
     *
     * @param cid
     * @return
     */
    public int findTotalCount(int cid);

    //根据cid,srart,pageSize查询当前页的数据集合
    public List<Route> findByPage(int cid,int start,int pageSize);

}
