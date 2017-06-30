package com.guppy.mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by kanghonggu on 2017. 6. 30..
 */

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
@EnableRedisHttpSession
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}
