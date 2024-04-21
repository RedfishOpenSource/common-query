package com.redfish.common.query.model.config;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfish.common.query.model.model.condition.QueryCondition;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;

@Component
public class ConditionSubTypeInitRunner implements ApplicationRunner {

    @Resource
    private ObjectMapper objectMapper;


    @Value("common.query.condition.custom.path:")
    private String customSubConditionTypePath;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        initConditionTypes();
    }



    public void initConditionTypes(){
        initConditionTypes("com.redfish.common.query.model.model.condition");
        initConditionTypes(customSubConditionTypePath);
    }


    private void initConditionTypes(String packagetPath){
        if (!StringUtils.hasText(packagetPath)){
            return;
        }

        // 获取该路径下所有类
        Reflections reflections = new Reflections(packagetPath);
        // 获取对应类的所有子类
        Set<Class<? extends QueryCondition>> classSet = reflections.getSubTypesOf(QueryCondition.class);
        for (Class<? extends QueryCondition> clazz : classSet) {
            // 将带有@JsonTypeName注解的类进行注册
            if (clazz.isAnnotationPresent(JsonTypeName.class)) {
                objectMapper.registerSubtypes(clazz);
            }
        }
    }
}
