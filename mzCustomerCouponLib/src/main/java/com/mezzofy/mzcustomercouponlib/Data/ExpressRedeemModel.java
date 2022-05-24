package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class ExpressRedeemModel {
    private TxnRedeem txn_redeem;
    private ArrayList<TxnSerial> txn_serials;

    public TxnRedeem getTxn_redeem() {
        return txn_redeem;
    }

    public void setTxn_redeem(TxnRedeem txn_redeem) {
        this.txn_redeem = txn_redeem;
    }

    public ArrayList<TxnSerial> getTxn_serials() {
        return txn_serials;
    }

    public void setTxn_serials(ArrayList<TxnSerial> txn_serials) {
        this.txn_serials = txn_serials;
    }
}
