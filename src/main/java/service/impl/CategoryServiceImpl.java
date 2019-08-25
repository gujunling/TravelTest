package service.impl;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import service.CategoryService;
import util.JedisUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author gjq
 * @create 2019-08-25-10:40
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao dao = new CategoryDaoImpl();

    /**
     * 查询所有类别
     *
     * @return
     */
    @Override
    public List<Category> findAll() {

        //从redis中查询
        //获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //使用sortedset排序查询
//        Set<String> categorys = jedis.zrange("category", 0, -1);

        //查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);

        //判断查询的集合是否为空
        List<Category> cs = null;
        if (categorys == null || categorys.size() == 0) {

            System.out.println("从数据库中查询");
            //如果为空，证明是第一次访问，需要从数据库中查询，再将数据存入redis中
            cs = dao.findAll();
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            //如果不为空，证明不是第一次查询，从redis中查询返回,将set的数据存入list

            System.out.println("从redis中查询");
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                cs.add(category);

            }

        }
        return cs;
    }
}
