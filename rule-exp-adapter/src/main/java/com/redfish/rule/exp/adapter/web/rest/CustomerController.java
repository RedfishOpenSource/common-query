package com.redfish.rule.exp.adapter.web.rest;



import com.redfish.rule.exp.app.customer.CustomerServiceI;
import com.redfish.rule.exp.app.customer.param.CustomerAddCmd;
import com.redfish.rule.exp.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to redfish!";
    }


    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return Response.buildSuccess();
    }
}
