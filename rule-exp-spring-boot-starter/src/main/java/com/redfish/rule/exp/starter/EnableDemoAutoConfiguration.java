package com.redfish.rule.exp.starter;



import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DemoConfiguration.class)
public @interface EnableDemoAutoConfiguration {
}
