package com.mezzofy.mzcustomercouponlib.Data;

import java.util.Date;

public class TransactionDetail {

    private String transaction_detail_id;
    private String transaction_id;
    private String coupon_id;
    private Object product_id;
    private String coupon_name;
    private int coupon_price;
    private int coupon_qty;
    private int coupon_total;
    private String status;
    private Date created_on;
    private Date updated_on;
    private Object updated_by;
    private String notes;
    private String coupon_code;

    public String getTransaction_detail_id() {
        return transaction_detail_id;
    }

    public void setTransaction_detail_id(String transaction_detail_id) {
        this.transaction_detail_id = transaction_detail_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public Object getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Object product_id) {
        this.product_id = product_id;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public int getCoupon_price() {
        return coupon_price;
    }

    public void setCoupon_price(int coupon_price) {
        this.coupon_price = coupon_price;
    }

    public int getCoupon_qty() {
        return coupon_qty;
    }

    public void setCoupon_qty(int coupon_qty) {
        this.coupon_qty = coupon_qty;
    }

    public int getCoupon_total() {
        return coupon_total;
    }

    public void setCoupon_total(int coupon_total) {
        this.coupon_total = coupon_total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

    public Object getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Object updated_by) {
        this.updated_by = updated_by;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }
}
