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

import java.util.List;

import static org.junit.Assert.assertEquals;
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
        List<User> userList
                = userMapper.findByUserName("stunstun");

        assertNotNull(userList);

    }

    @Test
    public void insertAndDelete() {
        assertNotNull(entity);

        List<User> users = userMapper.findByUserName("stunstun");
        userMapper.delete(users.get(0));

        List<User> deleteUsers = userMapper.findByUserName("stunstun");
        assertEquals(0, deleteUsers.size());

    }

}
