package com.example.zhaolei.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.zhaolei.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.print.Pageable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuan
 * @since 2020-07-08
 */
public interface UserService extends IService<User> {


    public IPage<User> getUserList(long page, long size,User user);
}
