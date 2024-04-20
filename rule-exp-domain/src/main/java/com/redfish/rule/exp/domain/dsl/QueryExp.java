package com.redfish.rule.exp.domain.dsl;

import com.redfish.rule.exp.domain.dsl.base.*;
import com.redfish.rule.exp.domain.model.exp.PageRuleExp;
import com.redfish.rule.exp.domain.model.exp.ResourceRuleExp;
import com.redfish.rule.exp.domain.model.exp.SortRuleExp;
import com.redfish.rule.exp.domain.model.exp.TargetAttributesRuleExp;
import com.redfish.rule.exp.domain.model.exp.condition.ConditionRuleExp;

import java.util.List;

public class QueryExp implements Init, From ,Where,Select,OrderBy,Limit{

    private QueryExp(){}

    public static Init build(){
        return new QueryExp();
    }


    private ResourceRuleExp resourceRuleExp;

    private ConditionRuleExp conditionRuleExp;


    private List<SortRuleExp> sortRuleExps;

    private PageRuleExp pageRuleExp;

    private TargetAttributesRuleExp targetAttributesRuleExp;

    @Override
    public From from(ResourceRuleExp resourceRuleExp) {
        this.resourceRuleExp = resourceRuleExp;
        return this;
    }

    @Override
    public Where where(ConditionRuleExp conditionRuleExp) {
        this.conditionRuleExp = conditionRuleExp;
        return this;
    }

    @Override
    public OrderBy orderBy(List<SortRuleExp> sortRuleExps) {
        this.sortRuleExps = sortRuleExps;
        return this;
    }

    @Override
    public Limit limit(PageRuleExp pageRuleExp) {
        this.pageRuleExp = pageRuleExp;
        return this;
    }

    @Override
    public Select select(TargetAttributesRuleExp targetAttributesRuleExp) {
        this.targetAttributesRuleExp = targetAttributesRuleExp;
        return this;
    }


    public ResourceRuleExp getResourceRuleExp() {
        return resourceRuleExp;
    }

    public ConditionRuleExp getConditionRuleExp() {
        return conditionRuleExp;
    }

    public List<SortRuleExp> getSortRuleExps() {
        return sortRuleExps;
    }

    public PageRuleExp getPageRuleExp() {
        return pageRuleExp;
    }

    public TargetAttributesRuleExp getTargetAttributesRuleExp() {
        return targetAttributesRuleExp;
    }
}
