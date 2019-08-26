package dao;

import domain.Seller;

/**
 * @author gjq
 * @create 2019-08-26-11:45
 */
public interface SellerDao {

    /**
     * 根据id查询商家信息
     *
     * @param id
     * @return
     */
    public Seller findById(int id);
}
