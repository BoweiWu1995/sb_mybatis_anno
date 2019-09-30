package com.mydemo.mapper;

import com.mydemo.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface StudentMapper {

    @Select("select * from student")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "age", column = "age"),
            @Result(property = "createDate", column = "create_date")
    })
    List<Student> getAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    Student getStudent(String id);

    @Insert("INSERT INTO student(id, nick_name, age, create_date) VALUES(#{id}, #{nickName}, #{age}, #{createDate})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true, statement = "select uuid() as id from dual")
    Long insertStudent(Student student);

    @Update("UPDATE student SET nick_name = #{nickName}, age = #{age} WHERE create_date = #{createDate}")
    Long updateStudent(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    Long deleteStudent(String id);
}
