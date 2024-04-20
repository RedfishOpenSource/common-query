package com.redfish.rule.exp.domain.model.exp;

/**
 * 资源规则表达式
 */
public class ResourceRuleExp extends RuleExp {

    // 资源描述
    private String resource;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}