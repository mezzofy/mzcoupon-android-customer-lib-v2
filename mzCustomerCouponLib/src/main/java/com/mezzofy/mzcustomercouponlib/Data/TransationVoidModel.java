package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class TransationVoidModel {

    private TxnVoid txn_void;
    private ArrayList<String> txn_serials;

    public TxnVoid getTxn_void() {
        return txn_void;
    }

    public void setTxn_void(TxnVoid txn_void) {
        this.txn_void = txn_void;
    }

    public ArrayList<String> getTxn_serials() {
        return txn_serials;
    }

    public void setTxn_serials(ArrayList<String> txn_serials) {
        this.txn_serials = txn_serials;
    }
}
