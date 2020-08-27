package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.Doctor;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.DoctorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class DoctorController {
    private DoctorService doctorService;
    private StringRedisTemplate stringRedisTemplate;

    public DoctorController(DoctorService doctorService,StringRedisTemplate stringRedisTemplate) {
        this.doctorService = doctorService;
        this.stringRedisTemplate = stringRedisTemplate;

    }
    @ApiOperation(value="获得所有医生信息", httpMethod = "POST",response = Integer.class,notes="获得所有医生信息")

    //查，获得所有医生信息
    @PostMapping("doctor/findAllDoctor")
    public ResponseEntity<List<Doctor>> findAllDoctor() {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.findAllDoctor());

    }


    @ApiOperation(value="添加医生信息", httpMethod = "POST",response = Integer.class,notes="添加医生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "doctor", value = "医生对象", required = true, dataType = "Doctor")
    })
    //添加，添加医生信息
    @PostMapping("doctor/addDoctor")
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.addDoctor(doctor));

    }

    @ApiOperation(value="修改医生信息", httpMethod = "POST",response = Integer.class,notes="修改医生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "doctor", value = "医生对象", required = true, dataType = "Doctor")
    })
    //修改，修改医生信息
    @PostMapping("doctor/modifyDoctor")
    public ResponseEntity<Integer> modifyDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.modifyDoctor(doctor));

    }
    @ApiOperation(value="删除医生信息", httpMethod = "POST",response = Integer.class,notes="删除医生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "did", value = "医生对象ID", required = true, dataType = "int")
    })
    //删除，删除医生信息
    @PostMapping("doctor/deleteDoctor")
    public ResponseEntity<Integer> deleteDoctor(@RequestParam int did) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.deleteDoctor(did));

    }

    //前端用户后台接口
    @ApiOperation(value="注册", httpMethod = "Post",response =Integer.class,notes="注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "doctor", value = "医生对象", required = true, dataType = "Doctor")
    })
    //1、注册
    @PostMapping("doctor/register")
    public ResponseEntity<Integer> registerDoctor(@RequestBody Doctor doctor) {
        Integer a = new Integer(0);
        String s = stringRedisTemplate.opsForValue().get(doctor.getTelephone());
        if (doctor.getCode().equals(s)) {
            return ResponseEntity.status(HttpStatus.OK).body(doctorService.registerDoctor(doctor));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }


    @ApiOperation(value="登陆", httpMethod = "Post",response =Integer.class,notes="登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    //2、登陆
    @PostMapping("doctor/login")
    public ResponseEntity<Integer> loginDoctor(@RequestParam String telephone, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.loginDoctor(telephone, password));
    }


    @ApiOperation(value="忘记密码", httpMethod = "Post",response =Integer.class,notes="忘记密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newpassword", value = "新密码", required = true, dataType = "String", paramType = "query")
    })
    ///4、忘记密码
    @PostMapping("doctor/forgetPassword")
    public ResponseEntity<Integer> forgetPassword(@RequestParam String telephone, @RequestParam String code, @RequestParam String newpassword) {
        Integer a = new Integer(0);
        String s = stringRedisTemplate.opsForValue().get(telephone);
        System.out.println("SSSssssssssssssssss" + s);
        if (code.equals(s)) {
            return ResponseEntity.status(HttpStatus.OK).body(doctorService.forgetPassword(telephone, code, newpassword));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }


    @ApiOperation(value="修改个人中心", httpMethod = "Post",response =Integer.class,notes="修改个人中心")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "doctor", value = "医生对象", required = true, dataType = "Doctor")

    })
    //修改个人中心
    @PostMapping("doctor/modifyDoctorInfo")
    public ResponseEntity<Integer> modifyDoctorInfo(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.modifyDoctorInfo(doctor));

    }



    @ApiOperation(value="根据手机号获得医生详细信息", httpMethod = "Post",response =User.class,notes="根据手机号获得医生详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "电话号码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("doctor/getDoctorInfo")
    public ResponseEntity<List<Doctor>> getDoctorInfo(@RequestParam String telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getDoctorInfo(telephone));
    }





}
