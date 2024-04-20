
package com.redfish.rule.exp.app.customer.executor;


import com.redfish.rule.exp.app.customer.param.CustomerAddCmd;
import com.redfish.rule.exp.common.dto.Response;
import org.springframework.stereotype.Component;


@Component
public class CustomerAddCmdExe{

    public Response execute(CustomerAddCmd cmd) {
//        if(cmd.getPhoneNum().equals("13387645364")){
//            throw new BizException(ErrorCodeEnum.DATA_EXISTS.getCode(), "电话号码冲突");
//        }
        return Response.buildSuccess();
    }

}
