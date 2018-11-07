package com.spring.test.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoJian
 * @since 2018-03-20
 */
@TableName("dc_risk_decision_action_item_relation_snapshot")
public class RiskDecisionActionItemRelationSnapshot extends Model<RiskDecisionActionItemRelationSnapshot> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 决策项id
     */
	@TableField("decision_action_item_id")
	private Long decisionActionItemId;
    /**
     * 输出值
     */
	private String output;
	@TableField("decision_action_item_enum_id")
	private Long decisionActionItemEnumId;
    /**
     * 风控决策节点快照id
     */
	@TableField("risk_decision_nodes_id")
	private Long riskDecisionNodesId;
    /**
     * 0：失效 1：生效
     */
	private String state;
    /**
     * 提交时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 修改时间
     */
	@TableField("modify_time")
	private Date modifyTime;
    /**
     * 提交人
     */
	private String creater;
    /**
     * 修改人
     */
	private String modify;
    /**
     * 操作标记A-添加E-修改D-删除P-原始
     */
	@TableField("oper_type")
	private String operType;
    /**
     * 规则包ID
     */
	@TableField("rule_package_id")
	private Long rulePackageId;
    /**
     * 输出值code
     */
	@TableField("output_code")
	private String outputCode;
    /**
     * 输出值名字
     */
	@TableField("output_name")
	private String outputName;
    /**
     * 1：文本 2：数值 3：变量 4：规则包分值 5：简单表达式
     */
	@TableField("output_type")
	private String outputType;

	/**租户id*/
	@TableField("tenancy_id")
	private Long tenancyId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDecisionActionItemId() {
		return decisionActionItemId;
	}

	public void setDecisionActionItemId(Long decisionActionItemId) {
		this.decisionActionItemId = decisionActionItemId;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public Long getDecisionActionItemEnumId() {
		return decisionActionItemEnumId;
	}

	public void setDecisionActionItemEnumId(Long decisionActionItemEnumId) {
		this.decisionActionItemEnumId = decisionActionItemEnumId;
	}

	public Long getRiskDecisionNodesId() {
		return riskDecisionNodesId;
	}

	public void setRiskDecisionNodesId(Long riskDecisionNodesId) {
		this.riskDecisionNodesId = riskDecisionNodesId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public Long getRulePackageId() {
		return rulePackageId;
	}

	public void setRulePackageId(Long rulePackageId) {
		this.rulePackageId = rulePackageId;
	}

	public String getOutputCode() {
		return outputCode;
	}

	public void setOutputCode(String outputCode) {
		this.outputCode = outputCode;
	}

	public String getOutputName() {
		return outputName;
	}

	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public Long getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(Long tenancyId) {
		this.tenancyId = tenancyId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RiskDecisionActionItemRelationSnapshot [id=" + id + ", decisionActionItemId=" + decisionActionItemId
				+ ", output=" + output + ", decisionActionItemEnumId=" + decisionActionItemEnumId
				+ ", riskDecisionNodesId=" + riskDecisionNodesId + ", state=" + state + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", creater=" + creater + ", modify=" + modify + ", operType="
				+ operType + ", rulePackageId=" + rulePackageId + ", outputCode=" + outputCode + ", outputName="
				+ outputName + ", outputType=" + outputType + ", tenancyId=" + tenancyId + "]";
	}
}
