package cn.yxyz.vaccines.service;


import cn.yxyz.vaccines.pojo.Vaccines;

import java.util.List;

public interface VaccinesService {

    List<Vaccines> findAllVaccines();

    int addVaccines(Vaccines vaccines);

    int modifyVaccines(Vaccines vaccines);

    int deleteVaccines(int vid);
}
