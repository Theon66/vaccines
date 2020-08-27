package cn.yxyz.vaccines.service;

import cn.yxyz.vaccines.pojo.User;

import java.util.List;

public interface UserService {

    int registerUser(User user);

    int loginUser(String telephone, String password);

    int modifyPassword(String oldpassword, String newpassword);

    String sendMsg(String telephone);

    int forgetPassword(String telephone, String code, String newpassword);

    List<User> getUserInfo(String telephone);

    int modifyUserInfo(User user);


    List<User> findAllUser();

    int modifyUser(User user);

    int deleteUser(int uid);
    int addUser(User user);
    List<User> changeUserInfoByNum(String numberid,String relation);

}
