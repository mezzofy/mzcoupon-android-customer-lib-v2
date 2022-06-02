package com.mezzofy.mzcustomercouponlib.Data;


import java.util.ArrayList;

public class TransactionDataModel {
    private TransactionData transaction;
    private ArrayList<TransactionDetail> transaction_details;

    public TransactionData getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionData transaction) {
        this.transaction = transaction;
    }

    public ArrayList<TransactionDetail> getTransaction_details() {
        return transaction_details;
    }

    public void setTransaction_details(ArrayList<TransactionDetail> transaction_details) {
        this.transaction_details = transaction_details;
    }
}
