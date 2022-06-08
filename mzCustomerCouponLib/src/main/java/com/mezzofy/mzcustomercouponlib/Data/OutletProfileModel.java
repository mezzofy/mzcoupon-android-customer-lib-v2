package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class OutletProfileModel {
    private Summary summary;
    private ArrayList<OutletProfileDataModel> results;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ArrayList<OutletProfileDataModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<OutletProfileDataModel> results) {
        this.results = results;
    }
}
