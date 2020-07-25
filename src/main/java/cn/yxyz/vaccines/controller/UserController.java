package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.UserService;

import cn.yxyz.vaccines.vo.Login;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
//    @ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response =
//            “接口返回参数类型”, notes = “接口发布说明”；其他参数可参考源码；
    @ApiOperation(value="根据手机号获得用户详细信息", httpMethod = "Post",response =User.class,notes="根据手机号获得用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "电话号码", required = true, dataType = "String", paramType = "query")
        })
    @PostMapping("user/getUserInfo")
    public ResponseEntity<List<User>> getUserInfo(@RequestParam String telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfo(telephone));
    }

    //后台管理获得用户信息查
    @ApiOperation(value="后台管理获得用户信息", httpMethod = "Post",response =User.class,notes="后台管理获得用户信息")
    @PostMapping("user/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());

    }

    @ApiOperation(value="后台管理修改用户信息", httpMethod = "Post",response =Integer.class,notes="后台管理修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    })
    //后台管理修改用户信息
    @PostMapping("user/modifyUser")
    public ResponseEntity<Integer> modifyUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyUser(user));

    }

    @ApiOperation(value="后台管理删除用户信息", httpMethod = "Post",response =Integer.class,notes="后台管理删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    //后台管理删除用户信息
    @PostMapping("user/deleteUser")
    public ResponseEntity<Integer> deleteUser(@RequestParam int uid) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(uid));
    }

    //前端用户后台接口

    @ApiOperation(value="微信一键登录", httpMethod = "POST",response =User.class,notes="微信一键登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "wx.login()生成的code", required = true, dataType = "String", paramType = "query")
    })
    //微信一键登录
    @PostMapping("user/login")
    public ResponseEntity<User> login(@RequestParam String code) {
        User user = userService.Login(code);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @ApiOperation(value="获得用户的详细信息", httpMethod = "POST",response =User.class,notes="获得用户的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openid", value = "用户的唯一标识", required = true, dataType = "String", paramType = "query")
    })
    //获得用户的详细信息
    @PostMapping("user/getUserInfoByOpenid")
    public ResponseEntity<User> getUserInfoByOpenid(@RequestParam String openid) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfoByOpenid(openid));
    }
}


