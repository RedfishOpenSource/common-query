package com.redfish.common.query.engine.mysql.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfish.common.query.engine.mysql.config.EngineMysqlAutoConfiguration;
import com.redfish.common.query.model.constans.ConditionTypeEnum;
import com.redfish.common.query.model.constans.SortConditionEnum;
import com.redfish.common.query.model.model.condition.And;
import com.redfish.common.query.model.model.condition.Not;
import com.redfish.common.query.model.model.condition.Or;
import com.redfish.common.query.model.model.condition.SingleQueryCondition;
import com.redfish.common.query.model.model.param.CountQueryParam;
import com.redfish.common.query.model.model.param.PageQueryParam;
import com.redfish.common.query.model.model.param.SortInfo;
import com.redfish.common.query.model.model.result.QueryResultListData;
import com.redfish.common.query.model.service.CountQueryService;
import com.redfish.common.query.model.service.PageQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,classes = EngineMysqlAutoConfiguration.class)
@RunWith(SpringRunner.class)
public class CountQueryServiceTest {


    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PageQueryServiceTest.class);

    @Resource
    private CountQueryService countQueryService;

    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void testLogic() {
        CountQueryParam countQueryParam = CountQueryParam.of()
                .setEntityInfo("your_table")
                .setQueryCondition( SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.EQUAL).setValue("redfish"));

        Integer count = countQueryService.count(countQueryParam);

        LOGGER.info("common.query.result:{}",count);

    }

}
