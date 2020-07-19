package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.InoculationRecordMapper;
import cn.yxyz.vaccines.service.InoculationRecordService;
import org.springframework.stereotype.Service;

@Service
public class InoculationRecordServiceImp implements InoculationRecordService {
    private InoculationRecordMapper inoculationrecordMapper;

    public InoculationRecordServiceImp(InoculationRecordMapper inoculationrecordMapper) {
        this.inoculationrecordMapper = inoculationrecordMapper;
    }




}
