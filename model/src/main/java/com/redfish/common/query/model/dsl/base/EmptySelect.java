package com.redfish.common.query.model.dsl.base;

public class EmptySelect implements Select{

    private static final EmptySelect instance = new EmptySelect();

    public static EmptySelect getInstance() {
        return instance;
    }

    private EmptySelect() {
    }

}
