package com.example.zhaolei.controller;


import com.example.zhaolei.model.entity.Student;
import com.example.zhaolei.model.entity.User;
import com.example.zhaolei.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-07-16
 */
@Api(value = "学生模块")
@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;



    /**
     * http://localhost:8080/api/student/getStudent?id=901
     */
    @ApiOperation("根据ID查学生")
    @GetMapping("/getStudent")
    public Student getStudentById(@RequestParam("id")Integer id){
        log.info(id.toString());
        Student student = studentService.getById(id);
        log.info(student.toString());
        return student;
    }

}
