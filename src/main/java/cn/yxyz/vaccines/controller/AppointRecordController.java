package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.AppointRecord;
import cn.yxyz.vaccines.service.AppointRecordService;
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
public class AppointRecordController {
    private AppointRecordService appointrecordService;

    public AppointRecordController(AppointRecordService appointrecordService) {
        this.appointrecordService = appointrecordService;
    }

    @ApiOperation(value="添加预约记录", httpMethod = "POST",response = Integer.class,notes="添加预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addappointrecord", value = "预约记录对象", required = true, dataType = "AppointRecord")
    })
    //添加预约记录
    @PostMapping("appointRecord/addAppointRecord")
    public ResponseEntity<Integer> addAppointRecord(@RequestBody AppointRecord addappointrecord) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.addAppointRecord(addappointrecord));

    }

    @ApiOperation(value="根据身份证号查询预约记录", httpMethod = "POST",response = AppointRecord.class,notes="根据身份证号查询预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "numberid", value = "身份证号", required = true, dataType = "String", paramType = "query")
    })
    //根据身份证号查询预约记录
    @PostMapping("appointRecord/findAppointRecord")
    public ResponseEntity<List<AppointRecord>> findAppointRecord(@RequestParam String numberid) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAppointRecord(numberid));

    }

    @ApiOperation(value="显示所有预约记录", httpMethod = "POST",response = AppointRecord.class,notes="显示所有预约记录")

    //显示所有预约记录
    @PostMapping("appointRecord/findAllAppointRecord")
    public ResponseEntity<List<AppointRecord>> findAllAppointRecord() {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAllAppointRecord());

    }

    @ApiOperation(value="修改预约记录", httpMethod = "POST",response = Integer.class,notes="修改预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appointrecord", value = "预约记录对象", required = true, dataType = "AppointRecord")
    })
    //修改预约记录
    @PostMapping("appointRecord/modifyAppointRecord")
    public ResponseEntity<Integer> modifyAppointRecord(@RequestBody AppointRecord appointrecord) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.modifyAppointRecord(appointrecord));

    }

    @ApiOperation(value="删除预约记录", httpMethod = "POST",response = Integer.class,notes="删除预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "String", paramType = "query")
    })
  //删除预约记录
   @PostMapping("appointRecord/deleteAppointRecord")
   public ResponseEntity<Integer> deleteAppointRecord(@RequestParam String aid) {
       return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.deleteAppointRecord(aid));

   }
}
