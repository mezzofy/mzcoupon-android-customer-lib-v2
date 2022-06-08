package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;
import java.util.Date;

public class IssueCommitResponseData {
    private String coupon_via;
    private Date created_on;
    private String customer_id;
    private String hash_code;
    private String merchant_id;
    private String pay_receipt;
    private String pay_response;
    private String payment_name;
    private Date po_date;
    private String transaction_id;
    private String po_no;
    private String po_status;
    private Object reward_point;
    private Date updated_on;
    private int po_total;
    private ArrayList<CustomerCouponData> customer_coupons;

    public String getCoupon_via() {
        return coupon_via;
    }

    public void setCoupon_via(String coupon_via) {
        this.coupon_via = coupon_via;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getHash_code() {
        return hash_code;
    }

    public void setHash_code(String hash_code) {
        this.hash_code = hash_code;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getPay_receipt() {
        return pay_receipt;
    }

    public void setPay_receipt(String pay_receipt) {
        this.pay_receipt = pay_receipt;
    }

    public String getPay_response() {
        return pay_response;
    }

    public void setPay_response(String pay_response) {
        this.pay_response = pay_response;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public Date getPo_date() {
        return po_date;
    }

    public void setPo_date(Date po_date) {
        this.po_date = po_date;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getPo_no() {
        return po_no;
    }

    public void setPo_no(String po_no) {
        this.po_no = po_no;
    }

    public String getPo_status() {
        return po_status;
    }

    public void setPo_status(String po_status) {
        this.po_status = po_status;
    }

    public Object getReward_point() {
        return reward_point;
    }

    public void setReward_point(Object reward_point) {
        this.reward_point = reward_point;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

    public int getPo_total() {
        return po_total;
    }

    public void setPo_total(int po_total) {
        this.po_total = po_total;
    }

    public ArrayList<CustomerCouponData> getCustomer_coupons() {
        return customer_coupons;
    }

    public void setCustomer_coupons(ArrayList<CustomerCouponData> customer_coupons) {
        this.customer_coupons = customer_coupons;
    }
}
