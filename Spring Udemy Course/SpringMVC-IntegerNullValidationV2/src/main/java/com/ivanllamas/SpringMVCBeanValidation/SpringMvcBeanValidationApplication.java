package com.ivanllamas.SpringMVCBeanValidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
public class SpringMvcBeanValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcBeanValidationApplication.class, args);
	}

        /*SINCE WE DO NOT HAVE A WEB-INF XML FILE, WE MUST USE THIS TO ACCESS 
        RESOURCE BUNDLE AND PROPERTY
        */
           @Bean
public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource
      = new ReloadableResourceBundleMessageSource();
     
    messageSource.setBasename("classpath:messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
}

@Bean
public LocalValidatorFactoryBean getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(messageSource());
    return bean;
    }
        
}

