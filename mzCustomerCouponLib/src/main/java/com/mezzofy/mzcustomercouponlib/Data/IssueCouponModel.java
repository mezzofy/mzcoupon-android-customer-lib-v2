package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class IssueCouponModel {
    private IssueCustomer customer;
    private String delivery_method;
    private String coupon_delivery_type;
    private String purchase_receipt;
    private String receipt_template_id;
    private String template_id;
    private String payment_name;
    private String issue_type;
    private String transaction_method;
    private double transaction_amount;
    private String lang;
    private ArrayList<IssueCouponData> coupons;

    public IssueCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(IssueCustomer customer) {
        this.customer = customer;
    }

    public String getDelivery_method() {
        return delivery_method;
    }

    public void setDelivery_method(String delivery_method) {
        this.delivery_method = delivery_method;
    }

    public String getCoupon_delivery_type() {
        return coupon_delivery_type;
    }

    public void setCoupon_delivery_type(String coupon_delivery_type) {
        this.coupon_delivery_type = coupon_delivery_type;
    }

    public String getPurchase_receipt() {
        return purchase_receipt;
    }

    public void setPurchase_receipt(String purchase_receipt) {
        this.purchase_receipt = purchase_receipt;
    }

    public String getReceipt_template_id() {
        return receipt_template_id;
    }

    public void setReceipt_template_id(String receipt_template_id) {
        this.receipt_template_id = receipt_template_id;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public String getIssue_type() {
        return issue_type;
    }

    public void setIssue_type(String issue_type) {
        this.issue_type = issue_type;
    }

    public String getTransaction_method() {
        return transaction_method;
    }

    public void setTransaction_method(String transaction_method) {
        this.transaction_method = transaction_method;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ArrayList<IssueCouponData> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<IssueCouponData> coupons) {
        this.coupons = coupons;
    }
}
