package com.example.zhaolei.service.impl;

import com.example.zhaolei.model.entity.Student;
import com.example.zhaolei.mapper.StudentMapper;
import com.example.zhaolei.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-07-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
