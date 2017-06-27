package com.guppy.mybatis.config;

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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataSourceTest {

    private static Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

    @Autowired
    private DataSource ds;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void testConnection() throws Exception{ //작성
        logger.info("DataSource - {}", ds);

        Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고
        logger.info("Connection - {}", con);

        con.close(); //close
    }

    @Test
    public void testSqlSessionTemplate () {
        assertNotNull(sqlSessionTemplate);
    }

}
