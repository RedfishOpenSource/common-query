package com.redfish.common.query.model.service;

import com.redfish.common.query.model.model.delete.DataDeleteParam;

public interface DeleteService {

    Boolean batchDelete(DataDeleteParam dataDeleteParam);

}
