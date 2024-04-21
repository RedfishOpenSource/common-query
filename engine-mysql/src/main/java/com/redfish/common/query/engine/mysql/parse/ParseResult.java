package com.redfish.common.query.engine.mysql.parse;

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

        if (param instanceof Iterator){
            while (((Iterator) param).hasNext()){
                params.add(((Iterator) param).next());
            }
        }else{
            params.add(param);
        }
        params.add(param);
        return this;
    }


    public StringBuilder getConditionSqlTemplate() {
        return conditionSqlTemplate;
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
