package dao;

import domain.RouteImg;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-26-11:33
 */
public interface RouteImgDao {

    /**
     * 根据route的id查询图片
     *
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);


}
