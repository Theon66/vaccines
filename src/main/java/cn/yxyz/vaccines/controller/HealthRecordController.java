package cn.yxyz.vaccines.controller;


import cn.yxyz.vaccines.pojo.HealthInquiry;
import cn.yxyz.vaccines.pojo.HealthRecord;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.HealthRecordService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HealthRecordController {
    private HealthRecordService healthrecordService;

    public HealthRecordController(HealthRecordService healthrecordService) {
        this.healthrecordService = healthrecordService;
    }
    @ApiOperation(value="添加健康询问记录", httpMethod = "Post",response =Integer.class,notes="添加健康询问记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "healthRecord", value = "健康询问记录对象", required = true, dataType = "HealthRecord")
    })
    //后台管理添加用户信息
    @PostMapping("health/addHealthRecord")
    public ResponseEntity<Integer> addHealth(@RequestBody HealthRecord healthRecord) {
        return ResponseEntity.status(HttpStatus.OK).body(healthrecordService.addHealth(healthRecord));

    }




    @ApiOperation(value="显示所有健康询问记录", httpMethod = "Post",response =Integer.class,notes="显示所有健康询问记录")

    //后台管理添加用户信息
    @PostMapping("health/findAllHealthRecord")
    public ResponseEntity<List<HealthRecord>> findAllHealth() {
        return ResponseEntity.status(HttpStatus.OK).body(healthrecordService.findAllHealth());

    }
    @ApiOperation(value="医生确认健康询问表", httpMethod = "Post",response =Integer.class,notes="医生确认健康询问表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "健康询问记录aid", required = true, dataType = "int")
    })
   //医生确认健康询问表
    @PostMapping("health/confHealthRecord")
    public ResponseEntity<Integer> confHealthRecord(@RequestParam int aid) {
        return ResponseEntity.status(HttpStatus.OK).body(healthrecordService.confHealthRecord(aid));

    }


    @ApiOperation(value="根据aid获得健康询问记录表", httpMethod = "Post",response =Integer.class,notes="根据aid获得健康询问记录表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "健康询问记录aid", required = true, dataType = "int")
    })
    //根据aid获得健康询问记录表
    @PostMapping("health/findAllHealthByAid")
    public ResponseEntity<List<HealthRecord>> findAllHealthByAid(@RequestParam int aid) {
        return ResponseEntity.status(HttpStatus.OK).body(healthrecordService.findAllHealthByAid(aid));

    }
}
