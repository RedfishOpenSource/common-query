package com.redfish.common.query.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfish.common.query.model.model.param.EntityInfo;
import com.redfish.common.query.model.model.param.PageQueryParam;
import com.redfish.common.query.model.model.result.QueryResultListData;
import com.redfish.common.query.model.service.PageQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class Application {

    Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static ApplicationContext applicationContext = null;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class,args);
        applicationContext.getBean(Application.class).testLogic();
    }

    @Resource
    private PageQueryService pageQueryService;

    @Resource
    private ObjectMapper objectMapper;

    private void testLogic() {
        PageQueryParam pageQueryParam = PageQueryParam.of()
                .setEntityInfo("your_table")
                .selectFields(
                        "code","name"
                );

        QueryResultListData queryResultListData = pageQueryService.page(pageQueryParam);

        try {
            LOGGER.info("common.query.result:{}",objectMapper.writeValueAsString(queryResultListData));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }



}
