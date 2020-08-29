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

    @ApiOperation(value="根据手机号查询预约记录", httpMethod = "POST",response = AppointRecord.class,notes="根据手机号查询预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, dataType = "String", paramType = "query")
    })
    //根据手机号查询预约记录
    @PostMapping("appointRecord/findAppointRecordByTel")
    public ResponseEntity<List<AppointRecord>> findAppointRecordByTel(@RequestParam String telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAppointRecordByTel(telephone));

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

    @ApiOperation(value="根据Aid获得预约记录", httpMethod = "POST",response = Integer.class,notes="根据Aid获得预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "String", paramType = "query")
    })
    //根据Aid获得预约记录
    @PostMapping("appointRecord/findAppointRecordByaid")
    public ResponseEntity<AppointRecord> findAppointRecordByaid(@RequestParam String aid) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAppointRecordByaid(aid));

    }
    //根据aid插入电子告知书第一步（电子告知书和健康询问表）
    @ApiOperation(value="根据aid插入电子告知书第一步（电子告知书和健康询问表）", httpMethod = "POST",response = Integer.class,notes="根据aid插入电子告知书第一步（电子告知书和健康询问表）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "letterfirst", value = "文档链接", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("appointRecord/updateLetterFirst")
    public ResponseEntity<Integer> updateLetterFirst(@RequestParam int aid,@RequestParam String letterfirst) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.updateLetterFirst(aid,letterfirst));

    }
    //根据aid插入电子告知书第二步（电子告知书和健康询问表，用户签名）
    @ApiOperation(value="根据aid插入电子告知书第二步（电子告知书和健康询问表，用户签名）", httpMethod = "POST",response = Integer.class,notes="根据aid插入电子告知书第二步（电子告知书和健康询问表，用户签名）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "lettersecond", value = "文档链接", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("appointRecord/updateLetterSecond")
    public ResponseEntity<Integer> updateLetterSecond(@RequestParam int aid,@RequestParam String lettersecond) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.updateLetterSecond(aid,lettersecond));

    }
    //根据aid插入电子告知书第三步（电子告知书和健康询问表，医生签名）
    @ApiOperation(value="根据aid插入电子告知书第三步（电子告知书和健康询问表，医生签名）", httpMethod = "POST",response = Integer.class,notes="根据aid插入电子告知书第三步（电子告知书和健康询问表，医生签名）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "letterthird", value = "文档链接", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("appointRecord/updateLetterThird")
    public ResponseEntity<Integer> updateLetterThird(@RequestParam int aid,@RequestParam String letterthird) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.updateLetterThird(aid,letterthird));

    }


    //医生确认预约记录
    @ApiOperation(value="医生确认预约记录", httpMethod = "POST",response = Integer.class,notes="医生确认预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "int", paramType = "query")

    })
    @PostMapping("appointRecord/doctorConfirm")
    public ResponseEntity<Integer> doctorConfirm(@RequestParam int aid) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.doctorConfirm(aid));

    }

    //医生上传签名
    @ApiOperation(value="医生上传签名", httpMethod = "POST",response = Integer.class,notes="医生上传签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "doctorautograph", value = "医生签名的服务器链接", required = true, dataType = "String", paramType = "query")

    })
    @PostMapping("appointRecord/doctorAutograph")
    public ResponseEntity<Integer> doctorAutograph(@RequestParam int aid,@RequestParam String doctorautograph) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.doctorAutograph(aid,doctorautograph));

    }
    //用户上传签名
    @ApiOperation(value="用户上传签名", httpMethod = "POST",response = Integer.class,notes="用户上传签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "userautograph", value = "医生签名的服务器链接", required = true, dataType = "String", paramType = "query")

    })
    @PostMapping("appointRecord/userAutograph")
    public ResponseEntity<Integer> userAutograph(@RequestParam int aid,@RequestParam String userautograph) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.userAutograph(aid,userautograph));

    }



    @ApiOperation(value="查询指定时间段的预约记录", httpMethod = "POST",response = Integer.class,notes="取消预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "预约记录的ID", required = true, dataType = "String",paramType = "query")
    })
    //取消预约记录
    @PostMapping("appointRecord/selectAppointRecord")
    public ResponseEntity<List<AppointRecord>> selectAppointRecord(@RequestParam String startTime,@RequestParam String endTime) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.selectAppointRecord(startTime,endTime));

    }
    @ApiOperation(value="根据name获得预约记录", httpMethod = "POST",response = Integer.class,notes="根据name获得预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "query")
    })
    //根据name获得预约记录
    @PostMapping("appointRecord/findAppointRecordByName")
    public ResponseEntity<List<AppointRecord>> findAppointRecordByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAppointRecordByName(name));

    }
}
