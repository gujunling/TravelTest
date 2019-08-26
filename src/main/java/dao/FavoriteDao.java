package dao;

import domain.Favorite;

/**
 * @author gjq
 * @create 2019-08-26-17:34
 */
public interface FavoriteDao {

    /**
     * 根据rid和uid判断是否收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据线路的rid查询收藏次数
     *
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     *
     * @param rid
     * @param uid
     */
    public void add(int rid, int uid);
}
