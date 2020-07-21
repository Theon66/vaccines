package cn.yxyz.vaccines.service;

import cn.yxyz.vaccines.pojo.InoculationRecord;

import java.util.List;

public interface InoculationRecordService {
    int addInoculationRecord(InoculationRecord inoculationRecord);
    List<InoculationRecord> findInoculationRecord(String numberid);
    List<InoculationRecord> findAllInoculationRecord();
    int modifyInoculationRecord(InoculationRecord inoculationRecord);
    int deleteInoculationRecord(String iid);
}
