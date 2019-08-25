package dao;

import domain.User;

/**
 * @author gjq
 * @create 2019-08-24-16:37
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 保存用户信息
     *
     * @param user
     */
    public void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
