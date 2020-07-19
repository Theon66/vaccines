package cn.yxyz.vaccines.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("inoculationrecord")
public class InoculationRecord {
    @TableId(type = IdType.AUTO)
    private int iid;//预约记录ID
    private String name;//接种者姓名
    private String numberid;//接种者身份证号
    private String telephone;//家长电话
    private String vname;//预约疫苗名称

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    private String vaccinationsite;//接种部位
    private Date time;//预约时间
    private String place;//预约地点
    private String doctor;//预约医生
    private String department;//预约医生的科室
    private String job;//预约医生的职务
}
