package com.lovo.bean;

public class Pest {
    private int pkid;  //害虫编号
    private String pestName;  //害虫名字
    private String host;  //寄主
    private String breed; //繁殖
    private String enemy; //天敌
    private String larvaeImages; //幼虫图片
    private String adultImages; //幼虫图片
    private String detriment;  //主要危害
    private String control; //防治措施


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getLarvaeImages() {
        return larvaeImages;
    }

    public void setLarvaeImages(String larvaeImages) {
        this.larvaeImages = larvaeImages;
    }

    public String getAdultImages() {
        return adultImages;
    }

    public void setAdultImages(String adultImages) {
        this.adultImages = adultImages;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getPestName() {
        return pestName;
    }

    public void setPestName(String pestName) {
        this.pestName = pestName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDetriment() {
        return detriment;
    }

    public void setDetriment(String detriment) {
        this.detriment = detriment;
    }

    public Pest() {
    }

    public Pest(String pestName, String host, String breed, String enemy, String larvaeImages, String adultImages, String detriment, String control) {
        this.pestName = pestName;
        this.host = host;
        this.breed = breed;
        this.enemy = enemy;
        this.larvaeImages = larvaeImages;
        this.adultImages = adultImages;
        this.detriment = detriment;
        this.control = control;
    }

    public Pest(int pkid, String pestName, String host, String breed, String enemy, String larvaeImages, String adultImages, String detriment, String control) {
        this.pkid = pkid;
        this.pestName = pestName;
        this.host = host;
        this.breed = breed;
        this.enemy = enemy;
        this.larvaeImages = larvaeImages;
        this.adultImages = adultImages;
        this.detriment = detriment;
        this.control = control;
    }

    @Override
    public String toString() {
        return "Pest{" +
                "pkid=" + pkid +
                ", pestName='" + pestName + '\'' +
                ", host='" + host + '\'' +
                ", breed='" + breed + '\'' +
                ", enemy='" + enemy + '\'' +
                ", larvaeImages='" + larvaeImages + '\'' +
                ", adultImages='" + adultImages + '\'' +
                ", detriment='" + detriment + '\'' +
                ", control='" + control + '\'' +
                '}';
    }
}
