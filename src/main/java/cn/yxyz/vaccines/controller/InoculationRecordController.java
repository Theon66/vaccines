package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.service.InoculationRecordService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InoculationRecordController {
    private InoculationRecordService inoculationrecordService;

    public InoculationRecordController(InoculationRecordService inoculationrecordService) {
        this.inoculationrecordService = inoculationrecordService;
    }

}
