package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.AppointRecord;
import cn.yxyz.vaccines.pojo.InoculationRecord;
import cn.yxyz.vaccines.service.InoculationRecordService;
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
public class InoculationRecordController {
    private InoculationRecordService inoculationrecordService;

    public InoculationRecordController(InoculationRecordService inoculationrecordService) {
        this.inoculationrecordService = inoculationrecordService;
    }
    @ApiOperation(value="添加接种记录", httpMethod = "POST",response = Integer.class,notes="添加接种记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inoculationRecord", value = "接种记录对象", required = true, dataType = "InoculationRecord")
    })
    //添加接种记录
    @PostMapping("inoculationRecord/addInoculationRecord")
    public ResponseEntity<Integer> addInoculationRecord(@RequestBody InoculationRecord inoculationRecord) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.addInoculationRecord(inoculationRecord));

    }

    @ApiOperation(value="根据身份证号获得接种记录", httpMethod = "POST",response = InoculationRecord.class,notes="根据身份证号获得接种记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "numberid", value = "身份证号", required = true, dataType = "String", paramType = "query")
    })
    //根据身份证号获得接种记录
    @PostMapping("inoculationRecord/findInoculationRecord")
    public ResponseEntity<List<InoculationRecord>> findInoculationRecord(@RequestParam String numberid) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.findInoculationRecord(numberid));

    }

    @ApiOperation(value="显示所有接种记录", httpMethod = "POST",response = InoculationRecord.class,notes="显示所有接种记录")
    //显示所有接种记录
    @PostMapping("inoculationRecord/findAllInoculationRecord")
    public ResponseEntity<List<InoculationRecord>> findAllInoculationRecord() {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.findAllInoculationRecord());

    }
    @ApiOperation(value="修改接种记录", httpMethod = "POST",response = Integer.class,notes="修改接种记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inoculationRecord", value = "接种记录对象", required = true, dataType = "InoculationRecord")
    })
    //修改接种记录
    @PostMapping("inoculationRecord/modifyInoculationRecord")
    public ResponseEntity<Integer> modifyInoculationRecord(@RequestBody InoculationRecord inoculationRecord) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.modifyInoculationRecord(inoculationRecord));

    }

    @ApiOperation(value="删除接种记录", httpMethod = "POST",response = Integer.class,notes="删除接种记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "iid", value = "接种记录对象ID", required = true, dataType = "String", paramType = "query")
    })
    //删除接种记录
    @PostMapping("inoculationRecord/deleteInoculationRecord")
    public ResponseEntity<Integer> deleteInoculationRecord(@RequestParam String iid) {
        return ResponseEntity.status(HttpStatus.OK).body(inoculationrecordService.deleteInoculationRecord(iid));

    }
}
