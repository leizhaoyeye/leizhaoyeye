package com.example.zhaolei.model.entity;


import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class LogisticsUploadModel {


    /**
     * 寄件人姓名
     */
    private String SENDER_NAME;

    /**
     * 寄件人手机号
     */
    private String SENDER_MOBILEPHONE;

    /**
     * 寄件人地址
     */
    private String SENDER_ADDRESS;


    /**
     * 收件人姓名
     */
    private String RECEIVER_NAME;


    /**
     * 收件人手机号
     */
    private String RECEIVER_MOBILEPHONE;


    /**
     * 收件人地址
     */
    private String RECEIVER_ADDRESS;


    /**
     * 寄送物品名称
     */
    private String GOODS;

    /**
     *下单时间(绝对秒)
     */
    private String CAPTURE_TIME;

    /**
     * 物流公司
     */
    private String EXPRESS_NAME;

    /**
     * 物品重量
     */
    private String GOODS_WEIGHT;

    /**
     * 物品体积
     */
    private String GOODS_VOLUME;

    /**
     * 是否保价
     */
    private String INSURED_TYPE;

    /**
     * 保价金额
     */
    private String INSURED_AMOUNT;


    public String getSENDER_NAME() {
        return SENDER_NAME;
    }

    public void setSENDER_NAME(String SENDER_NAME) {
        this.SENDER_NAME = SENDER_NAME;
    }

    public String getSENDER_MOBILEPHONE() {
        return SENDER_MOBILEPHONE;
    }

    public void setSENDER_MOBILEPHONE(String SENDER_MOBILEPHONE) {
        this.SENDER_MOBILEPHONE = SENDER_MOBILEPHONE;
    }

    public String getSENDER_ADDRESS() {
        return SENDER_ADDRESS;
    }

    public void setSENDER_ADDRESS(String SENDER_ADDRESS) {
        this.SENDER_ADDRESS = SENDER_ADDRESS;
    }

    public String getRECEIVER_NAME() {
        return RECEIVER_NAME;
    }

    public void setRECEIVER_NAME(String RECEIVER_NAME) {
        this.RECEIVER_NAME = RECEIVER_NAME;
    }

    public String getRECEIVER_MOBILEPHONE() {
        return RECEIVER_MOBILEPHONE;
    }

    public void setRECEIVER_MOBILEPHONE(String RECEIVER_MOBILEPHONE) {
        this.RECEIVER_MOBILEPHONE = RECEIVER_MOBILEPHONE;
    }

    public String getRECEIVER_ADDRESS() {
        return RECEIVER_ADDRESS;
    }

    public void setRECEIVER_ADDRESS(String RECEIVER_ADDRESS) {
        this.RECEIVER_ADDRESS = RECEIVER_ADDRESS;
    }

    public String getGOODS() {
        return GOODS;
    }

    public void setGOODS(String GOODS) {
        this.GOODS = GOODS;
    }

    public String getCAPTURE_TIME() {
        return CAPTURE_TIME;
    }

    public void setCAPTURE_TIME(String CAPTURE_TIME) {
        this.CAPTURE_TIME = CAPTURE_TIME;
    }

    public String getEXPRESS_NAME() {
        return EXPRESS_NAME;
    }

    public void setEXPRESS_NAME(String EXPRESS_NAME) {
        this.EXPRESS_NAME = EXPRESS_NAME;
    }

    public String getGOODS_WEIGHT() {
        return GOODS_WEIGHT;
    }

    public void setGOODS_WEIGHT(String GOODS_WEIGHT) {
        this.GOODS_WEIGHT = GOODS_WEIGHT;
    }

    public String getGOODS_VOLUME() {
        return GOODS_VOLUME;
    }

    public void setGOODS_VOLUME(String GOODS_VOLUME) {
        this.GOODS_VOLUME = GOODS_VOLUME;
    }

    public String getINSURED_TYPE() {
        return INSURED_TYPE;
    }

    public void setINSURED_TYPE(String INSURED_TYPE) {
        this.INSURED_TYPE = INSURED_TYPE;
    }

    public String getINSURED_AMOUNT() {
        return INSURED_AMOUNT;
    }

    public void setINSURED_AMOUNT(String INSURED_AMOUNT) {
        this.INSURED_AMOUNT = INSURED_AMOUNT;
    }
}
