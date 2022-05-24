package com.mezzofy.mzcustomercouponlib.Data;

public class CouponCounts {
    private int available_coupon;
    private int issue_count;
    private int redeem_count;
    private int available_packs;
    private int issue_packs;
    private int redeem_packs;

    public int getAvailable_coupon() {
        return available_coupon;
    }

    public void setAvailable_coupon(int available_coupon) {
        this.available_coupon = available_coupon;
    }

    public int getIssue_count() {
        return issue_count;
    }

    public void setIssue_count(int issue_count) {
        this.issue_count = issue_count;
    }

    public int getRedeem_count() {
        return redeem_count;
    }

    public void setRedeem_count(int redeem_count) {
        this.redeem_count = redeem_count;
    }

    public int getAvailable_packs() {
        return available_packs;
    }

    public void setAvailable_packs(int available_packs) {
        this.available_packs = available_packs;
    }

    public int getIssue_packs() {
        return issue_packs;
    }

    public void setIssue_packs(int issue_packs) {
        this.issue_packs = issue_packs;
    }

    public int getRedeem_packs() {
        return redeem_packs;
    }

    public void setRedeem_packs(int redeem_packs) {
        this.redeem_packs = redeem_packs;
    }
}
