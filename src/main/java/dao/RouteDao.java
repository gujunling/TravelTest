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
    public int findTotalCount(int cid, String rname);

    /**
     * 根据cid,srart,pageSize查询当前页的数据集合
     *
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);

    /**
     * 根据id查询一个
     *
     * @param rid
     * @return
     */
    public Route findOne(int rid);

    public List<Route> findByPageAll(int cid, int start, int pageSize);

    public int findTotalCountAll(int cid);
}
