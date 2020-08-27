package cn.yxyz.vaccines.mapper;

import cn.yxyz.vaccines.pojo.HealthInquiry;
import cn.yxyz.vaccines.pojo.HealthRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface HealthRecordMapper extends BaseMapper<HealthRecord> {
    @Update("update healthrecord set conf=1 where aid= #{aid}")
    int updateConfByAid(@Param("aid") int aid);


}
