package com.mezzofy.mzcustomercouponlib.Data;

public class TxnRedeem {
    private String outlet_id;
    private String lang;
    private String transaction_by;
    private String transaction_note;

    public String getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(String outlet_id) {
        this.outlet_id = outlet_id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTransaction_by() {
        return transaction_by;
    }

    public void setTransaction_by(String transaction_by) {
        this.transaction_by = transaction_by;
    }

    public String getTransaction_note() {
        return transaction_note;
    }

    public void setTransaction_note(String transaction_note) {
        this.transaction_note = transaction_note;
    }
}
