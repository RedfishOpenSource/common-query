package com.redfish.rule.exp.infrastructure.util.io;

import java.io.InputStream;

/**
 * 测试通过ClassLoader进行IO操作
 */
public class ClassLoaderIOTest {

    public void ioTest(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif");
    }

}
