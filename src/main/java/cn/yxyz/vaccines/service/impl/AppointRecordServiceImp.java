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

    @Transactional
    public synchronized String appoint(/*参数*/) {
        //取出项目余额
        //项目余额小于等于0 return "预约失败，该日期人数已满";
        //项目余额减一
        //增加预约表
        return "预约成功";
    }
}
