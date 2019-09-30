package com.mydemo.controller;

import com.mydemo.mapper.StudentMapper;
import com.mydemo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author wuwei
 * @create 2019/9/30 9:24
 * @desc
 **/
@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentMapper.getAll();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return studentMapper.getStudent(id);
    }

    @PostMapping("/add")
    public Long save(@RequestBody Student student) {
        student.setCreateDate(new Date());
        log.info("插入学生");
        return studentMapper.insertStudent(student);
    }

    @PostMapping("/update")
    public Long update(@RequestBody Student student) {
        return studentMapper.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public Long delete(@PathVariable("id") String id) {
        return studentMapper.deleteStudent(id);
    }
}
