package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.DoctorMapper;
import cn.yxyz.vaccines.pojo.Doctor;
import cn.yxyz.vaccines.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {
    private DoctorMapper doctorMapper;

    public DoctorServiceImp(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

}
