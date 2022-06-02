package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class TransactionModel {
    public Summary summary;
    public ArrayList<TransactionDataModel> results;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ArrayList<TransactionDataModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<TransactionDataModel> results) {
        this.results = results;
    }
}
