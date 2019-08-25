package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

/**
 * @author gjq
 * @create 2019-08-24-16:37
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    /**
     * 注册用户的方法
     *
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //根据用户名查询用户对象
        User u = dao.findByUsername(user.getUsername());

        //判断u是否为null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }
        //保存用户信息
        //设置激活码，保证唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");

        dao.save(user);

        //激活邮件发送，邮件正文
        String content = "<a href= 'http://localhost:8080/TravelTest/user/active?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";

        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    /**
     * 邮件激活的方法
     *
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //根据激活码查询用户对象
        User user = dao.findByCode(code);
        if (user != null) {
            //调用dao的修改激活状态的方法
            dao.updateStatus(user);
            return true;
        } else {

            return false;
        }

    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {

        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
