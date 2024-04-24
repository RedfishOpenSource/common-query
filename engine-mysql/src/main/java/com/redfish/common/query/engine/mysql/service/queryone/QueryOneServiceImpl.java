package com.redfish.common.query.engine.mysql.service.queryone;

import com.redfish.common.query.engine.mysql.ResultMapper;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.engine.mysql.parse.SqlQueryParse;
import com.redfish.common.query.model.common.CommonQueryException;
import com.redfish.common.query.model.common.ErrorCodeEnum;
import com.redfish.common.query.model.model.param.PageQueryParam;
import com.redfish.common.query.model.model.param.QueryOneParam;
import com.redfish.common.query.model.model.param.SelectField;
import com.redfish.common.query.model.model.result.QueryResultListData;
import com.redfish.common.query.model.model.result.QueryResultRowData;
import com.redfish.common.query.model.service.QueryOneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class QueryOneServiceImpl implements QueryOneService {
    public final static Logger LOGGER = LoggerFactory.getLogger(QueryOneServiceImpl.class);


    @Resource
    private SqlQueryParse sqlQueryParse;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private ResultMapper resultMapper;

    @Value("${common.query.logsql.enable:false}")
    private Boolean logSqlEnable;

    @Override
    public QueryResultRowData getOne(QueryOneParam queryExp){

        // 1,构建SQL模板
        PageQueryParam pageQueryParam = PageQueryParam.of()
                .setEntityInfo(queryExp.getEntityInfo())
                .setSelectFields(queryExp.getSelectFields())
                .setQueryCondition(queryExp.getQueryCondition())
                .setPageInfo(1,2);
        ParseResult parseResult = sqlQueryParse.parse(pageQueryParam);

        StringBuilder sqlStringBuilder = parseResult.getConditionSqlTemplate();
        List<Object> params = parseResult.getParams();

        if (null != logSqlEnable && logSqlEnable){
            parseResult.log(LOGGER);
        }

        // 2,执行查询
        List<Map<String, Object>> rowsMap = jdbcTemplate.queryForList(sqlStringBuilder.toString(), params.toArray());
        if (null == rowsMap || rowsMap.size() == 0){
            return null;
        }
        if (rowsMap.size() > 1){
            throw new CommonQueryException(ErrorCodeEnum.QUERY_RESULT_ERROR,"query result size lager than one.");
        }

        // 3，查询结果convert
        List<SelectField> selectFields = pageQueryParam.getSelectFields();
        QueryResultListData queryResultListData =resultMapper.convert(rowsMap,selectFields);

        return queryResultListData.getDataRows().get(0);
    }
}
