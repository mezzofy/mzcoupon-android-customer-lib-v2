package com.mezzofy.mzcustomercouponlib.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectedLanguage {
    private String kr;
    @JsonProperty("zh-Hans")
    private String zhHans;
    @JsonProperty("zh-Hant")
    private String zhHant;
    private String jp;
    private String th;
    private String vi;
    private String en;
    private String id;

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getZhHans() {
        return zhHans;
    }

    public void setZhHans(String zhHans) {
        this.zhHans = zhHans;
    }

    public String getZhHant() {
        return zhHant;
    }

    public void setZhHant(String zhHant) {
        this.zhHant = zhHant;
    }

    public String getJp() {
        return jp;
    }

    public void setJp(String jp) {
        this.jp = jp;
    }

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
