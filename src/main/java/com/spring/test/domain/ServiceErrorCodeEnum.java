package com.spring.test.domain;

public enum ServiceErrorCodeEnum {
    Success("0000","处理成功"),
    MANUAL("8888","需要人审"),
    System_Error("9999","系统异常"),
    Packets_illegal("1001","请求参数非法"),
    Missing_param("1002","请求参数缺失"),
    Fruad_Fail("1003","反欺诈处理失败"),
    Credit_Fail("1004","授信处理失败"),
    Query_Black_Fail("1005","黑名单查询失败"),
    DECISION_FAIL("1006","决策处理失败"),
    Data_Query_Fail("1007","数据查询失败"),
    Data_Collect_Fail("1008","数据存储失败"),
    SYS_DBERR("1009","数据库操作错误:"),
    TIO_ELEM_MISS("1010","接口要素缺失:"),
    TIO_ELEM_ERROR("1011","接口要素错误:"),
    USER_ADDINFO_ERR("1019","记录插入失败:"),
    USER_DELINFO_ERR("1021","记录删除失败:"),
    USER_CODEOPER_ERR("1022","用户信用额度规则信息操作异常"),
    USER_CODEOPER_SUC("1023","用户信用额度规则信息操作成功"),
    USER_MOB_FORMERR("1025","手机号段非法"),
    USER_SEX_FORMERR("1026","性别字段非法"),
    NEW_BIG_OLD("1055","新额度值不能小于之前额度值"),
    CREDIT_FAIL("1056","授信失败"),
    CREDIT_LESS_MIN("1057","授信额度小于该商户指定的最低有效额度值"),
    BIZ_CODE_EXISTS("1058","Biz_Code已经存在"),
    RULE_FILED_MAP_EXISTS("1059","该字段已经存在"),
    ILLEGAL_IDNO_FAIL("1060","身份证信息有误"),
    ILLEGAL_IP_FAIL("1061","ip地址有误"),
    ILLEGAL_MOBILE_FAIL("1062","手机号码有误"),


    BS_REQUEST_ERROR("1063", "调用邦盛系统异常"),
    BS_RESULT_ERROR("1064", "调用邦盛返回信息异常"),
    HUMAN_AUDIT_ERROR("1066", "人审异常"),
    SMART_AUDIT_ERROR("1067", "电核异常"),
    NULL_RESULT("1068", "空指针"),
    STATE_INCONFORMITY("1069", "状态有误"),
    RESULT_ERROR("1070", "查询结果有误"),
    LEAF_NODE_NO_COMPLETE("1071","叶子结点未齐全"),
    LEAF_NODE_NO_DIFFERENCE("1072","叶子节点缺少结果值"),
    PARENT_NODE_VARIABLE_DIFF("1073","同一父节点下变量不一致"),
    LEAF_NODE_HAVE_ACTION_ITEM("1074","叶子结点必须有决策动作项"),
    LEAF_NODE_ACTION_ITEM_HAVE_VALUE("1075","每个决策动作项必须要有值"),
    DECISION_ACTION_NAME_SAME("1076","决策动作包名字重复"),
    DECISION_ACTION_ITEM_NAME_SAME("1077","决策动作项名字重复"),
    DECISION_ACTION_ITEM_KEY_SAME("1078","决策动作项key重复"),
    NAME_SAME("1079","该名称在数据库已存在"),
    TENANT_INFO_MISS("1080","租户信息缺失"),
    DECISION_ACTION_PACKAGE_ERROR("1081","决策动作包有变动，请重新编辑决策动作项");
    private String code;
    private String errorMes;

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param code
     * @param errorMes
     */
    private ServiceErrorCodeEnum(String code, String errorMes) {
        this.code = code;
        this.errorMes = errorMes;
    }
    public String getCode() {
        return code;
    }
    public String getErrorMes() {
        return errorMes;
    }

    public void setErrorMes(String errorMes) {
        this.errorMes = errorMes;
    }
    @Override
    public String toString(){
        return this.code;
    }
}
