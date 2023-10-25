package com.demo.spring_aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.demo.spring_aop")
@EnableAspectJAutoProxy
public class Beans {
    @Bean
    public Student student() {
        Student student = new Student();
        student.setAge(24);
        student.setName("Andy");
        return student;
    }
    
//    @Bean
//    public Logging logging() {
//    	return new Logging();
//    }
}
