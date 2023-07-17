package com.anki.files.config;

import com.anki.files.common.LoginAuthentication;
import com.anki.files.interceptor.LoginInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	LoginInterceptor login;
	
	@Override
	 public void addInterceptors(InterceptorRegistry registry) {
        registry
        .addInterceptor(login)
        .addPathPatterns("/anki/**", "/ankiAdmin/**");
	 }
}
