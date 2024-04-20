package com.redfish.common.query.model.model.result;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class QueryResultListData implements Serializable {

    private final List<QueryResultRowData> dataRows = new LinkedList<>();

    public QueryResultListData addRow(QueryResultRowData row) {
        this.dataRows.add(row);
        return this;
    }

}
