package service;

import domain.User;

/**
 * @author gjq
 * @create 2019-08-24-16:36
 */
public interface UserService {


    /**
     * 注册用户的方法
     *
     * @param user
     * @return
     */
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
