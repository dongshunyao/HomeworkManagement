package com.hwm.mapper;

import com.hwm.model.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HomeworkMapper {
    @Select("SELECT * FROM homework;")
    List<Homework> selectAll();

    @Select("SELECT * FROM homework WHERE id = #{homeworkId};")
    Homework select(@Param("homeworkId") int homeworkId);

    @Insert("INSERT INTO homework (title, content) VALUES (#{title}, #{content});")
    boolean addHomework(@Param("title") String title, @Param("content") String content);
}
