package com.guppy.mybatis.mapper;

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

/**
 * Created by kanghonggu on 2017. 6. 25..
 */
@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private User entity;

    @Before
    public void setUp() {
        entity = new User();
        entity.setUserName("stunstun");

        userMapper.save(entity);

        List<User> userList
                = userMapper.findByUserName("stunstun");

        assertNotNull(userList);

    }

    @Test
    public void findOneTest () {
        User user = userMapper.findOne(1L);

        assertNotNull(user);
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
