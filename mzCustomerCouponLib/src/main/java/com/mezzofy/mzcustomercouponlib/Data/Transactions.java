package com.mezzofy.mzcustomercouponlib.Data;

public class Transactions {
    private Issue issue;
    private Redeem redeem;
//    @JsonProperty("void")
    private Void myvoid;
    private Allocation allocation;

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Redeem getRedeem() {
        return redeem;
    }

    public void setRedeem(Redeem redeem) {
        this.redeem = redeem;
    }

    public Void getMyvoid() {
        return myvoid;
    }

    public void setMyvoid(Void myvoid) {
        this.myvoid = myvoid;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }
}
