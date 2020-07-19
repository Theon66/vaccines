package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.AppointRecordMapper;

import cn.yxyz.vaccines.pojo.AppointRecord;

import cn.yxyz.vaccines.service.AppointRecordService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

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
}