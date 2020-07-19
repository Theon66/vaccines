package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.VaccinesMapper;
import cn.yxyz.vaccines.pojo.Vaccines;
import cn.yxyz.vaccines.service.VaccinesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinesServiceImp implements VaccinesService {
    private VaccinesMapper vaccinesMapper;

    public VaccinesServiceImp(VaccinesMapper vaccinesMapper) {
        this.vaccinesMapper = vaccinesMapper;
    }

    @Override
    public List<Vaccines> findAllVaccines(){
        QueryWrapper<Vaccines> wrapper =new QueryWrapper<>();
        return  vaccinesMapper.selectList(wrapper);
    }
    @Override
    public int addVaccines(Vaccines vaccines){
        QueryWrapper<Vaccines> wrapper =new QueryWrapper<>();
        wrapper.eq("vname",vaccines.getVname());
        Vaccines tempvaccines=vaccinesMapper.selectOne(wrapper);
        if(tempvaccines!=null){
            return 0;
        }
        return vaccinesMapper.insert(vaccines);
    }
    @Override
    public int modifyVaccines(Vaccines vaccines){

        return vaccinesMapper.updateById(vaccines);
    }
    @Override
    public int deleteVaccines(int vid){
        QueryWrapper<Vaccines> wrapper =new QueryWrapper<>();
        wrapper.eq("vid",vid);
        return vaccinesMapper.delete(wrapper);
    }
}