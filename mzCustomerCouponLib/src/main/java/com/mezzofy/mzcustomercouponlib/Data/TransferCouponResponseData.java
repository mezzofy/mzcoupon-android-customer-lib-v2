package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class TransferCouponResponseData {
    private String transfer_id;
    private String from_customer_id;
    private String merchant_id;
    private String status;
    private String sender_message;
    private ArrayList<ToCustomer> to_customer;

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
    }

    public String getFrom_customer_id() {
        return from_customer_id;
    }

    public void setFrom_customer_id(String from_customer_id) {
        this.from_customer_id = from_customer_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSender_message() {
        return sender_message;
    }

    public void setSender_message(String sender_message) {
        this.sender_message = sender_message;
    }

    public ArrayList<ToCustomer> getTo_customer() {
        return to_customer;
    }

    public void setTo_customer(ArrayList<ToCustomer> to_customer) {
        this.to_customer = to_customer;
    }
}
