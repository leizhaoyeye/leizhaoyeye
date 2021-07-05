package com.example.zhaolei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zhaolei.model.entity.User;
import com.example.zhaolei.mapper.UserMapper;
import com.example.zhaolei.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Condition;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-07-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     * @param page
     * @param size
     * @param user
     * @return
     */
    @Override
    public IPage<User> getUserList(long page, long size,User user) {
        /*QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq(StringUtils.isNotEmpty(String.valueOf(user.getId())), "id ",
                user.getId())
                .eq(StringUtils.isNotEmpty(user.getUserName()), "user_name",
                        user.getUserName())
                .eq(StringUtils.isNotEmpty(user.getPsasWord()), "psas_word",
                        user.getPsasWord());
        ;
        queryWrapper.orderBy(true,false);*/
        IPage<User> iPage = userMapper.selectPage(new Page<User>(page, size),null);
        return iPage;
    }

}
