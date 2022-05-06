package com.mezzofy.mzcustomercouponlib.Data;

public class OutletAddress {
    private String id;
    private String kr;
    private String en;
    private String th;
//    @JsonProperty("zh-Hans")
    private String zhHans;
    private String jp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public String getZhHans() {
        return zhHans;
    }

    public void setZhHans(String zhHans) {
        this.zhHans = zhHans;
    }

    public String getJp() {
        return jp;
    }

    public void setJp(String jp) {
        this.jp = jp;
    }
}
