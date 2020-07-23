package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.UserMapper;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.UserService;
import cn.yxyz.vaccines.vo.Login;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserMapper userMapper;
    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    private  RestTemplate restTemplate;

    @Override
    public List<User> getUserInfo(String telephone) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("telephone", telephone);
        return userMapper.selectList(wrapper);
    }
    @Override
    public List<User> findAllUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectList(wrapper);
    }

    @Override
    public int modifyUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUser(int uid) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        return userMapper.delete(wrapper);
    }


    @Override
    public User Login(String code) {
        String  openid = getOpenid(code);
        QueryWrapper wrapper=new QueryWrapper<User>();
        wrapper.eq("openid",openid);
        User user=userMapper.selectOne(wrapper);
        if (user == null) {
            user=new User();
            user.setOpenid(openid);
            userMapper.insert(user);
        }
        return user;
    }

    private String getOpenid(String code) {
        Login login = restTemplate.getForObject(
                "https://api.weixin.qq.com/sns/jscode2session?" +
                        "appid=wx3774a22318c563b7&secret=2ea4598fa073e3def04db9b8ad402e76&js_code="
                        + code + "&grant_type=authorization_code", Login.class);
        if (login != null)
            return login.getOpenid();
        return null;
    }
    @Override
    public User getUserInfoByOpenid(String openid){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", openid);
        return userMapper.selectOne(wrapper);
    }
}