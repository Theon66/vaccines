package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.DoctorMapper;
import cn.yxyz.vaccines.pojo.Doctor;
import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.service.DoctorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {
    private DoctorMapper doctorMapper;

    public DoctorServiceImp(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }
    @Override
    public List<Doctor> findAllDoctor(){
        QueryWrapper wrapper=new QueryWrapper<Doctor>();
        return  doctorMapper.selectList(wrapper);
    }
    @Override
    public int addDoctor(Doctor doctor){
        QueryWrapper wrapper=new QueryWrapper<Doctor>();
        wrapper.eq("did",doctor.getDid());
        Doctor tempdoctor=doctorMapper.selectOne(wrapper);
        if(tempdoctor!=null){
            return 0;
        }
        return  doctorMapper.insert(doctor);
    }
    @Override
    public  int modifyDoctor(Doctor doctor){
        return  doctorMapper.updateById(doctor);
    }
    @Override
    public  int deleteDoctor(int did){
        QueryWrapper wrapper=new QueryWrapper<Doctor>();
        wrapper.eq("did",did);
        return  doctorMapper.delete(wrapper);
    }
    @Override
    public int registerDoctor(Doctor doctor){
        QueryWrapper wrapper = new QueryWrapper<Doctor>();
        wrapper.eq("telephone", doctor.getTelephone());
        Doctor tempDoctor = doctorMapper.selectOne(wrapper);
        if (tempDoctor != null)
            return 0;
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword());
        return doctorMapper.insert(doctor);
    }
    @Override
    public int loginDoctor(String telephone, String password){
        QueryWrapper wrapper = new QueryWrapper<Doctor>();
        wrapper.eq("telephone", telephone);
        wrapper.eq("password", password);
        Doctor tempDoctor = doctorMapper.selectOne(wrapper);
        if (tempDoctor != null) {
            return 1;
        }
        return 0;
    }
    @Override
    public int forgetPassword(String telephone, String code, String newpassword) {
        QueryWrapper wrapper = new QueryWrapper<Doctor>();
        Doctor doctor = new Doctor();
        doctor.setPassword(newpassword);
        doctor.setCode(code);
        wrapper.eq("telephone", telephone);

        return doctorMapper.update(doctor, wrapper);
    }
    @Override
    public int modifyDoctorInfo(Doctor doctor) {
        return doctorMapper.updateById(doctor);
    }
    @Override
    public List<Doctor> getDoctorInfo(String telephone) {
        QueryWrapper<Doctor> wrapper = new QueryWrapper<>();
        wrapper.eq("telephone", telephone);
        return doctorMapper.selectList(wrapper);
    }


}
