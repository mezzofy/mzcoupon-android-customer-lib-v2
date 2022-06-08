package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class CouponModel {
    private Summary summary;
    private ArrayList<CouponData> results;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ArrayList<CouponData> getResults() {
        return results;
    }

    public void setResults(ArrayList<CouponData> results) {
        this.results = results;
    }
}
