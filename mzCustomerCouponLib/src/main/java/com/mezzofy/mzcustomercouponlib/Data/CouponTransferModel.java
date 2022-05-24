package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class CouponTransferModel {
    private String customer_id;
    private String sender_message;
    private String transfer_template_id;
    private String lang;
    private ArrayList<TransferTo> transfer_to;

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getSender_message() {
        return sender_message;
    }

    public void setSender_message(String sender_message) {
        this.sender_message = sender_message;
    }

    public String getTransfer_template_id() {
        return transfer_template_id;
    }

    public void setTransfer_template_id(String transfer_template_id) {
        this.transfer_template_id = transfer_template_id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ArrayList<TransferTo> getTransfer_to() {
        return transfer_to;
    }

    public void setTransfer_to(ArrayList<TransferTo> transfer_to) {
        this.transfer_to = transfer_to;
    }
}
