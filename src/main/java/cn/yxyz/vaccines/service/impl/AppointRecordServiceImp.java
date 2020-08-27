package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.AppointRecordMapper;

import cn.yxyz.vaccines.pojo.AppointRecord;

import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.AppointRecordService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointRecordServiceImp implements AppointRecordService {
    private AppointRecordMapper appointrecordMapper;

    public AppointRecordServiceImp(AppointRecordMapper appointrecordMapper) {
        this.appointrecordMapper = appointrecordMapper;
    }
    @Override
    public int addAppointRecord(AppointRecord appointrecord){
        QueryWrapper<AppointRecord> wrapper =new QueryWrapper<>();
        wrapper.eq("numberid",appointrecord.getNumberid());
        wrapper.eq("vname",appointrecord.getVname());
        AppointRecord tempappointrecord=appointrecordMapper.selectOne(wrapper);
        if(tempappointrecord!=null){
            return 0;
        }
        return appointrecordMapper.insert(appointrecord);
    }
    @Override
    public List<AppointRecord> findAppointRecord(String numberid){
        QueryWrapper<AppointRecord> wrapper=new QueryWrapper<>();
        wrapper.eq("numberid",numberid);
        return appointrecordMapper.selectList(wrapper);
    }
    @Override
    public  List<AppointRecord> findAllAppointRecord(){
//有接种记录按时间排序
   //  QueryWrapper<AppointRecord> wrapper=new QueryWrapper<>();
        List<AppointRecord> appointRecordNoNull= appointrecordMapper.findAllAppointRecord();
        List<AppointRecord> appointRecordNull= appointrecordMapper.findAllAppointRecordNull();
        appointRecordNoNull.addAll(appointRecordNull);
        return appointRecordNoNull;
    }
    @Override
    public int modifyAppointRecord(AppointRecord appointrecord){
        return appointrecordMapper.updateById(appointrecord);
    }
    @Override
    public int deleteAppointRecord(String aid){
        QueryWrapper<AppointRecord> wrapper=new QueryWrapper<>();
        wrapper.eq("aid",aid);
        return appointrecordMapper.delete(wrapper);


    }
    @Override
    public AppointRecord findAppointRecordByaid(String aid){
        QueryWrapper<AppointRecord> wrapper=new QueryWrapper<>();
        wrapper.eq("aid",aid);
        return appointrecordMapper.selectOne(wrapper);
    }
    @Override
    public  List<AppointRecord> findAppointRecordByTel(String telephone){
        QueryWrapper<AppointRecord> wrapper=new QueryWrapper<>();
        wrapper.eq("telephone",telephone);
        return appointrecordMapper.selectList(wrapper);
    }
    @Override
    public int updateLetterFirst(int aid,String letterfirst){
        return appointrecordMapper.updateLetterFirst(aid,letterfirst);
    }
    @Override
    public int updateLetterSecond(int aid,String lettersecond){
        return appointrecordMapper.updateLetterSecond(aid,lettersecond);
    }
    @Override
    public int updateLetterThird(int aid,String letterthird){
        return appointrecordMapper.updateLetterThird(aid,letterthird);
    }
    @Override
    public int doctorConfirm(int aid){
        return appointrecordMapper.doctorConfirm(aid);
    }
    @Override
    public int doctorAutograph(int aid,String doctorautograph){
        return appointrecordMapper.doctorAutograph(aid,doctorautograph);
    }
    @Override
    public int userAutograph(int aid,String userautograph){
        return appointrecordMapper.userAutograph(aid,userautograph);
    }

}
