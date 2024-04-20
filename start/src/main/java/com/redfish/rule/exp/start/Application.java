package com.redfish.rule.exp.start;

import com.redfish.rule.exp.adapter.web.rest.CustomerController;
import com.redfish.rule.exp.starter.EnableDemoAutoConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@EnableDemoAutoConfiguration
@SpringBootApplication
public class Application  {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
