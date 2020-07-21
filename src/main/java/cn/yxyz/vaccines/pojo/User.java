package cn.yxyz.vaccines.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.xml.crypto.Data;
import java.sql.Date;

@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private int uid;//用户ID
    private String username;//用户名
    private String password;//密码
    private String name;//姓名
    private String gender;//性别


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private String birthday;//出生日期
    private String numberid;//身份证号
    private String telephone;//手机号
    private String relation;//与本人关系
    private String address;//家庭住址
    private String birthhospital;//出生医院
    private String residencepermit;//居住证明
    private String birthcertificate;//出生证明
    private String ykrecord;//乙肝和卡介苗接种记录

    private String code;//验证码

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthhospital() {
        return birthhospital;
    }

    public void setBirthhospital(String birthhospital) {
        this.birthhospital = birthhospital;
    }

    public String getResidencepermit() {
        return residencepermit;
    }

    public void setResidencepermit(String residencepermit) {
        this.residencepermit = residencepermit;
    }

    public String getBirthcertificate() {
        return birthcertificate;
    }

    public void setBirthcertificate(String birthcertificate) {
        this.birthcertificate = birthcertificate;
    }

    public String getYkrecord() {
        return ykrecord;
    }

    public void setYkrecord(String ykrecord) {
        this.ykrecord = ykrecord;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
