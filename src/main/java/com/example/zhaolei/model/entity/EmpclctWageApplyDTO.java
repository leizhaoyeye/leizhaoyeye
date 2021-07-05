package com.example.zhaolei.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @ProjectName: hsa-iep-osc-local
 * @Package: cn.hsa.iep.osc.api.dto.request
 * @ClassName: empclctWageApplyDTO
 * @Author: LJP
 * @Description: 职工缴费工资申报
 * @Date: 2020/3/17 17:24
 * @Version: 1.0
 */
@Data
@ApiModel("职工缴费工资申报")
public class EmpclctWageApplyDTO  {

    @ApiModelProperty(value = "人员编号", required = true)
    private String psnNo;

    @ApiModelProperty(value = "险种类型", required = true)
    private String insutype;
    @ApiModelProperty(value = "姓名")
    private String psnName;
    @ApiModelProperty(value = "证件类型")
    private String psnCertType;

    @ApiModelProperty(value = "证件号码")
    private String certno;

    @ApiModelProperty(value = "开始年月")
    private String begnYm;

    @ApiModelProperty(value = "截止年月")
    private String endYm;

    @Min(value = 0, message = "工资不能小于0")
    @ApiModelProperty(value = "申报工资")
    private String wag;

    @ApiModelProperty(value = "人员参保关系ID")
    private String psnInsuRltsId;

    /**
     * 参保所属区划
     */
    private String insuAdmdvs;

    /**
     * 单位管理类型
     */
    private String empMgtType;

    /**
     * 单位类型
     */
    private String empType;

    /**
     * 险种类型中文
     */
    private String insutypeCHN;

    /**
     * 年月
     */
    private String ym;

    /**
     * 人员离退休标志
     */
    private String insutypeRetrFlag;

    private String psnInsuMgtEid;

    private Date crtInsuDate;


}
