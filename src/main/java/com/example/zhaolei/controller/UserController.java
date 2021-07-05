package com.example.zhaolei.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zhaolei.model.entity.User;
import com.example.zhaolei.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2020-07-08
 */

@Api(value = "用户接口")
@Slf4j
//  restcontroller（@ResponseBody（将java对象转成json返回）+@controller 这个小错误 ，哎    ）
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("打个招呼")
    @GetMapping("/hello")
    public  String sayHello (){
        System.out.println(System.currentTimeMillis());
        Map  aa  =new HashMap();
        return " Hello   Spring Boot ! ";
    }


    /**
     * http://localhost:8080/api/user/getOne?id=3
     */
    @ApiOperation("根据ID查用户")
    @GetMapping("/getOne")
    public User getUserById(@RequestParam("id") Integer id){
        User user = userService.getById(id);
        log.info(user.toString());
        return user;
    }


    @ApiOperation("测试上传文件夹")
    @PostMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("multipartFile")MultipartFile multipartFile){
        log.info(multipartFile.getName() );
        return "文件夹上传成功";
    }

    /**
     * http://localhost:8080/api/user/getOne?id=3
     */
    @ApiOperation("根据ID修改用户")
    @GetMapping("/updateOne")
    public User updateOne(@RequestParam("id") Integer id){
        User user = new User();
        user.setId(id);
        user.setUserName("赵磊");
        user.setPsasWord("zhaolei");
        boolean b = userService.updateById(user);
        User byId=null;
        if(b){
            byId= userService.getById(id);
        }
        log.info(byId.toString());
        return byId;
    }

    @ApiOperation("查询用户列表")
    @GetMapping("/getUserList")
    public IPage<User> getUserList(@RequestParam("page") long page, @RequestParam("size") long size ,User user){
        log.info("showList param:{}",user);
        IPage<User> userList = userService.getUserList(page, size,user);
        List<User> records = userList.getRecords();
        for (User u : records) {
            log.info(u.toString());
        }
        return userList;

    }
}
