package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.AppointRecord;
import cn.yxyz.vaccines.pojo.InoculationRecord;
import cn.yxyz.vaccines.service.InoculationRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InoculationRecordController {
    private InoculationRecordService inoculationrecordService;

    public InoculationRecordController(InoculationRecordService inoculationrecordService) {
        this.inoculationrecordService = inoculationrecordService;
    }
    //添加接种记录
    @PostMapping("inoculationRecord/addInoculationRecord")
    public ResponseEntity<Integer> addInoculationRecord(@RequestBody InoculationRecord inoculationRecord) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.addInoculationRecord(inoculationRecord));

    }
    //根据身份证号获得预约记录
    @PostMapping("inoculationRecord/findInoculationRecord")
    public ResponseEntity<List<InoculationRecord>> findInoculationRecord(@RequestParam String numberid) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.findInoculationRecord(numberid));

    }
    //显示所有接种记录
    @PostMapping("inoculationRecord/findAllInoculationRecord")
    public ResponseEntity<List<InoculationRecord>> findAllInoculationRecord() {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.findAllInoculationRecord());

    }
    //修改接种记录
    @PostMapping("inoculationRecord/modifyInoculationRecord")
    public ResponseEntity<Integer> modifyInoculationRecord(@RequestBody InoculationRecord inoculationRecord) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.modifyInoculationRecord(inoculationRecord));

    }
    //删除接种记录
    @PostMapping("inoculationRecord/deleteInoculationRecord")
    public ResponseEntity<Integer> deleteInoculationRecord(@RequestParam String iid) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.deleteInoculationRecord(iid));

    }
}
