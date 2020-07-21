package cn.yxyz.vaccines.service;

import cn.yxyz.vaccines.pojo.AppointRecord;

import java.util.List;

public interface AppointRecordService {
    int addAppointRecord(AppointRecord appointrecord);
    int modifyAppointRecord(AppointRecord appointrecord);
    List<AppointRecord> findAppointRecord(String numberid);
    List<AppointRecord> findAllAppointRecord();
    int deleteAppointRecord(String aid);
}
