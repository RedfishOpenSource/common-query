package com.redfish.rule.exp.app.customer;


import com.redfish.rule.exp.app.customer.param.CustomerAddCmd;
import com.redfish.rule.exp.common.dto.Response;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

}
