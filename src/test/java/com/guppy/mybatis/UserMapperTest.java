package com.guppy.mybatis;

import com.guppy.mybatis.repository.UserMapper;
import com.guppy.mybatis.repository.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by kanghonggu on 2017. 6. 25..
 */
@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private User entity;

    @Before
    public void setUp() {
        entity = new User();
        entity.setUserName("stunstun");

        userMapper.save(entity);

        // todo : List...
        entity = (User) userMapper.findByUserName("stunstun");
    }

    @Test
    public void insertAndDelete() {
        assertNotNull(entity);


        User user = (User) userMapper.findByUserName("stunstun");
        userMapper.delete(user);

        user = (User) userMapper.findByUserName("stunstun");
        assertNull(user);

    }

}
