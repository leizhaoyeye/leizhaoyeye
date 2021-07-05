package com.example.zhaolei.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *@ClassName PublicUserInfoDTO
 *@Description 用户经办信息
 *@Author hmq
 *@Date 2020/3/11 21:24
 *@Version 1.0
 **/
@Data
@ApiModel(value = "用户经办信息DTO")
public class PublicUserInfoDTO implements Serializable {

    @ApiModelProperty(value = "创建人（用户id）")
    @NotNull(message = "创建人！")
    private String crterId;

    @ApiModelProperty(value = "创建人姓名（用户名称）")
    @NotNull(message = "创建人姓名不能为空！")
    private String crterName;

    @ApiModelProperty(value = "创建机构")
    private String crteOptinsNo;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date crteTime;

    @ApiModelProperty(value = "用户所属医保行政区划")
    @NotBlank(message = "医保行政区不能为空！")
    private String admDvs;

    public PublicUserInfoDTO(@NotNull(message = "创建人！") String crterId, @NotNull(message = "创建人姓名不能为空！") String crterName, String crteOptinsNo, Date crteTime, @NotBlank(message = "医保行政区不能为空！") String admDvs) {
        this.crterId = crterId;
        this.crterName = crterName;
        this.crteOptinsNo = crteOptinsNo;
        this.crteTime = crteTime;
        this.admDvs = admDvs;
    }

    public PublicUserInfoDTO() {
    }
}
