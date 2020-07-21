package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.AppointRecord;
import cn.yxyz.vaccines.service.AppointRecordService;
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

    //添加预约记录
    @PostMapping("appointRecord/addAppointRecord")
    public ResponseEntity<Integer> addAppointRecord(@RequestBody AppointRecord addappointrecord) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.addAppointRecord(addappointrecord));

    }
    //根据身份证号查询预约记录
    @PostMapping("appointRecord/findAppointRecord")
    public ResponseEntity<List<AppointRecord>> findAppointRecord(@RequestParam String numberid) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAppointRecord(numberid));

    }
    //显示所有预约记录
    @PostMapping("appointRecord/findAllAppointRecord")
    public ResponseEntity<List<AppointRecord>> findAllAppointRecord() {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAllAppointRecord());

    }
    //修改预约记录
    @PostMapping("appointRecord/modifyAppointRecord")
    public ResponseEntity<Integer> modifyAppointRecord(@RequestBody AppointRecord appointrecord) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.modifyAppointRecord(appointrecord));

    }
  //删除预约记录
   @PostMapping("appointRecord/deleteAppointRecord")
   public ResponseEntity<Integer> deleteAppointRecord(@RequestParam String aid) {
       return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.deleteAppointRecord(aid));

   }
}
