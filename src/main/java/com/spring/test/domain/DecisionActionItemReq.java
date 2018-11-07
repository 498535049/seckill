package com.spring.test.domain;

import java.io.Serializable;

public class DecisionActionItemReq implements Serializable {
    private static final long serialVersionUID = -6367449186397058254L;

    private String id;
    /**决策动作项编码*/
    private String decisionActionItemCode;
    /**决策项名字*/
    private String decisionActionItemName;
    /**决策项key*/
    private String decisionActionItemkey;
    /**决策项输出值类型*/
    private String decisionActionItemType;
    /**决策项是否是枚举值*/
    private String decisionActionItemEnum;
    /**决策项输出值*/
    private String decisionActionItemOutput;
    /**决策项枚举值id*/
    private String decisionActionItemEnumId;
    /**决策项枚举值key*/
    private String decisionActionItemEnumKey;
    /**决策项枚举值value*/
    private String decisionActionItemEnumValue;
    /**决策项输出值*/
    private String decisionActionItemOutputCode;
    /**决策项输出值*/
    private String decisionActionItemOutputName;

    public String getDecisionActionItemCode() {
        return decisionActionItemCode;
    }
    public void setDecisionActionItemCode(String decisionActionItemCode) {
        this.decisionActionItemCode = decisionActionItemCode;
    }
    public String getDecisionActionItemName() {
        return decisionActionItemName;
    }
    public void setDecisionActionItemName(String decisionActionItemName) {
        this.decisionActionItemName = decisionActionItemName;
    }
    public String getDecisionActionItemkey() {
        return decisionActionItemkey;
    }
    public void setDecisionActionItemkey(String decisionActionItemkey) {
        this.decisionActionItemkey = decisionActionItemkey;
    }
    public String getDecisionActionItemType() {
        return decisionActionItemType;
    }
    public void setDecisionActionItemType(String decisionActionItemType) {
        this.decisionActionItemType = decisionActionItemType;
    }
    public String getDecisionActionItemEnum() {
        return decisionActionItemEnum;
    }
    public void setDecisionActionItemEnum(String decisionActionItemEnum) {
        this.decisionActionItemEnum = decisionActionItemEnum;
    }
    public String getDecisionActionItemOutput() {
        return decisionActionItemOutput;
    }
    public void setDecisionActionItemOutput(String decisionActionItemOutput) {
        this.decisionActionItemOutput = decisionActionItemOutput;
    }
    public String getDecisionActionItemEnumId() {
        return decisionActionItemEnumId;
    }
    public void setDecisionActionItemEnumId(String decisionActionItemEnumId) {
        this.decisionActionItemEnumId = decisionActionItemEnumId;
    }
    public String getDecisionActionItemEnumKey() {
        return decisionActionItemEnumKey;
    }
    public void setDecisionActionItemEnumKey(String decisionActionItemEnumKey) {
        this.decisionActionItemEnumKey = decisionActionItemEnumKey;
    }
    public String getDecisionActionItemEnumValue() {
        return decisionActionItemEnumValue;
    }
    public void setDecisionActionItemEnumValue(String decisionActionItemEnumValue) {
        this.decisionActionItemEnumValue = decisionActionItemEnumValue;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDecisionActionItemOutputCode() {
        return decisionActionItemOutputCode;
    }
    public void setDecisionActionItemOutputCode(String decisionActionItemOutputCode) {
        this.decisionActionItemOutputCode = decisionActionItemOutputCode;
    }
    public String getDecisionActionItemOutputName() {
        return decisionActionItemOutputName;
    }
    public void setDecisionActionItemOutputName(String decisionActionItemOutputName) {
        this.decisionActionItemOutputName = decisionActionItemOutputName;
    }
    @Override
    public String toString() {
        return "DecisionActionItemReq [id=" + id + ", decisionActionItemCode=" + decisionActionItemCode
                + ", decisionActionItemName=" + decisionActionItemName + ", decisionActionItemkey="
                + decisionActionItemkey + ", decisionActionItemType=" + decisionActionItemType
                + ", decisionActionItemEnum=" + decisionActionItemEnum + ", decisionActionItemOutput="
                + decisionActionItemOutput + ", decisionActionItemEnumId=" + decisionActionItemEnumId
                + ", decisionActionItemEnumKey=" + decisionActionItemEnumKey + ", decisionActionItemEnumValue="
                + decisionActionItemEnumValue + ", decisionActionItemOutputCode=" + decisionActionItemOutputCode
                + ", decisionActionItemOutputName=" + decisionActionItemOutputName + "]";
    }


}
