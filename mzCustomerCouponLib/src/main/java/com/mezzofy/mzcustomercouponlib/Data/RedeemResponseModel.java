package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class RedeemResponseModel {
    private ArrayList<String> txn_serials;
    private RedeemResponse redeem_response;

    public ArrayList<String> getTxn_serials() {
        return txn_serials;
    }

    public void setTxn_serials(ArrayList<String> txn_serials) {
        this.txn_serials = txn_serials;
    }

    public RedeemResponse getRedeem_response() {
        return redeem_response;
    }

    public void setRedeem_response(RedeemResponse redeem_response) {
        this.redeem_response = redeem_response;
    }
}
