package cn.yxyz.vaccines.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("appointrecord")
public class AppointRecord {
    @TableId(type = IdType.AUTO)
    private int aid;//预约记录ID
    private String name;//接种者姓名

    private String vname;//预约疫苗名称
    private String vaccinationsite;//接种部位

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;//预约时间
    private String place;//预约地点
    private String doctor;//预约医生
    private String department;//预约医生的科室
    private String job;//预约医生的职务
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberid() {
        return numberid;
    }

    public void setNumberid(String numberid) {
        this.numberid = numberid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVaccinationsite() {
        return vaccinationsite;
    }

    public void setVaccinationsite(String vaccinationsite) {
        this.vaccinationsite = vaccinationsite;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String numberid;//接种者身份证号
    private String telephone;//家长电话







}
