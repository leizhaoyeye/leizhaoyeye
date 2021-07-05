package com.example.zhaolei.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *@ClassName PublicStaffInsuRegisterSaveDTO
 *@Description 人员参保登记信息
 *@Author hmq
 *@Date 2020/3/11 21:27
 *@Version 1.0
 **/
@Data
@ApiModel(value = "人员参保登记信息DTO")
public class PublicStaffInsuRegisterSaveDTO  implements Serializable {

    /**
     * 单位编号
     */
    //@NotNull(message = "单位编号不能为空！")
    @ApiModelProperty("单位编号")
    private String empNo;
    /**
     * 单位名称
     */
   // @NotNull(message = "单位名称不能为空！")
    @ApiModelProperty(value = "单位名称")
    private String empName;
    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为空！")
    @ApiModelProperty(value = "姓名")
    private String psnName;
    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    private String alis;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空！")
    @ApiModelProperty(value = "性别")
    private String gend;
    /**
     * 出生日期
     */
    @NotNull(message = "出生日期不能为空！")
    @ApiModelProperty(value = "出生日期")
    private Date brdy;
    /**
     * 人员证件类型
     */
    @NotNull(message = "证件类型不能为空！")
    @ApiModelProperty(value = "证件类型")
    private String psnCertType;
    /**
     * 证件号码
     */
    @NotNull(message = "证件号码不能为空！")
    @ApiModelProperty(value = "证件号码")
    private String certno;

    /**
     * 证件号码
     */
/*    @JsonProperty("证件号码")
    @ApiModelProperty(value = "证件号码")
    private String certNo;*/

    /**
     * 电子凭证号
     */
    @ApiModelProperty(value = "电子凭证号")
    private String hsecfc;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String tel;
    /**
     * 手机号码
     */
    @NotNull(message = "手机号码不能为空！")
    @ApiModelProperty(value = "手机号码")
    private String mob;
    /**
     * 民族
     */
    @NotNull(message = "民族不能为空！")
    @ApiModelProperty(value = "民族")
    private String naty;
    /**
     * 国家地区代码
     */
    @ApiModelProperty(value = "国家地区代码")
    private String natRegnCode;
    /**
     * 电子邮箱
     */
    @Email(message = "电子邮箱不正确")
    @Size(max = 50,message = "电子邮箱不能超过50位")
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    /**
     * 政治面貌
     */
    @NotNull(message = "政治面貌不能为空！")
    @ApiModelProperty(value = "政治面貌")
    private String polstas;
    /**
     * 首次参加工作日期
     */
    @NotNull(message = "首次参加工作日期不能为空！")
    @ApiModelProperty(value = "首次参加工作日期")
    private Date fstPatcJobDate;
    /**
     * 户口性质
     */
    @ApiModelProperty(value = "户口性质")
    private String resdNatu;
    /**
     * 户口所在地行政区
     */
    @ApiModelProperty(value = "户口所在地行政区")
    private String resdLocAdmdvs;
    /**
     * 户口地址
     */
    @NotNull(message = "户口地址不能为空！")
    //private String resdAddr;
    @ApiModelProperty(value = "户口地址")
    private String hsregAddr;

