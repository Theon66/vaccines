package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.UserMapper;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.UserService;

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
    public int registerUser(User user) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("numberid", user.getNumberid());
        User tempUser = userMapper.selectOne(wrapper);
        if (tempUser != null)
            return 0;
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword());
        return userMapper.insert(user);
    }

    @Override
    public User loginUser(String telephone, String password) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("telephone", telephone);
        wrapper.eq("password", password);
       // User tempUser=null;
        User tempUser= userMapper.selectOne(wrapper);
      //  System.out.print(list.size());
//        if (list.size() !=0 ) {
//            return 1;
//        }
//System.out.print(tempUser);
        //return 0;
        return tempUser;
    }

    @Override
    public int modifyPassword(String oldpassword, String newpassword) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        User user = new User();
        user.setPassword(newpassword);
        wrapper.eq("password", oldpassword);
        return userMapper.update(user, wrapper);


    }

    @Override
    public String sendMsg(String telephone) {
        String flag = "0";
        try {
            Credential cred = new Credential("AKID5ykG2XJ8etrYzUcfYA7vxiCPPDsLnlsm", "i9LZHkpiKehYhY9Wc2dS0GEvMWRUGn45");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "ap-beijing", clientProfile);
            String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
            String params = "{\"PhoneNumberSet\":[" + "86" + telephone + "],\"TemplateID\":\"647203\",\"Sign\":\"影夏优众\",\"TemplateParamSet\":[" + code + " ,\"2\"],\"SmsSdkAppid\":\"1400390296\"}";
            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);
            SendSmsResponse resp = client.SendSms(req);
            System.out.println(SendSmsRequest.toJsonString(resp));
            return code;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }


        return flag;
    }

    @Override
    public int forgetPassword(String telephone, String code, String newpassword) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        User user = new User();
        user.setPassword(newpassword);
        user.setCode(code);
        wrapper.eq("telephone", telephone);

        return userMapper.update(user, wrapper);
    }


    @Override
    public int modifyUserInfo(User user) {
        return userMapper.updateById(user);
    }
    @Override
    public List<User> getUserInfo(String telephone) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("telephone", telephone);
        return userMapper.selectList(wrapper);
    }
    @Override
    public List<User> getUserInfoByNum(String numberid) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("numberid", numberid);
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
    public int addUser(User user) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("numberid", user.getNumberid());
        User tempUser = userMapper.selectOne(wrapper);
        if (tempUser != null)
            return 0;
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword());
        return userMapper.insert(user);
    }
    @Override
    public  List<User> changeUserInfoByNum(String numberid,String relation) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("numberid", numberid);
        wrapper.eq("relation", relation);
        return userMapper.selectList(wrapper);
    }


}