package com.redfish.common.query.engine.mysql.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfish.common.query.engine.mysql.config.EngineMysqlAutoConfiguration;
import com.redfish.common.query.model.constans.ConditionTypeEnum;
import com.redfish.common.query.model.model.condition.And;
import com.redfish.common.query.model.model.condition.SingleQueryCondition;
import com.redfish.common.query.model.model.param.QueryOneParam;
import com.redfish.common.query.model.model.result.QueryResultRowData;
import com.redfish.common.query.model.service.QueryOneService;
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
public class QueryOneServiceTest {

    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(QueryOneServiceTest.class);

    @Resource
    private QueryOneService queryOneService;

    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void testLogic() {
        QueryOneParam queryOneParam = QueryOneParam.of()
                .setEntityInfo("your_table")
                .setSelectFields(
                        "code","name"
                ).setQueryCondition(
                        And.of(
                                SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.EQUAL).setValue("2")
                        )
                );

        QueryResultRowData queryResultListData = queryOneService.getOne(queryOneParam);

        try {
            LOGGER.info("common.query.result:{}",objectMapper.writeValueAsString(queryResultListData));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
