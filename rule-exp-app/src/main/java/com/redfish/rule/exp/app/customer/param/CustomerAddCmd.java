package com.redfish.rule.exp.app.customer.param;


import com.redfish.rule.exp.common.command.Command;
import lombok.Data;

@Data
public class CustomerAddCmd extends Command {

    /**
     * 电话号码
     */
    private String phoneNum;

}
