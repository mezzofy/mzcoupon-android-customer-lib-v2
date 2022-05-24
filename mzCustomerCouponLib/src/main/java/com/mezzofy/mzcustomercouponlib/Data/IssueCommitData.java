package com.mezzofy.mzcustomercouponlib.Data;

public class IssueCommitData {
    private String pay_receipt;
    private String payment_name;
    private String coupon_delivery_type;
    private  String purchase_receipt;
    private String template_id;
    private String receipt_template_id;
    private String transaction_gateway;
    private double transaction_amount;
    private String transaction_note;
    private String transaction_ref_no;
    private  String issue_reference;
    private String processed_by;
    private String reference_no;
    private String payment_info;

    public String getPay_receipt() {
        return pay_receipt;
    }

    public void setPay_receipt(String pay_receipt) {
        this.pay_receipt = pay_receipt;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
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

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getReceipt_template_id() {
        return receipt_template_id;
    }

    public void setReceipt_template_id(String receipt_template_id) {
        this.receipt_template_id = receipt_template_id;
    }

    public String getTransaction_gateway() {
        return transaction_gateway;
    }

    public void setTransaction_gateway(String transaction_gateway) {
        this.transaction_gateway = transaction_gateway;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_note() {
        return transaction_note;
    }

    public void setTransaction_note(String transaction_note) {
        this.transaction_note = transaction_note;
    }

    public String getTransaction_ref_no() {
        return transaction_ref_no;
    }

    public void setTransaction_ref_no(String transaction_ref_no) {
        this.transaction_ref_no = transaction_ref_no;
    }

    public String getIssue_reference() {
        return issue_reference;
    }

    public void setIssue_reference(String issue_reference) {
        this.issue_reference = issue_reference;
    }

    public String getProcessed_by() {
        return processed_by;
    }

    public void setProcessed_by(String processed_by) {
        this.processed_by = processed_by;
    }

    public String getReference_no() {
        return reference_no;
    }

    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
    }

    public String getPayment_info() {
        return payment_info;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }
}
