package com.example.mikaelo;

import java.awt.image.BufferedImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import com.example.mikaelo.security.SimpleCORSFilter;

@SpringBootApplication
public class ExmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExmApplication.class, args);
	}
	
	
	@Bean
	public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
	    return new BufferedImageHttpMessageConverter();
	}
	
	@Bean
	public FilterRegistrationBean<SimpleCORSFilter> loggingFilter(){
	    FilterRegistrationBean<SimpleCORSFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new SimpleCORSFilter());
	    registrationBean.addUrlPatterns("/invitados/*");
	    return registrationBean;    
	}

}
