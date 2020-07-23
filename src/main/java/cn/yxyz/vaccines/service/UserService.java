package cn.yxyz.vaccines.service;

import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.vo.Login;

import java.util.List;

public interface UserService {
    List<User> getUserInfo(String telephone);


    List<User> findAllUser();

    int modifyUser(User user);

    int deleteUser(int uid);

    User Login(String code);
    User getUserInfoByOpenid(String openid);
}
