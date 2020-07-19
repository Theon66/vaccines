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
    //根据身份证号获得预约记录
    @PostMapping("appointRecord/findAppointRecord")
    public ResponseEntity<List<AppointRecord>> findAppointRecord(@RequestParam String numberid) {
        return ResponseEntity.status(HttpStatus.OK).body(appointrecordService.findAppointRecord(numberid));

    }

}
