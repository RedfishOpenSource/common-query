package com.redfish.rule.exp.domain.dsl.base;

import com.redfish.rule.exp.domain.model.exp.PageRuleExp;
import com.redfish.rule.exp.domain.model.exp.TargetAttributesRuleExp;

public interface OrderBy {

    Select select(TargetAttributesRuleExp targetAttributesRuleExp);

    Limit limit(PageRuleExp pageRuleExp);

}
