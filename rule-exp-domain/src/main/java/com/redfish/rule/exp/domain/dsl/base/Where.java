package com.redfish.rule.exp.domain.dsl.base;

import com.redfish.rule.exp.domain.model.exp.PageRuleExp;
import com.redfish.rule.exp.domain.model.exp.SortRuleExp;
import com.redfish.rule.exp.domain.model.exp.TargetAttributesRuleExp;

import java.util.List;

public interface Where {

    Select select(TargetAttributesRuleExp targetAttributesRuleExp);

    OrderBy orderBy(List<SortRuleExp> sortRuleExps);

    Limit limit(PageRuleExp pageRuleExp);

}
