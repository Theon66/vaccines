package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.HealthRecordMapper;

import cn.yxyz.vaccines.pojo.HealthRecord;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.HealthRecordService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HealthRecordServiceImp implements HealthRecordService {
    private HealthRecordMapper healthrecordMapper;

    public HealthRecordServiceImp(HealthRecordMapper healthrecordMapper) {
        this.healthrecordMapper = healthrecordMapper;
    }
    public int addHealth(HealthRecord healthRecord){
        QueryWrapper wrapper = new QueryWrapper<HealthRecord>();
        wrapper.eq("aid", healthRecord.getAid());
        wrapper.eq("name",healthRecord.getName());
        HealthRecord tempHealthRecord = healthrecordMapper.selectOne(wrapper);
        if (tempHealthRecord != null)
            return 0;
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword());
        return healthrecordMapper.insert(healthRecord);
    }
    public List<HealthRecord> findAllHealth(){
        QueryWrapper wrapper = new QueryWrapper<HealthRecord>();
        return healthrecordMapper.selectList(wrapper);
    }

    public int confHealthRecord(int aid){
        return healthrecordMapper.updateConfByAid(aid);
    }
    public List<HealthRecord> findAllHealthByAid(int aid){
        QueryWrapper wrapper = new QueryWrapper<HealthRecord>();
        wrapper.eq("aid",aid);
        return healthrecordMapper.selectList(wrapper);
    }

}
