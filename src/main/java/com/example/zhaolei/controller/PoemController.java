package com.example.zhaolei.controller;


import com.example.zhaolei.service.PoemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-08-11
 */
@Slf4j
@Controller
@RequestMapping("/poem")
public class PoemController {

    @Autowired
    private PoemService poemService;


}
