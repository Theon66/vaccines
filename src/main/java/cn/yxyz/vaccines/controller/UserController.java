package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.UserService;

import cn.yxyz.vaccines.vo.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.List;
   

@RestController
public class UserController {

    private UserService userService;
    private StringRedisTemplate stringRedisTemplate;


    public UserController(UserService userService, StringRedisTemplate stringRedisTemplate) {
        this.userService = userService;
        this.stringRedisTemplate = stringRedisTemplate;
    }
    //后台管理系统
    //获得用户的详细信息
    @PostMapping("user/getUserInfo")
    public ResponseEntity<List<User>> getUserInfo(@RequestParam String telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfo(telephone));
    }
    //后台管理获得用户信息查
    @PostMapping("user/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());

    }
    //后台管理修改用户信息
    @PostMapping("user/modifyUser")
    public ResponseEntity<Integer> modifyUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyUser(user));

    }

    //后台管理删除用户信息
    @PostMapping("user/deleteUser")
    public ResponseEntity<Integer> deleteUser(@RequestParam int uid) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(uid));
    }

    //前端用户后台接口
    //微信一键登录
    @PostMapping("user/login")
    public ResponseEntity<User> login(@RequestParam String code) {
        User user = userService.Login(code);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //获得用户的详细信息
    @PostMapping("user/getUserInfoByOpenid")
    public ResponseEntity<User> getUserInfoByOpenid(@RequestParam String openid) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfoByOpenid(openid));
    }
}


