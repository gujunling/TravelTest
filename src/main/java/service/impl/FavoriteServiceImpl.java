package service.impl;

import dao.FavoriteDao;
import dao.impl.FavoriteDaoImpl;
import domain.Favorite;
import service.FavoriteService;

/**
 * @author gjq
 * @create 2019-08-26-17:33
 */
public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao dao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = dao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null; //如果对象有值，则为true，否则为false
    }

    @Override
    public void add(String rid, int uid) {
        dao.add(Integer.parseInt(rid),uid);

    }
}
