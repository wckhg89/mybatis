package com.guppy.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import static org.junit.Assert.*;

/**
 * Created by kanghonggu on 2017. 6. 25..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private DataSource ds; //작성

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void testConnection() throws Exception{ //작성
        System.out.println("ds : "+ds);

        Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고

        System.out.println("con : "+con); //확인 후

        con.close(); //close
    }


    @Test
    public void testSqlSessionTemplate () {
        assertNotNull(sqlSessionTemplate);

    }

}
