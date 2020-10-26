package com.lovo.vo;

import com.lovo.bean.Area;

public class MyClassVO {
    private int pkid; //小班编号
    private String className; //小班名称
    private String leader; //负责人
    private String tel; //负责人电话
    private int number; //小班人数
    private String areaName; //负责区域
    private String forestType; //林种
    private String landType; //地类
    private String advantageTreeType; //优势树种
    private String establishDate; //创建日期

    @Override
    public String toString() {
        return "MyClassVO{" +
                "pkid=" + pkid +
                ", className='" + className + '\'' +
                ", leader='" + leader + '\'' +
                ", tel='" + tel + '\'' +
                ", number=" + number +
                ", areaName='" + areaName + '\'' +
                ", forestType='" + forestType + '\'' +
                ", landType='" + landType + '\'' +
                ", advantageTreeType='" + advantageTreeType + '\'' +
                ", establishDate='" + establishDate + '\'' +
                '}';
    }

    public String getForestType() {
        return forestType;
    }

    public void setForestType(String forestType) {
        this.forestType = forestType;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getAdvantageTreeType() {
        return advantageTreeType;
    }

    public void setAdvantageTreeType(String advantageTreeType) {
        this.advantageTreeType = advantageTreeType;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }
}
