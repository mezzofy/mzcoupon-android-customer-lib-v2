package com.mezzofy.mzcustomercouponlib.Data;

import java.util.Date;

public class IssueCouponResponseData {
    private String transaction_id;
    private Date updated_on;
    private String po_status;
    private Date po_date;
    private String pay_response;
    private String merchant_id;
    private Object pay_receipt;
    private String coupon_via;
    private int po_total;
    private String hash_code;
    private Date created_on;
    private Object reward_point;
    private Object payment_name;
    private String customer_id;
    private String po_no;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

    public String getPo_status() {
        return po_status;
    }

    public void setPo_status(String po_status) {
        this.po_status = po_status;
    }

    public Date getPo_date() {
        return po_date;
    }

    public void setPo_date(Date po_date) {
        this.po_date = po_date;
    }

    public String getPay_response() {
        return pay_response;
    }

    public void setPay_response(String pay_response) {
        this.pay_response = pay_response;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Object getPay_receipt() {
        return pay_receipt;
    }

    public void setPay_receipt(Object pay_receipt) {
        this.pay_receipt = pay_receipt;
    }

    public String getCoupon_via() {
        return coupon_via;
    }

    public void setCoupon_via(String coupon_via) {
        this.coupon_via = coupon_via;
    }

    public int getPo_total() {
        return po_total;
    }

    public void setPo_total(int po_total) {
        this.po_total = po_total;
    }

    public String getHash_code() {
        return hash_code;
    }

    public void setHash_code(String hash_code) {
        this.hash_code = hash_code;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Object getReward_point() {
        return reward_point;
    }

    public void setReward_point(Object reward_point) {
        this.reward_point = reward_point;
    }

    public Object getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(Object payment_name) {
        this.payment_name = payment_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPo_no() {
        return po_no;
    }

    public void setPo_no(String po_no) {
        this.po_no = po_no;
    }
}
