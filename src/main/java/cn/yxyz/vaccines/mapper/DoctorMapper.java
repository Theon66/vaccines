package cn.yxyz.vaccines.mapper;

import cn.yxyz.vaccines.pojo.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DoctorMapper extends BaseMapper<Doctor> {

}
