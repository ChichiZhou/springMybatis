package com.hezho.bean;

public class Husband {
    private int husbandId;
    private int wifeId;
    private String husbandName;
    private Wife wife;

    public int getHusbandId() {
        return husbandId;
    }

    public void setHusbandId(int husbandId) {
        this.husbandId = husbandId;
    }

    public int getWifeId() {
        return wifeId;
    }

    public void setWifeId(int wifeId) {
        this.wifeId = wifeId;
    }

    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
