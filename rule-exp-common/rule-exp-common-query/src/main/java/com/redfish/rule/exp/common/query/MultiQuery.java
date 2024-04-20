package com.redfish.rule.exp.common.query;

/**
 * 列表查询
 *
 * @param <S>
 * @param <C>
 */
public class MultiQuery<S extends SortInfo,C extends ConditionInfo> extends Query{

    /**
     * 排序信息
     */
    private S sortInfo;


    /**
     * 条件
     */
    private C conditionInfo;

    public S getSortInfo() {
        return sortInfo;
    }

    public MultiQuery setSortInfo(S sortInfo) {
        this.sortInfo = sortInfo;
        return this;
    }

    public C getConditionInfo() {
        return conditionInfo;
    }

    public MultiQuery setConditionInfo(C conditionInfo) {
        this.conditionInfo = conditionInfo;
        return this;
    }

}
