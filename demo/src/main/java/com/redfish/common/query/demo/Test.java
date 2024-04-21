package com.redfish.common.query.demo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

public class Test {

    @Resource
    private JdbcTemplate jdbcTemplate;



    public void Demo(){
//        jdbcTemplate.queryForList();
    }


}
