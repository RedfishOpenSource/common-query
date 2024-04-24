package com.redfish.common.query.engine.mysql.consts;

import com.redfish.common.query.model.constans.ConditionTypeEnum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public enum MysqlConditionSymbolEnum {


    EQUAL(ConditionTypeEnum.EQUAL,"="),

    NOT_EQUAL(ConditionTypeEnum.NOT_EQUAL,"!="),

    LESS_THAN(ConditionTypeEnum.LESS_THAN,"<"),

    LESS_THAN_OR_EQUAL(ConditionTypeEnum.LESS_THAN_OR_EQUAL, "<="),

    GREATER_THAN(ConditionTypeEnum.GREATER_THAN, ">"),

    GREATER_THAN_OR_EQUAL(ConditionTypeEnum.GREATER_THAN_OR_EQUAL, ">="),


    LIKE(ConditionTypeEnum.LIKE,"like"){
        public Object valueConvert(Object value){
            return "%"+value+"%";
        }
    },

    NOT_LIKE(ConditionTypeEnum.NOT_LIKE, "not like"){
        public Object valueConvert(Object value){
            return "%"+value+"%";
        }
    },

    LEFT_LIKE(ConditionTypeEnum.LEFT_LIKE, "like"){
        public Object valueConvert(Object value){
            return value+"%";
        }
    },

    RIGHT_LIKE(ConditionTypeEnum.RIGHT_LIKE, "like"){
        public Object valueConvert(Object value){
            return "%"+value;
        }
    },

    IN(ConditionTypeEnum.IN, "in"){
        @Override
        public String buildSql(String columnName, Object value) {
            StringBuilder sql = new StringBuilder();
            sql.append(columnName);
            sql.append(" ");
            sql.append(this.getDbSymbol());
            sql.append(" ( ");

            List<String> inItems = new ArrayList<>();
            Iterator iterator =  ((Iterable)value).iterator();
            while (iterator.hasNext()){
                iterator.next();
                inItems.add("?");
            }

            sql.append(String.join(",",inItems));
            sql.append(" ( ");
            return sql.toString();
        }
    },

    NOT_IN(ConditionTypeEnum.NOT_IN, "not in"){
        @Override
        public String buildSql(String columnName, Object value) {
            StringBuilder sql = new StringBuilder();
            sql.append(columnName);
            sql.append(" ");
            sql.append(this.getDbSymbol());
            sql.append(" ( ");

            List<String> inItems = new ArrayList<>();
            Iterator iterator =  ((Iterable)value).iterator();
            while (iterator.hasNext()){
                iterator.next();
                inItems.add("?");
            }

            sql.append(String.join(",",inItems));
            sql.append(" ( ");
            return sql.toString();
        }
    },

    IS_NULL(ConditionTypeEnum.IS_NULL, "is null"){

        public String buildSql(String columnName, Object value) {
            StringBuilder sql = new StringBuilder();
            sql.append(columnName);
            sql.append(" ");
            sql.append(this.getDbSymbol());
            return sql.toString();
        }

        public Object valueConvert(Object value){
            return null;
        }
    },

    IS_NOT_NULL(ConditionTypeEnum.IS_NOT_NULL, "is not null"){
        public Object valueConvert(Object value){
            return null;
        }

        public String buildSql(String columnName, Object value) {
            StringBuilder sql = new StringBuilder();
            sql.append(columnName);
            sql.append(" ");
            sql.append(this.getDbSymbol());
            return sql.toString();
        }
    },

    ;


    private final ConditionTypeEnum conditionTypeEnum;

    private final String dbSymbol;



    public String buildSql(String columnName, Object value) {
        StringBuilder sql = new StringBuilder();
        sql.append(columnName);
        sql.append(" ");
        sql.append(this.getDbSymbol());
        sql.append(" ? ");
        return sql.toString();
    }

    public Object valueConvert(Object value){
        return value;
    }


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