    /**
     * 户口所在地邮政编码
     */
    @ApiModelProperty(value = "户口所在地邮政编码")
    private String resdAddrPoscode;
    /**
     * 居住地行政区
     */
    @ApiModelProperty(value = "居住地行政区")
    private String liveAdmdvs;
    /**
     * 居住地址
     */
    @ApiModelProperty(value = "居住地址")
    private String liveAddr;
    /**
     * 居住地邮政编码
     */
    @ApiModelProperty(value = "居住地邮政编码")
    private String liveAddrPoscode;
    /**
     * 户口簿编号
     */
    @ApiModelProperty(value = "户口簿编号")
    private String resdbookNo;
    /**
     * 婚姻状况
     */
    @ApiModelProperty(value = "婚姻状况")
    private String mrgStas;
    /**
     * 健康状况
     */
//    @JsonProperty("健康状况")
//    @DataDictionary("HLCON")
//    @ExcelCellType(cellType = CellTypeEnums.STRING)
//    private String hlcon;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String memo;
    /**
     * 生存状态
     */
    @ApiModelProperty(value = "生存状态")
    private String survStas;
    /**
     * 多省维护标志
     */
    @ApiModelProperty(value = "多省维护标志")
    private String mulProvMntFlag;
    /**
     * 行政职务
     */
    @ApiModelProperty(value = "行政职务")
    private String admdut;
    /**
     * 就业状态
     */
    @ApiModelProperty(value = "就业状态")
    private String empStas;
    /**
     * 离退休类型
     */
    @ApiModelProperty(value = "离退休类型")
    private String retrType;
    /**
     * 毕业院校
     */
    @ApiModelProperty(value = "毕业院校")
    private String gradSchl;
    /**
     * 学历
     */
    @ApiModelProperty(value = "学历")
    private String educ;
    /**
     * 专业技术职务等级
     */
    @ApiModelProperty(value = "专业技术职务等级")
    private String proTechDutyLv;
    /**
     * 国家职业资格等级
     */
    @ApiModelProperty(value = "国家职业资格等级")
    private String natPrfsQuaLv;

    /**
     * 人员类型
     */
    //@NotNull(message = "人员类型不能为空！")
    @ApiModelProperty(value = "人员类型")
    private String psnType;

    /**
     * 申报工资
     */
    @NotNull(message = "申报工资不能为空！")
    @ApiModelProperty(value = "申报工资")
    private BigDecimal wag;
    /**
     * 银行ID（银行网点）
     */
    @ApiModelProperty(value = "银行ID（银行网点）")
    private String bankId;
    /**
     * 银行行别代码
     */
    @ApiModelProperty(value = "银行行别代码")
    private String bankTypeCode;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号")
    private String bankacct;
    /**
     * 银行户名
     */
    @ApiModelProperty(value = "银行户名")
    private String bankAcctname;
    /**
     * 用户信息 后台默认
     */
    //@NotNull(message = "用户信息不能为空！")
    @ApiModelProperty(value = "用户信息 后台默认")
    private PublicUserInfoDTO publicUserInfoDTO;
    /**
     * 人员参保信息
     **/
    // @NotNull(message = "人员参保信息不能为空！")
    @ApiModelProperty(value = "人员参保信息")
    private List<PublicPsnInsuCDTO> publicPsnInsuCDTOList;

    /**
     * 人员参保信息
     **/
    // @NotNull(message = "人员参保信息不能为空！")
    @ApiModelProperty(value = "人员参保信息")
    private List<PublicPsnInsuCDTO> publicPsnInsuCDTOS;

    /**
     * 用工形式
     */
    @ApiModelProperty(value = "用工形式")
    private String empFom;

    @ApiModelProperty(value = "单位管理类型")
    private String empMgtType;

   // @NotNull(message = "本次参加保作时间！")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "当前参保作时间")
    private Date crtInsuDate;

//    @NotNull(message = "险种类型不能为空！")
    @ApiModelProperty(value = "险种类型")
    private String[] insutypes;


    /**
     * 征收方式
     */
    private String clctWay;

    /**
     * 征缴规则类型编码
     */
    private String clctRuleTypeCodg;

    /**
     * 基数核定规则类型编码
     */
    private String clctstdCrtfRuleCodg;

    /**
     * 单位参保日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date empInsuDate;

    /**
     * 首次参保年月
     */
    private String fstInsuYm;

    /**
     * 个人参保日期
     */
    //@NotNull(message = "个人参保日期！")
    private Date psnInsuDate;


    private String insutypeRetrFlag;

    /**
     * 账户建立年月
     */
    private String acctCrtnYm;


}
