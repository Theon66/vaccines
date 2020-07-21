package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.mapper.InoculationRecordMapper;
import cn.yxyz.vaccines.pojo.AppointRecord;
import cn.yxyz.vaccines.pojo.InoculationRecord;
import cn.yxyz.vaccines.service.InoculationRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InoculationRecordServiceImp implements InoculationRecordService {
    private InoculationRecordMapper inoculationrecordMapper;

    public InoculationRecordServiceImp(InoculationRecordMapper inoculationrecordMapper) {
        this.inoculationrecordMapper = inoculationrecordMapper;
    }
    @Override
    public int addInoculationRecord(InoculationRecord inoculationRecord){
        QueryWrapper<InoculationRecord> wrapper =new QueryWrapper<>();
        wrapper.eq("numberid",inoculationRecord.getNumberid());
        wrapper.eq("vname",inoculationRecord.getVname());
        InoculationRecord tempinoculationrecord=inoculationrecordMapper.selectOne(wrapper);
        if(tempinoculationrecord!=null){
            return 0;
        }
        return inoculationrecordMapper.insert(inoculationRecord);
    }
    @Override
    public  List<InoculationRecord> findInoculationRecord(String numberid){
        QueryWrapper<InoculationRecord> wrapper=new QueryWrapper<>();
        wrapper.eq("numberid",numberid);
        return inoculationrecordMapper.selectList(wrapper);
    }
    @Override
    public List<InoculationRecord> findAllInoculationRecord(){
        QueryWrapper<InoculationRecord> wrapper=new QueryWrapper<>();
        return inoculationrecordMapper.selectList(wrapper);
    }
    @Override
    public int modifyInoculationRecord(InoculationRecord inoculationRecord){
        return inoculationrecordMapper.updateById(inoculationRecord);
    }
    @Override
    public int deleteInoculationRecord(String iid){
        QueryWrapper<InoculationRecord> wrapper=new QueryWrapper<>();
        wrapper.eq("iid",iid);
        return inoculationrecordMapper.delete(wrapper);
    }
}
