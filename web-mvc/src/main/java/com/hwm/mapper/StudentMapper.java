package com.hwm.mapper;

import com.hwm.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    @Select("SELECT * FROM student;")
    List<Student> selectAll();

    @Select("SELECT * FROM student WHERE id = #{studentId};")
    Student select(@Param("studentId") int studentId);

    @Insert("INSERT INTO student (id, name) VALUES (#{id}, #{name});")
    boolean addStudent(@Param("id") int id, @Param("name") String name);
}
