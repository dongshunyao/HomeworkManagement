package com.hwm.mapper;

import com.hwm.model.SubmitHomework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SubmitHomeworkMapper {
    @Select("SELECT * FROM submit_homework WHERE homework_id = #{homeworkId};")
    List<SubmitHomework> select(@Param("homeworkId") int homeworkId);

    @Insert("INSERT INTO submit_homework (student_id, homework_id, homework_title, homework_content) VALUES (#{studentId}, #{homeworkId}, #{homeworkTitle}, #{homeworkContent});")
    boolean addSubmitHomework(@Param("studentId") int studentId,
                              @Param("homeworkId") int homeworkId,
                              @Param("homeworkTitle") String homeworkTitle,
                              @Param("homeworkContent") String homeworkContent);
}
