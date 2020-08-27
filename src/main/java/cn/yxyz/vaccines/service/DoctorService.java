package cn.yxyz.vaccines.service;

import cn.yxyz.vaccines.pojo.Doctor;
import cn.yxyz.vaccines.pojo.User;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAllDoctor();
    int addDoctor(Doctor doctor);
    int modifyDoctor(Doctor doctor);

    int deleteDoctor(int did);
    int registerDoctor(Doctor doctor);

    int loginDoctor(String telephone, String password);



    int forgetPassword(String telephone, String code, String newpassword);

    List<Doctor> getDoctorInfo(String telephone);

    int modifyDoctorInfo(Doctor doctor);



}
