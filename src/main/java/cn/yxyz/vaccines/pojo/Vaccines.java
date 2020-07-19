package cn.yxyz.vaccines.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("vaccines")
public class Vaccines {
    @TableId(type = IdType.AUTO)
    private int vid;//疫苗ID
    private String vname;//疫苗名称
    private String vclass;//疫苗种类
    private Date vaccinationtime;//可接种时间
    private String dosetimes;//剂次
    private String doseform;//剂型
    private String specifications;//规格
    private String manufactor;//厂家
    private double price;//疫苗价格

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVclass() {
        return vclass;
    }

    public void setVclass(String vclass) {
        this.vclass = vclass;
    }

    public Date getVaccinationtime() {
        return vaccinationtime;
    }

    public void setVaccinationtime(Date vaccinationtime) {
        this.vaccinationtime = vaccinationtime;
    }

    public String getDosetimes() {
        return dosetimes;
    }

    public void setDosetimes(String dosetimes) {
        this.dosetimes = dosetimes;
    }

    public String getDoseform() {
        return doseform;
    }

    public void setDoseform(String doseform) {
        this.doseform = doseform;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getConfirmationitem() {
        return confirmationitem;
    }

    public void setConfirmationitem(String confirmationitem) {
        this.confirmationitem = confirmationitem;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    private String video;//电子知情书介绍视频
    private String confirmationitem;//确认项
    private int state;//课程学习状态
    private String letter;//电子知情书文档





}
