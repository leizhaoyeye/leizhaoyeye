package com.example.zhaolei.model.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *@ClassName PublicPsnInsuCDTO
 *@Description 人员险种信息
 *@Author hmq
 *@Date 2020/3/18 23:03
 *@Version 1.0
 **/
@Data
public class PublicPsnInsuCDTO implements Serializable {
    private static final long serialVersionUID = 896474374143063958L;
    /**
     * 人员参保关系ID
     */
    private String psnInsuRltsId;
    /**
     * 单位编号
     */
    private String empNo;
    /**
     * 人员编号
     */
    private String psnNo;
    /**
     * 医疗保险类别
     */
    private String hiType;
    /**
     * 险种类型
     */
    @NotNull(message = "险种类型不能为空！")
    private String insutype;
    /**
     * 人员参保状态
     */
    private String psnInsuStas;
    /**
     * 首次参保年月
     */
    @NotNull(message = "首次参保年月不能为空！")
    private String fstInsuYm;

    /**
     * 本次参加操作时间
     */
    @NotNull(message = "本次参加操作时间不能为空！")
    private Date crtInsuDate;
    /**
     * 个人参保日期
     */
    @NotNull(message = "个人参保日期！")
    private Date psnInsuDate;
    /**
     * 账户建立年月
     */
    @NotNull(message = "账户建立年月！")
    private String acctCrtnYm;
    /**
     * 最大做账期号
     */
    @NotNull(message = "最大做账期号不能为空！")
    private String maxAcctprd;
    /**
     * 征缴规则类型编码
     */
    @NotNull(message = "征缴规则类型编码不能为空！")
    private String clctRuleTypeCodg;
    /**
     * 基数核定规则类型编码
     */
    @NotNull(message = "基数核定规则类型编码不能为空！")
    private String clctstdCrtfRuleCodg;
    /**
     * 参保所属机构
     */
    @NotNull(message = "参保所属机构不能为空！")
    private String insuAdmdvs;
    /**
     * 统筹区
     */
    @NotNull(message = "统筹区不能为空！")
    private String poolareaNo;
    /**
     * 人员类型
     */
    @NotNull(message = "人员类型不能为空！")
    private String psnType;
    /**
     * 编制类型
     */
    private String qutsType;
    /**
     * 征收方式
     */
    private String clctWay;
    /**
     * 用工形式
     */
    private String empFom;
    /**
     * 险种离退休标志
     */
    private String insutypeRetrFlag;

    /**
     * 数据变更类型
     */
    private String dataChgType;

}
