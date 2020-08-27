package cn.yxyz.vaccines.service;


import cn.yxyz.vaccines.pojo.HealthRecord;

import java.util.List;

public interface HealthRecordService {
    int addHealth(HealthRecord healthRecord);
    List<HealthRecord> findAllHealth();
    int confHealthRecord(int aid);
    List<HealthRecord> findAllHealthByAid(int aid);
}
