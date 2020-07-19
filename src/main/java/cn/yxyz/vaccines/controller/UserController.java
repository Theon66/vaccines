package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.UserService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //1、注册
    @PostMapping("user/register")
    public ResponseEntity<Integer> registerUser(@RequestBody User user) {
        Integer a = 0;
        String s = stringRedisTemplate.opsForValue().get(user.getTelephone());
        if (user.getCode().equals(s)) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(user));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }

    //2、登陆
    @PostMapping("user/login")
    public ResponseEntity<Integer> loginUser(@RequestParam String telephone, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(telephone, password));
    }

    ///4、忘记密码
    @PostMapping("user/forgetPassword")
    public ResponseEntity<Integer> forgetPassword(@RequestParam String telephone, @RequestParam String code, @RequestParam String newpassword) {
        Integer a = 0;
        String s = stringRedisTemplate.opsForValue().get(telephone);
        if (code.equals(s)) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.forgetPassword(telephone, code, newpassword));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }

    //5、发送短信
    @PostMapping("user/sendCode")
    public Object sendCode(@RequestBody List<String> telephone) {
        String res = userService.sendMsg(telephone.get(0));
        if (res != null) {

            stringRedisTemplate.opsForValue().set(telephone.get(0), res, 300000, TimeUnit.MILLISECONDS);
            System.out.println("code:" + res);
        }
        return res;
        //return ResponseEntity.status(HttpStatus.OK).body(userService.sendMsg(phone.get(0)));
    }

    //获得用户的详细信息
    @PostMapping("user/getUserInfo")
    public ResponseEntity<List<User>> getUserInfo(@RequestParam String telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfo(telephone));
    }

    //修改个人中心
    @PostMapping("user/modifyUserInfo")
    public ResponseEntity<Integer> modifyUserInfo(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyUserInfo(user));
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

}
