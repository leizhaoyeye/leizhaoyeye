package com.example.zhaolei.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("检验鉴定模块请求参数模型")
public class TestAppraisalVm {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 委托人
     */
    @ApiModelProperty("委托人")
    private String clientName;
    /**
     * 职务
     */
    @ApiModelProperty("职务")
    private String job;
    /**
     * 委托人联系电话
     */
    @ApiModelProperty("委托人联系电话")
    private String clientTelephone;
    /**
     * 警号
     */
    @ApiModelProperty("警号")
    private String policeCode;
    /**
     * 委托人2
     */
    @ApiModelProperty("委托人2")
    private String clientName02;
    /**
     * 职务2
     */
    @ApiModelProperty("职务2")
    private String job02;
    /**
     * 联系电话2
     */
    @ApiModelProperty("联系电话2")
    private String clientTelephone02;
    /**
     * 委托人3
     */
    @ApiModelProperty("委托人3")
    private String clientName03;
    /**
     * 职务3
     */
    @ApiModelProperty("职务3")
    private String job03;
    /**
     * 联系电话3
     */
    @ApiModelProperty("联系电话3")
    private String clientTelephone03;
    /**
     * 委托单位
     */
    @ApiModelProperty("委托单位")
    private String clientUnit;
    /**
     * 邮编
     */
    @ApiModelProperty("邮编")
    private String postcode;
    /**
     * 委托单位联系电话
     */
    @ApiModelProperty("委托单位联系电话")
    private String clientUnitTelephone;
    /**
     * 委托时间
     */
    @ApiModelProperty("委托时间")
    private String clientTime;
    /**
     * 委托时间起
     */
    @ApiModelProperty("委托时间起")
    private String clientTimeStart;
    /**
     * 委托时间始
     */
    @ApiModelProperty("委托时间始")
    private String clientTimeEnd;
    /**
     * 案件编号
     */
    @ApiModelProperty("案件编号")
    private String caseId;
    /**
     * 案件名称
     */
    @ApiModelProperty("案件名称")
    private String caseName;
    /**
     * 简要情况
     */
    @ApiModelProperty("简要情况")
    private String briefInfomation;
    /**
     * 样本情况
     */
    @ApiModelProperty("样本情况")
    private String sampleInfomation;
    /**
     * 鉴定需求
     */
    @ApiModelProperty("鉴定需求")
    private String appraisalDemand;
    /**
     * 审批状态（1：待提交 2:待审批、3：审批通过、4：审批未通过、5：检验鉴定完成）
     */
    @ApiModelProperty("审批状态（1：待提交 2:待总队审批 3:待科技处审批 4：审批通过、5：审批未通过、6：检验鉴定完成）")
    private Integer status;
    /**
     * 是否发起申请1：是0：否
     */
    @ApiModelProperty("是否发起申请1：是0：否")
    private Integer isApply;
    /**
     * 是否再次申请1：是0：否
     */
    @ApiModelProperty("是否再次申请1：是0：否")
    private Integer isAgain;
    /**
     * 提交时间
     */
    @ApiModelProperty("提交时间")
    private String submitTime;
    /**
     * 提交时间起
     */
    @ApiModelProperty("提交时间起")
    private String submitTimeStart;
    /**
     * 提交时间始
     */
    @ApiModelProperty("提交时间始")
    private String submitTimeEnd;
    /**
     * 审批时间
     */
    @ApiModelProperty("审批时间")
    private String approvalTime;
    /**
     * 审批时间起
     */
    @ApiModelProperty("审批时间起")
    private String approvalTimeStart;
    /**
     * 审批时间始
     */
    @ApiModelProperty("审批时间始")
    private String approvalTimeEnd;
    /**
     * 总队审批意见
     */
    @ApiModelProperty("总队审批意见")
    private String corpsApprovalOpinion;
    /**
     * 科技处审批意见
     */
    @ApiModelProperty("科技处审批意见")
    private String kjcApprovalOpinion;
    /**
     * 检验人
     */
    @ApiModelProperty("检验人")
    private String inspector;
    /**
     * 检验人联系电话
     */
    @ApiModelProperty("检验人联系电话")
    private String inspectorTelephone;
    /**
     * 上传文件路径01
     */
    @ApiModelProperty("上传文件路径01")
    private String filePath01;
    /**
     * 上传文件路径02
     */
    @ApiModelProperty("上传文件路径02")
    private String filePath02;
    /**
     * 上传文件路径03
     */
    @ApiModelProperty("上传文件路径03")
    private String filePath03;
    /**
     * 上传文件路径04
     */
    @ApiModelProperty("上传文件路径04")
    private String filePath04;
    /**
     * 上传文件路径05
     */
    @ApiModelProperty("上传文件路径05")
    private String filePath05;



}
