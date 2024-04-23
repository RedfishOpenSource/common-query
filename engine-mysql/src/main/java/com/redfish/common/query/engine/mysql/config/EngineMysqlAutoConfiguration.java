package com.redfish.common.query.engine.mysql.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@ComponentScan(basePackages = "com.redfish.common.query.engine.mysql")
@Configuration
public class EngineMysqlAutoConfiguration implements Serializable {
}
