package com.example.zhaolei.service.impl;

import com.example.zhaolei.model.entity.Poem;
import com.example.zhaolei.mapper.PoemMapper;
import com.example.zhaolei.service.PoemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuan
 * @since 2020-08-11
 */
@Service
public class PoemServiceImpl extends ServiceImpl<PoemMapper, Poem> implements PoemService {

}
