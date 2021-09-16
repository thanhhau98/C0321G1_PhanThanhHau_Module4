package com.codegym.blog_manager.config;

import com.codegym.blog_manager.model.service.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encoder...*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    /*Cấu hình security bằng HTTP basic*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                    .loginPage("/login")
                    /*Login thanh cong se chuyen huong ve URL man hinh hien tai,
                    neu truy cap truc tiep /login thi login thanh cong se chuyen huong ve /student */
                    .defaultSuccessUrl("/home").permitAll()
                .and()

                    .authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/create").hasRole("ADMIN")
                /* Tất cả request gởi lên server đều phải thực hiện xác thực*/
                .anyRequest().authenticated();
                    /* Tất cả request gởi lên server không cần thực hiện xác thực*/
//                    .authorizeRequests().anyRequest().permitAll();

//        /*Cau hinh remember me*/

        http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        /* dang cau hinh luu tru tai memory cua server*/
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }

}
