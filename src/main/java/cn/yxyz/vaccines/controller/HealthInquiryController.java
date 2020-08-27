package cn.yxyz.vaccines.controller;


import cn.yxyz.vaccines.pojo.HealthInquiry;
import cn.yxyz.vaccines.pojo.HealthRecord;
import cn.yxyz.vaccines.service.HealthInquiryService;
import cn.yxyz.vaccines.service.HealthRecordService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HealthInquiryController {
    private HealthInquiryService healthInquiryService;

    public HealthInquiryController(HealthInquiryService healthInquiryService) {
        this.healthInquiryService = healthInquiryService;
    }
    @ApiOperation(value="显示健康询问", httpMethod = "Post",response =Integer.class,notes="显示健康询问")

    //显示健康询问
    @PostMapping("healthinquiry/findHealthInquiry")
    public ResponseEntity<List<HealthInquiry>> findHealthInquiry() {
        return ResponseEntity.status(HttpStatus.OK).body(healthInquiryService.findHealthInquiry());

    }


}
