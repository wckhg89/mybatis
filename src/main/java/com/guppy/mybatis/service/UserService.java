package com.guppy.mybatis.service;

import com.guppy.mybatis.repository.UserMapper;
import com.guppy.mybatis.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kanghonggu on 2017. 6. 27..
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User findOne (Long id) {
        return userMapper.findOne(id);
    }

}
