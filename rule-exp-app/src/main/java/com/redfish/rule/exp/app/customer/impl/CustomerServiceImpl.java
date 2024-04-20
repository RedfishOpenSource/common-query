package com.redfish.rule.exp.app.customer.impl;

import com.redfish.rule.exp.app.customer.CustomerServiceI;
import com.redfish.rule.exp.app.customer.executor.CustomerAddCmdExe;
import com.redfish.rule.exp.app.customer.param.CustomerAddCmd;
import com.redfish.rule.exp.common.dto.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;


    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }



}