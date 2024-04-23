package com.redfish.common.query.model.model.result;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class QueryResultRowData implements Serializable {

    private final List<QueryResultFieldData> queryResultFieldData = new LinkedList<>();


    public QueryResultRowData addQueryResultFieldData(QueryResultFieldData queryResultFieldData) {
        this.queryResultFieldData.add(queryResultFieldData);
        return this;
    }

    public QueryResultFieldData getField(String fieldCode){
        return queryResultFieldData.stream().filter(filedDataInner -> fieldCode.equals(filedDataInner.getFieldCode()))
                .findFirst().orElse(null);
    }

    public List<QueryResultFieldData> getQueryResultFieldData() {
        return queryResultFieldData;
    }

}
