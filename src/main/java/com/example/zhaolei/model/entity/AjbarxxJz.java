package com.example.zhaolei.model.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class AjbarxxJz  {

    private static final long serialVersionUID = 1L;


    /**
     * 标识ID
     */
    @TableField(value = "FHXTSJWYBSID")
    @ApiModelProperty(value = "标识ID")
    private String fhxtsjwybsid;

    /**
     * 来源系统
     */
    @ApiModelProperty(value = "来源系统")
    @TableField(value = "SJCJLYXT")
    private String sjcjlyxt;

    /**
     * 来源系统备注
     */
    @ApiModelProperty(value = "来源系统备注")
    @TableField(value = "SJCJLYXTBZ")
    private String sjcjlyxtbz;

    /**
     * 来源部门
     */
    @ApiModelProperty(value = "来源部门")
    @TableField(value = "SJCJLYBM")
    private String sjcjlybm;

    /**
     * 来源表名
     */
    @ApiModelProperty(value = "来源表名")
    @TableField(value = "SJCJLYBM1")
    private String sjcjlybm1;

    /**
     * 来源地
     */
    @ApiModelProperty(value = "来源地")
    @TableField(value = "SJCJLYD")
    private String sjcjlyd;

    /**
     * 采集时间
     */
    @ApiModelProperty(value = "采集时间")
    @TableField(value = "CJSJ")
    private Date cjsj;

    /**
     * 原始系统主键
     */
    @ApiModelProperty(value = "原始系统主键")
    @TableField(value = "YSXTJRZJ")
    private String ysxtjrzj;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "GXSJ")
    private Date gxsj;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableField(value = "XXSC_PDBZ")
    private String xxsc_pdbz;

    /**
     * 数据敏感级别
     */
    @ApiModelProperty(value = "数据敏感级别")
    @TableField(value = "SJMGJBBM")
    private String sjmgjbbm;

    /**
     * 数据库回溯
     */
    @ApiModelProperty(value = "数据库回溯")
    @TableField(value = "SJKHSBSF")
    private String sjkhsbsf;

    /**
     * 业务标签标识
     */
    @ApiModelProperty(value = "业务标签标识")
    @TableField(value = "YWBQBS")
    private String ywbqbs;

    /**
     * 行为标签标识
     */
    @ApiModelProperty(value = "行为标签标识")
    @TableField(value = "XWBQBS")
    private String xwbqbs;

    /**
     * 案件编号
     */
    @ApiModelProperty(value = "案件编号")
    @TableField(value = "CASE_NO")
    private String caseNo;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    @TableField(value = "SERI_NUM")
    private String seriNum;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @TableField(value = "NAME")
    private String name;

    /**
     * 性别代码
     */
    @ApiModelProperty(value = "性别代码")
    @TableField(value = "SEX")
    private String sex;

    /**
     * 性别（民族文字）
     */
    @ApiModelProperty(value = "性别（民族文字）")
    @TableField(value = "SEX_DESIG")
    private String sexDesig;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    @TableField(value = "AGE")
    private Integer age;

    /**
     * 常用证件代码
     */
    @ApiModelProperty(value = "常用证件代码")
    @TableField(value = "COMM_CERT_CODE")
    private String commCertCode;

    /**
     * 常用证件名称
     */
    @ApiModelProperty(value = "常用证件名称")
    @TableField(value = "COMM_CERT_NAME")
    private String commCertName;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    @TableField(value = "CRED_NUM")
    private String credNum;

    /**
     * 住址_行政区划代码
     */
    @ApiModelProperty(value = "住址_行政区划代码")
    @TableField(value = "ADDR_ADDI_CODE")
    private String addrAddiCode;

    /**
     * 住址_行政区划名称
     */
    @ApiModelProperty(value = "住址_行政区划名称")
    @TableField(value = "ADDR_ADMIN_NAME")
    private String addrAdminName;

    /**
     * 住址_地址名称
     */
    @ApiModelProperty(value = "住址_地址名称")
    @TableField(value = "ADDR_ADDR_NAME")
    private String addrAddrName;

    /**
     * 工作单位_单位名称
     */
    @ApiModelProperty(value = "工作单位_单位名称")
    @TableField(value = "WORK_UNIT_COMP_NAME")
    private String workNnitCompName;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    @TableField(value = "CTCT_TEL")
    private String ctctTel;

    /**
     * 录入单位_公安机关机构代码
     */
    @ApiModelProperty(value = "录入单位_公安机关机构代码")
    @TableField(value = "INPUT_UNIT_PSAG_CODE")
    private String inputUnitPsagCode;

    /**
     * 录入单位_公安机关名称
     */
    @ApiModelProperty(value = "录入单位_公安机关名称")
    @TableField(value = "INPUT_UNIT_PSAG")
    private String inputUnitPsag;

    /**
     * 录入人_姓名
     */
    @ApiModelProperty(value = "录入人_姓名")
    @TableField(value = "INPUT_PERS_NAME")
    private String inputPersName;

    /**
     * 录入时间
     */
    @ApiModelProperty(value = "录入时间")
    @TableField(value = "INPUT_TIME")
    private Date inputTime;

    /**
     * 呈送审批单位_公安机关机构代码
     */
    @ApiModelProperty(value = "呈送审批单位_公安机关机构代码")
    @TableField(value = "SEND_APPAUT_PSAG_CODE")
    private String sendAppautPsagCode;

    /**
     * 呈送审批单位_公安机关名称
     */
    @ApiModelProperty(value = "呈送审批单位_公安机关名称")
    @TableField(value = "SEND_APPAUT_PSAG")
    private String sendAppautPsag;

    /**
     * 呈送删除审批单位_公安机关机构代码
     */
    @ApiModelProperty(value = "呈送删除审批单位_公安机关机构代码")
    @TableField(value = "SENDEL_APPAUT_PSAG_CODE")
    private String sendelAppautPsagCode;

    /**
     * 呈送删除审批单位_公安机关名称
     */
    @ApiModelProperty(value = "呈送删除审批单位_公安机关名称")
    @TableField(value = "SENDEL_APPAUT_PSAG")
    private String sendelAppautPsag;

    /**
     * 删除原因
     */
    @ApiModelProperty(value = "删除原因")
    @TableField(value = "DELE_REAS")
    private String deleReas;

    /**
     * 住址_街路巷代码
     */
    @ApiModelProperty(value = "住址_街路巷代码")
    @TableField(value = "ADDR_STREET_CODE")
    private String addrStreetCode;

    /**
     * 住址_街路巷名称
     */
    @ApiModelProperty(value = "住址_街路巷名称")
    @TableField(value = "ADDR_STREET_NAME")
    private String addrStreetName;

    /**
     * 住址_门（楼）牌号
     */
    @ApiModelProperty(value = "住址_门（楼）牌号")
    @TableField(value = "ADDR_DOOR_NO")
    private String addrDoorNo;

    /**
     * 住址_门（楼）详细地址
     */
    @ApiModelProperty(value = "住址_门（楼）详细地址")
    @TableField(value = "ADDR_DOOR_DETA_ADDR")
    private String addrDoorDetaAddr;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @TableField(value = "BIRTH_DATE")
    private String birthDate;

    /**
     * 保密级别名称
     */
    @ApiModelProperty(value = "保密级别名称")
    @TableField(value = "SECLEV_NAME")
    private String seclevName;

    /**
     * 人员_编号
     */
    @ApiModelProperty(value = "人员_编号")
    @TableField(value = "PERSON_NO")
    private String personNo;

    /**
     * 曾用名
     */
    @ApiModelProperty(value = "曾用名")
    @TableField(value = "FUR_NAME")
    private String furName;

    /**
     * 婚姻状况代码
     */
    @ApiModelProperty(value = "婚姻状况代码")
    @TableField(value = "MAR_STA_CODE")
    private String marStaCode;

    /**
     * 婚姻状况名称
     */
    @ApiModelProperty(value = "婚姻状况名称")
    @TableField(value = "MAR_STA_NAME")
    private String marStaName;

    /**
     * 特殊身份代码
     */
    @ApiModelProperty(value = "特殊身份代码")
    @TableField(value = "SPEC_IDEN_CODE")
    private String specIdenCode;

    /**
     * 特殊身份名称
     */
    @ApiModelProperty(value = "特殊身份名称")
    @TableField(value = "SPEC_IDEN_NAME")
    private String specIdenName;

    /**
     * 个人身份代码
     */
    @ApiModelProperty(value = "个人身份代码")
    @TableField(value = "SELF_IDEN_CODE")
    private String selfIdenCode;

    /**
     * 个人身份名称
     */
    @ApiModelProperty(value = "个人身份名称")
    @TableField(value = "SELF_IDEN_NAME")
    private String selfIdenName;

    /**
     * 职业类别代码
     */
    @ApiModelProperty(value = "职业类别代码")
    @TableField(value = "PROF_TCODE")
    private String profTcode;

    /**
     * 职业类别名称
     */
    @ApiModelProperty(value = "职业类别名称")
    @TableField(value = "PROF_TNAME")
    private String profTname;

    /**
     * 报案人_单位_行政区划代码
     */
    @ApiModelProperty(value = "报案人_单位_行政区划代码")
    @TableField(value = "REPORTER_COM_ADDI_CODE")
    private String reporterComAddiCode;

    /**
     * 报案人_单位_行政区划名称
     */
    @ApiModelProperty(value = "报案人_单位_行政区划名称")
    @TableField(value = "REPORTER_COM_ADMIN_NAME")
    private String reporterComAdminName;

    /**
     * 实际居住地_行政区划代码
     */
    @ApiModelProperty(value = "实际居住地_行政区划代码")
    @TableField(value = "ACTU_LIVE_ADDR_ADDI_CODE")
    private String actuLiveAddrAddiCode;

    /**
     * 实际居住地_行政区划名称
     */
    @ApiModelProperty(value = "实际居住地_行政区划名称")
    @TableField(value = "ACTU_LIVE_ADDR_ADMIN_NAME")
    private String actuLiveAddrAdminName;

    /**
     * 国籍代码
     */
    @ApiModelProperty(value = "国籍代码")
    @TableField(value = "NATION_CODE")
    private String nationCode;

    /**
     * 国籍名称
     */
    @ApiModelProperty(value = "国籍名称")
    @TableField(value = "NATION_NAME")
    private String nationName;

    /**
     * 外文姓
     */
    @ApiModelProperty(value = "外文姓")
    @TableField(value = "FOR_FIRST_NAME")
    private String forFirstName;

    /**
     * 外文名
     */
    @ApiModelProperty(value = "外文名")
    @TableField(value = "FOR_LAST_NAME")
    private String forLastName;


    /**
     * 籍贯省市县代码
     */
    @ApiModelProperty(value = "籍贯省市县代码")
    @TableField(value = "NATIVE_ADDI_CODE")
    private String nativeAddiCode;

    /**
     * 籍贯省市县名称
     */
    @ApiModelProperty(value = "籍贯省市县名称")
    @TableField(value = "NATIVE_ADDI_NAME")
    private String nativeAddiName;

    /**
     * 民族代码
     */
    @ApiModelProperty(value = "民族代码")
    @TableField(value = "NATION")
    private String nation;

    /**
     * 民族（民族文字）
     */
    @ApiModelProperty(value = "民族（民族文字）")
    @TableField(value = "NATION_DESIG")
    private String nationDesig;

    /**
     * 别名/绰号
     */
    @ApiModelProperty(value = "别名/绰号")
    @TableField(value = "ALIAS")
    private String alias;

    /**
     * 其他证件_常用证件代码
     */
    @ApiModelProperty(value = "其他证件_常用证件代码")
    @TableField(value = "OTHE_CERT_COMM_CERT_CODE")
    private String otheCertCommCertCode;

    /**
     * 其他证件_常用证件名称
     */
    @ApiModelProperty(value = "其他证件_常用证件名称")
    @TableField(value = "OTHE_CERT_COMM_CERT_NAME")
    private String otheCertCommCertName;

    /**
     * 其他证件_证件号码
     */
    @ApiModelProperty(value = "其他证件_证件号码")
    @TableField(value = "OTHE_CERT_CRED_NUM")
    private String otheCertCredNum;

    /**
     * 户籍地址_地址名称
     */
    @ApiModelProperty(value = "户籍地址_地址名称")
    @TableField(value = "DOMIC_ADDR_NAME")
    private String domicAddrName;

    /**
     * 户籍地址_行政区划代码
     */
    @ApiModelProperty(value = "户籍地址_行政区划代码")
    @TableField(value = "DOMIC_ADDI_CODE")
    private String domicAddiCode;

    /**
     * 户籍地址_行政区划名称
     */
    @ApiModelProperty(value = "户籍地址_行政区划名称")
    @TableField(value = "DOMIC_ADMIN_NAME")
    private String domicAdminName;

    /**
     * 学历代码
     */
    @ApiModelProperty(value = "学历代码")
    @TableField(value = "EDUC_CODE")
    private String educCode;

    /**
     * 学历名称
     */
    @ApiModelProperty(value = "学历名称")
    @TableField(value = "EDUHIS_NAME")
    private String eduhisName;

    /**
     * 居留缘由_详细情况
     */
    @ApiModelProperty(value = "居留缘由_详细情况")
    @TableField(value = "RESI_REAS_DETA_INFO")
    private String resiReasDetaInfo;

    /**
     * 停留事由_简要情况
     */
    @ApiModelProperty(value = "停留事由_简要情况")
    @TableField(value = "STAY_REAS_BRIEF_COND")
    private String stayReasBriefCond;

    /**
     * 来华原因_详细情况
     */
    @ApiModelProperty(value = "来华原因_详细情况")
    @TableField(value = "COCHI_REAS_DETA_INFO")
    private String cochiReasDetaInfo;

    /**
     * 落脚点_地点名称
     */
    @ApiModelProperty(value = "落脚点_地点名称")
    @TableField(value = "FOOTHOLD_PLAC_NAME")
    private String footholdPlacName;

    /**
     * 签证（居留许可）种类代码
     */
    @ApiModelProperty(value = "签证（居留许可）种类代码")
    @TableField(value = "VISA_TCODE")
    private String visaTcode;


    /**
     * 签证（居留许可）种类名称
     */
    @ApiModelProperty(value = "签证（居留许可）种类名称")
    @TableField(value = "VISA_TNAME")
    private String visaTname;

    /**
     * 签证（居留许可）号
     */
    @ApiModelProperty(value = "签证（居留许可）号")
    @TableField(value = "VISA_NO")
    private String visaNo;

    /**
     * 签证（居留许可）签发机关名称
     */
    @ApiModelProperty(value = "签证（居留许可）签发机关名称")
    @TableField(value = "VISA_OFFI_DESC")
    private String visaOffiDesc;

    /**
     * 联系人_姓名
     */
    @ApiModelProperty(value = "联系人_姓名")
    @TableField(value = "CTCT_PERSON_NAME")
    private String ctctPersonName;


    /**
     * 接待人_联系电话
     */
    @ApiModelProperty(value = "接待人_联系电话")
    @TableField(value = "RECEPTION_PERS_CTCT_TEL")
    private String receptionPersCtctTel;

    /**
     * 接待人_名称
     */
    @ApiModelProperty(value = "接待人_名称")
    @TableField(value = "RECEPTION_PERS_DESIG")
    private String receptionPersDesig;

    /**
     * 在押_判断标识
     */
    @ApiModelProperty(value = "在押_判断标识")
    @TableField(value = "DETAIN_JUDGE_FLAG")
    private String detainJudgeFlag;

    /**
     * 人员类型代码
     */
    @ApiModelProperty(value = "人员类型代码")
    @TableField(value = "PER_CLAS_CODE")
    private String perClasCode;

    /**
     * 人员类型名称
     */
    @ApiModelProperty(value = "人员类型名称")
    @TableField(value = "PER_CLAS_NAME")
    private String perClasName;


    /**
     * 人员状态代码
     */
    @ApiModelProperty(value = "人员状态代码")
    @TableField(value = "PER_STAT_CODE")
    private String perStatCode;

    /**
     * 人员状态名称
     */
    @ApiModelProperty(value = "人员状态名称")
    @TableField(value = "PER_STAT_NAME")
    private String perStatName;

    /**
     * 人身受害形式代码
     */
    @ApiModelProperty(value = "人身受害形式代码")
    @TableField(value = "BODY_INJU_FORM_CODE")
    private String bodyInjuFormCode;

    /**
     * 人身受害形式名称
     */
    @ApiModelProperty(value = "人身受害形式名称")
    @TableField(value = "BODY_INJU_FORM_NAME")
    private String bodyInjuFormName;

    /**
     * 人身伤害程度代码
     */
    @ApiModelProperty(value = "人身伤害程度代码")
    @TableField(value = "BODY_INJU_DEGR_CODE")
    private String bodyInjuDegrCode;

    /**
     * 人身伤害程度名称
     */
    @ApiModelProperty(value = "人身伤害程度名称")
    @TableField(value = "BODY_INJU_DEGR_NAME")
    private String bodyInjuDegrName;

    /**
     * 涉案价值（万元）
     */
    @ApiModelProperty(value = "涉案价值（万元）")
    @TableField(value = "WADE_CASE_VALUE_WY")
    private Integer wadeCaseValueMy;

    /**
     * 损失价值（人民币万元）
     */
    @ApiModelProperty(value = "损失价值（人民币万元）")
    @TableField(value = "LOST_VAL_WY")
    private Integer lostValWy;

    /**
     * 挽回价值（万元）
     */
    @ApiModelProperty(value = "挽回价值（万元）")
    @TableField(value = "RED_VALUE")
    private Integer redValue;

    /**
     * 侵犯/被侵犯_判断标识
     */
    @ApiModelProperty(value = "侵犯/被侵犯_判断标识")
    @TableField(value = "VIOL_JUDGE_FLAG")
    private String violJudgeFlag;

    /**
     * 伤亡情况_简要情况
     */
    @ApiModelProperty(value = "伤亡情况_简要情况")
    @TableField(value = "MART_SITU_BRIEF_COND")
    private String martSituBriefCond;

    /**
     * 人员来源_简要情况
     */
    @ApiModelProperty(value = "人员来源_简要情况")
    @TableField(value = "PER_SOUR_BRIEF_COND")
    private String perSourBriefCond;

    /**
     * 公安机关机构代码
     */
    @ApiModelProperty(value = "公安机关机构代码")
    @TableField(value = "PSAG_CODE")
    private String psagCode;

    /**
     * 公安机关名称
     */
    @ApiModelProperty(value = "公安机关名称")
    @TableField(value = "PSAG")
    private String psag;

    /**
     * 保密级别代码
     */
    @ApiModelProperty(value = "保密级别代码")
    @TableField(value = "SECLEV_CODE")
    private String seclevCode;

    /**
     * 解救类型_简要情况
     */
    @ApiModelProperty(value = "解救类型_简要情况")
    @TableField(value = "RESC_TYPE_BRIEF_COND")
    private String rescTypeBriefCond;

    /**
     * 侵害人_个人身份代码
     */
    @ApiModelProperty(value = "侵害人_个人身份代码")
    @TableField(value = "INFRI_SELF_IDEN_CODE")
    private String infriSelfIdenCode;

    /**
     * 侵害人_个人身份名称
     */
    @ApiModelProperty(value = "侵害人_个人身份名称")
    @TableField(value = "INFRI_SELF_IDEN_NAME")
    private String infriSelfIdenName;

    /**
     * 被侵害人_个人身份代码
     */
    @ApiModelProperty(value = "被侵害人_个人身份代码")
    @TableField(value = "BE_VIOPER_SELF_IDEN_CODE")
    private String beVioperSelfIdenCode;

    /**
     * 被侵害人_个人身份名称
     */
    @ApiModelProperty(value = "被侵害人_个人身份名称")
    @TableField(value = "BE_VIOPER_SELF_IDEN_NAME")
    private String beVioperSelfIdenName;

    /**
     * 创建人_姓名
     */
    @ApiModelProperty(value = "创建人_姓名")
    @TableField(value = "CREATER_NAME")
    private Date createrName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREAT_TIME")
    private String creatTime;

    /**
     * 最后_修改人_姓名
     */
    @ApiModelProperty(value = "最后_修改人_姓名")
    @TableField(value = "LAST_MODI_PER_NAME")
    private String lastModiPerName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @TableField(value = "REM")
    private String rem;

}
