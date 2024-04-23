package com.redfish.common.query.engine.mysql.parse;

import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * SQL构建结果
 */
public class ParseResult {

    /**
     * 条件SQL构建结果
     */
    private final StringBuilder conditionSqlTemplate = new StringBuilder();

    private final List<Object> params = new LinkedList<>();




    public ParseResult addParam(Object param) {
        if (param == null){
            return this;
        }


        if (param instanceof Iterable){
            Iterator iterator = ((Iterable)param).iterator();
            while (iterator.hasNext()){
                params.add(iterator.next());
            }
        }else{
            params.add(param);
        }
        return this;
    }


    public StringBuilder getConditionSqlTemplate() {
        return conditionSqlTemplate;
    }

    public String buildWhereInfo(){
        if (StringUtils.hasText(conditionSqlTemplate)){
            conditionSqlTemplate.insert(0," where ");
        }

        return conditionSqlTemplate.toString();
    }

    public List<Object> getParams() {
        return params;
    }

    public String getSql(){
        String sqlTemplate = conditionSqlTemplate.toString().replace("?","%s");
        String sql = String.format(sqlTemplate,this.params);
        return sql;
    }

}
