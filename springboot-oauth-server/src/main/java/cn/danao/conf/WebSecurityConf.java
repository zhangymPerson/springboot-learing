package cn.danao.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author danao
 * @version 1.0
 * @classname WebSecurityConf
 * @descriptionclass 1.配置用户名和密码
 * 2.其他说明
 * @createdate 2019/10/15 16:57
 * @since 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConf extends WebSecurityConfigurerAdapter {
    /**
     * 最新版本的
     * Spring Security中密码的存储格式是“{id}…………”。
     * 前面的id是加密方式，id可以是bcrypt、sha256等，后面跟着的是加密后的密码。
     * 也就是说，程序拿到传过来的密码的时候，会首先查找被“{”和“}”包括起来的id，来确定后面的密码是被怎么样加密的，如果找不到就认为id是null
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                //错误的密码
                .withUser("thomas")
                .password("password")
                .roles("USER")
                .and()
                .withUser("joe")
                //正确的构建密码的方式 需指定编码格式
                .password(new BCryptPasswordEncoder().encode("password"))
                .roles("USER");
    }
}
