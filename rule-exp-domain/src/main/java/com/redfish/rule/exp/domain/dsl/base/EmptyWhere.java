package com.redfish.rule.exp.domain.dsl.base;

import com.redfish.rule.exp.domain.model.exp.PageRuleExp;
import com.redfish.rule.exp.domain.model.exp.SortRuleExp;
import com.redfish.rule.exp.domain.model.exp.TargetAttributesRuleExp;

import java.util.List;

public class EmptyWhere implements Where{

    private static final EmptyWhere instance = new EmptyWhere();

    public static EmptyWhere getInstance() {
        return instance;
    }

    private EmptyWhere() {
    }

    @Override
    public Select select(TargetAttributesRuleExp targetAttributesRuleExp) {
        throw new RuntimeException("cur DSL do not support execute");
    }

    @Override
    public OrderBy orderBy(List<SortRuleExp> sortRuleExps) {
        throw new RuntimeException("cur DSL do not support execute");
    }

    @Override
    public Limit limit(PageRuleExp pageRuleExp) {
        throw new RuntimeException("cur DSL do not support execute");
    }
}
