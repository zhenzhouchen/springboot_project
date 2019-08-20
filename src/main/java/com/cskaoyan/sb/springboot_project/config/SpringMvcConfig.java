//package com.cskaoyan.sb.springboot_project.config;
//
//import com.cskaoyan.sb.springboot_project.interceptor.LogInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class SpringMvcConfig implements WebMvcConfigurer {
//    //解决interceptor中autowired为null的问题，需要将interceptor注册为bean
//    //因为interceptor会在context之前加载
//    @Bean
//    public LogInterceptor logInterceptor() {
//        return new LogInterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册拦截器，注册为bean后addInterceptor中无需new LogInterceptor()
//        registry.addInterceptor(logInterceptor()).addPathPatterns("/admin/**");
//    }
//}
