package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class SerialResponse {
    private Summary summary;
    private ArrayList<Couponserialresults> results;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ArrayList<Couponserialresults> getResults() {
        return results;
    }

    public void setResults(ArrayList<Couponserialresults> results) {
        this.results = results;
    }
}
