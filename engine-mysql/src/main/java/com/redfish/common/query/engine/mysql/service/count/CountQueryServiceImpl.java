package com.redfish.common.query.engine.mysql.service.count;

import com.redfish.common.query.engine.mysql.ResultMapper;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.engine.mysql.parse.SqlQueryParse;
import com.redfish.common.query.engine.mysql.service.pagequery.PageQueryServiceImpl;
import com.redfish.common.query.model.model.param.CountQueryParam;
import com.redfish.common.query.model.model.param.SelectField;
import com.redfish.common.query.model.model.result.QueryResultListData;
import com.redfish.common.query.model.service.CountQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Component
public class CountQueryServiceImpl implements CountQueryService {


    public final static Logger LOGGER = LoggerFactory.getLogger(CountQueryServiceImpl.class);


    @Resource
    private SqlQueryParse sqlQueryParse;

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Value("${common.query.logsql.enable:false}")
    private Boolean logSqlEnable;

    @Override
    public Integer count(CountQueryParam countQueryParam) {

        // 1,构建SQL模板
        ParseResult parseResult = sqlQueryParse.parse(countQueryParam);

        StringBuilder sqlStringBuilder = parseResult.getConditionSqlTemplate();
        List<Object> params = parseResult.getParams();

        if (null != logSqlEnable && logSqlEnable){
            parseResult.log(LOGGER);
        }

        // 2,执行查询
        Integer count = jdbcTemplate.queryForObject(sqlStringBuilder.toString(),Integer.class,params.toArray());

        return count;
    }
}
