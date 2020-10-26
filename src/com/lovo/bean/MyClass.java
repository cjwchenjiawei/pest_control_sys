package com.lovo.bean;

public class MyClass {
    private int pkid; //小班编号
    private String className; //小班名称
    private String leader; //负责人
    private String tel; //负责人电话
    private int number; //小班人数
    private Area area; //负责区域
    private String establishDate; //创建日期



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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "pkid=" + pkid +
                ", className='" + className + '\'' +
                ", leader='" + leader + '\'' +
                ", tel='" + tel + '\'' +
                ", number=" + number +
                ", area=" + area +
                ", establishDate='" + establishDate + '\'' +
                '}';
    }

    public MyClass(int pkid, String className, String leader, String tel, int number, Area area, String establishDate) {
        this.pkid = pkid;
        this.className = className;
        this.leader = leader;
        this.tel = tel;
        this.number = number;
        this.area = area;
        this.establishDate = establishDate;
    }

    public MyClass(String className, String leader, String tel, int number, Area area, String establishDate) {
        this.className = className;
        this.leader = leader;
        this.tel = tel;
        this.number = number;
        this.area = area;
        this.establishDate = establishDate;
    }

    public MyClass() {
    }
}
