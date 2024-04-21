package com.redfish.common.query.model.config;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfish.common.query.model.model.condition.QueryCondition;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = {"com.redfish.common.query.model.model"})
public class ModelConfiguration {



}
