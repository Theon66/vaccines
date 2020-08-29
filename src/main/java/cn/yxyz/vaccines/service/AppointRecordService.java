package cn.yxyz.vaccines.service;

import cn.yxyz.vaccines.pojo.AppointRecord;

import java.util.List;

public interface AppointRecordService {
    int addAppointRecord(AppointRecord appointrecord);
    int modifyAppointRecord(AppointRecord appointrecord);
    List<AppointRecord> findAppointRecord(String numberid);
    List<AppointRecord> findAllAppointRecord();
    int deleteAppointRecord(String aid);
    AppointRecord findAppointRecordByaid(String aid);
    List<AppointRecord> findAppointRecordByTel(String telephone);
    int updateLetterFirst(int aid,String letterfirst);
    int updateLetterSecond(int aid,String letterfirst);
    int updateLetterThird(int aid,String letterfirst);
    int doctorConfirm(int aid);
    int doctorAutograph(int aid,String doctorautograph);
    int userAutograph(int aid,String userautograph);
    List<AppointRecord> selectAppointRecord(String startTime,String endTime);
    List<AppointRecord> findAppointRecordByName(String name);
}
