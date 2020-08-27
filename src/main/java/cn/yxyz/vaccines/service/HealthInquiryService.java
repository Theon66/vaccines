package cn.yxyz.vaccines.service;


import cn.yxyz.vaccines.pojo.HealthInquiry;
import cn.yxyz.vaccines.pojo.HealthRecord;

import java.util.List;

public interface HealthInquiryService {
    List<HealthInquiry> findHealthInquiry();
}
