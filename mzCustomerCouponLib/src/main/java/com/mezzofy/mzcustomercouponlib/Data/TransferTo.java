package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class TransferTo {
    private ArrayList<String> serials;
    private String customer_email;


    public ArrayList<String> getSerials() {
        return serials;
    }

    public void setSerials(ArrayList<String> serials) {
        this.serials = serials;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }
}
