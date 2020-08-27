package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.HealthInquiryMapper;
import cn.yxyz.vaccines.mapper.HealthRecordMapper;
import cn.yxyz.vaccines.pojo.HealthInquiry;
import cn.yxyz.vaccines.pojo.HealthRecord;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.HealthInquiryService;
import cn.yxyz.vaccines.service.HealthRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HealthInquiryServiceImp implements HealthInquiryService {
    private HealthInquiryMapper healthInquiryMapper;

    public HealthInquiryServiceImp(HealthInquiryMapper healthInquiryMapper) {
        this.healthInquiryMapper = healthInquiryMapper;
    }
    public List<HealthInquiry> findHealthInquiry(){
        QueryWrapper wrapper = new QueryWrapper<HealthInquiry>();
        return healthInquiryMapper.selectList(wrapper);
    }
}
