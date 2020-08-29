package cn.yxyz.vaccines.controller;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    //后台管理系统


    //后台管理获得用户信息查
    @ApiOperation(value="后台管理获得所有用户信息", httpMethod = "Post",response =User.class,notes="后台管理获得用户信息")
    @PostMapping("user/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());

    }
    @ApiOperation(value="后台管理添加用户信息", httpMethod = "Post",response =Integer.class,notes="后台管理添加用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    })
    //后台管理添加用户信息
    @PostMapping("user/addUser")
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));

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
    @ApiOperation(value="注册", httpMethod = "Post",response =Integer.class,notes="后台管理删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    })
    //1、注册
    @PostMapping("user/register")
    public ResponseEntity<Integer> registerUser(@RequestBody User user) {
        Integer a = new Integer(0);
        String s = stringRedisTemplate.opsForValue().get(user.getTelephone());
        if (user.getCode().equals(s)) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(user));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @ApiOperation(value="登陆", httpMethod = "Post",response =Integer.class,notes="登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    //2、登陆
    @PostMapping("user/login")
    public ResponseEntity<User> loginUser(@RequestParam String telephone, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(telephone, password));
    }



    @ApiOperation(value="修改密码", httpMethod = "Post",response =Integer.class,notes="修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldpassword", value = "旧密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newpassword", value = "新密码", required = true, dataType = "String", paramType = "query")
    })
    //3、修改密码
    @PostMapping("user/modifyPassword")
    public ResponseEntity<Integer> modifyPassword(@RequestParam String oldpassword, @RequestBody String newpassword) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyPassword(oldpassword, newpassword));
    }
    @ApiOperation(value="忘记密码", httpMethod = "Post",response =Integer.class,notes="忘记密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newpassword", value = "新密码", required = true, dataType = "String", paramType = "query")
    })
    ///4、忘记密码
    @PostMapping("user/forgetPassword")
    public ResponseEntity<Integer> forgetPassword(@RequestParam String telephone, @RequestParam String code, @RequestParam String newpassword) {
        Integer a = new Integer(0);
        String s = stringRedisTemplate.opsForValue().get(telephone);
        System.out.println("SSSssssssssssssssss" + s);
        if (code.equals(s)) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.forgetPassword(telephone, code, newpassword));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @ApiOperation(value="发送短信", httpMethod = "Post",response =Object.class,notes="发送短信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, dataType = "String")

    })
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
    @ApiOperation(value="修改个人中心", httpMethod = "Post",response =Integer.class,notes="修改个人中心")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")

    })
    //修改个人中心
    @PostMapping("user/modifyUserInfo")
    public ResponseEntity<Integer> modifyUserInfo(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyUserInfo(user));

    }



    @ApiOperation(value="根据手机号获得用户详细信息", httpMethod = "Post",response =User.class,notes="根据手机号获得用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "电话号码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("user/getUserInfo")
    public ResponseEntity<List<User>> getUserInfo(@RequestParam String telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfo(telephone));
    }
    @ApiOperation(value="根据身份证号获得用户详细信息", httpMethod = "Post",response =User.class,notes="根据身份证号获得用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nubmerid", value = "身份证号", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("user/getUserInfoByNum")
    public ResponseEntity<List<User>> getUserInfoByNum(@RequestParam String numberid) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfoByNum(numberid));
    }
    @ApiOperation(value="切换家长", httpMethod = "Post",response =User.class,notes="切换家长")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "numberid", value = "身份证号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "relation", value = "关系", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("user/changeUserInfoByNum")
    public ResponseEntity<List<User>> changeUserInfoByNum(@RequestParam String numberid,@RequestParam String relation) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.changeUserInfoByNum(numberid,relation));
    }

}


