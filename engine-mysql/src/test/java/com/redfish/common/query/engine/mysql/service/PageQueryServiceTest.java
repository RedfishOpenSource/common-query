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
import com.redfish.common.query.model.model.param.PageQueryParam;
import com.redfish.common.query.model.model.param.SortInfo;
import com.redfish.common.query.model.model.result.QueryResultListData;
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
public class PageQueryServiceTest {


    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PageQueryServiceTest.class);

    @Resource
    private PageQueryService pageQueryService;

    @Resource
    private ObjectMapper objectMapper;

    @Test
    public void testLogic() {
        PageQueryParam pageQueryParam = PageQueryParam.of()
                .setEntityInfo("your_table")
                .setSelectFields(
                        "code","name"
                ).setQueryCondition(
                        And.of(
                                SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.EQUAL).setValue("redfish"),
                                SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.NOT_EQUAL).setValue("2"),
                                SingleQueryCondition.of("name").setConditionType(ConditionTypeEnum.IS_NULL).setValue("2"),
                                Or.of(
                                        SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.EQUAL).setValue("redfish"),
                                        SingleQueryCondition.of("name").setConditionType(ConditionTypeEnum.EQUAL).setValue("456")
                                ),
                                Not.of(
                                        SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.EQUAL).setValue("12356675")
                                ),
                                SingleQueryCondition.of("code").setConditionType(ConditionTypeEnum.LIKE).setValue("fis")
                        )
                )
                .setSortInfos(
                        SortInfo.of("code",SortConditionEnum.ASC),
                        SortInfo.of("name", SortConditionEnum.DESC)
                )
                .setPageInfo(1,3);

        QueryResultListData queryResultListData = pageQueryService.page(pageQueryParam);

        try {
            LOGGER.info("common.query.result:{}",objectMapper.writeValueAsString(queryResultListData));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}
