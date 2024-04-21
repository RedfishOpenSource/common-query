package com.redfish.common.query.engine.mysql.consts;

import com.redfish.common.query.model.constans.ConditionTypeEnum;

import java.util.Optional;

public enum MysqlConditionSymbolEnum {

    /**
     * 等于
     */
    EQUAL(ConditionTypeEnum.EQUAL,"="){

        @Override
        public String buildSql(String columnName, Object value) {
            StringBuilder sql = new StringBuilder();
            sql.append(columnName);
            sql.append(" ");
            sql.append(this.getDbSymbol());
            sql.append(" ? ");
            return sql.toString();
        }
    },

    ;


    private final ConditionTypeEnum conditionTypeEnum;

    private final String dbSymbol;

    public abstract String buildSql(String columnName, Object value);


    MysqlConditionSymbolEnum(ConditionTypeEnum conditionTypeEnum, String dbSymbol)
    {
        this.conditionTypeEnum = conditionTypeEnum;
        this.dbSymbol = dbSymbol;
    }


    public ConditionTypeEnum getConditionTypeEnum() {
        return conditionTypeEnum;
    }

    public String getDbSymbol() {
        return dbSymbol;
    }

    public static MysqlConditionSymbolEnum valueOf(ConditionTypeEnum conditionTypeEnum) {
        for (MysqlConditionSymbolEnum mysqlConditionSymbolEnum : MysqlConditionSymbolEnum.values()) {
            if (mysqlConditionSymbolEnum.getConditionTypeEnum().getCode().equals(conditionTypeEnum.getCode())) {
                return mysqlConditionSymbolEnum;
            }
        }
        throw new RuntimeException("当前条件类型不支持："+ Optional.ofNullable(conditionTypeEnum).map(ConditionTypeEnum::getCode).orElse(""));
    }




}
