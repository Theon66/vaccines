package cn.yxyz.vaccines.mapper;

import cn.yxyz.vaccines.pojo.AppointRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppointRecordMapper extends BaseMapper<AppointRecord> {
    @Update("update appointrecord set letterfirst=#{letterfirst} where aid= #{aid}")
    int updateLetterFirst(@Param("aid") int aid,@Param("letterfirst") String  letterfirst);

    @Update("update appointrecord set lettersecond=#{lettersecond} where aid= #{aid}")
    int updateLetterSecond(@Param("aid") int aid,@Param("lettersecond") String  lettersecond);

    @Update("update appointrecord set letterthird=#{letterthird} where aid= #{aid}")
    int updateLetterThird(@Param("aid") int aid,@Param("letterthird") String  letterthird);

    @Update("update appointrecord set doctorconfirm=1 where aid= #{aid}")
    int doctorConfirm(@Param("aid") int aid);

    @Update("update appointrecord set doctorautograph=#{doctorautograph} where aid= #{aid}")
    int doctorAutograph(@Param("aid") int aid,@Param("doctorautograph") String  doctorautograph);

    @Update("update appointrecord set userautograph=#{userautograph} where aid= #{aid}")
    int userAutograph(@Param("aid") int aid,@Param("userautograph") String  userautograph);

    @Select("select * from appointrecord where letterthird!='null' order by time asc")
    List<AppointRecord> findAllAppointRecord();
    @Select("select * from appointrecord where letterthird ='null'")
    List<AppointRecord> findAllAppointRecordNull();
}
