package com.mezzofy.mzcustomercoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.mezzofy.mzcustomercouponlib.Data.CouponData;
import com.mezzofy.mzcustomercouponlib.Data.CouponModel;
import com.mezzofy.mzcustomercouponlib.Data.CouponTransferModel;
import com.mezzofy.mzcustomercouponlib.Data.Couponserialresults;
import com.mezzofy.mzcustomercouponlib.Data.CustomerData;
import com.mezzofy.mzcustomercouponlib.Data.CustomerModel;
import com.mezzofy.mzcustomercouponlib.Data.CustomerRegisterData;
import com.mezzofy.mzcustomercouponlib.Data.CustomerRegisterModel;
import com.mezzofy.mzcustomercouponlib.Data.ExpressRedeemModel;
import com.mezzofy.mzcustomercouponlib.Data.IssueCommitData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCommitResponseData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCouponData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCouponModel;
import com.mezzofy.mzcustomercouponlib.Data.IssueCouponResponseData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCustomer;
import com.mezzofy.mzcustomercouponlib.Data.LoginRequest;
import com.mezzofy.mzcustomercouponlib.Data.LoginResponse;
import com.mezzofy.mzcustomercouponlib.Data.MerchantDownloadSettings;
import com.mezzofy.mzcustomercouponlib.Data.MerchantModel;
import com.mezzofy.mzcustomercouponlib.Data.MerchantSettingModel;
import com.mezzofy.mzcustomercouponlib.Data.OutletProfile;
import com.mezzofy.mzcustomercouponlib.Data.OutletProfileModel;
import com.mezzofy.mzcustomercouponlib.Data.PaymentModel;
import com.mezzofy.mzcustomercouponlib.Data.RedeemCommit;
import com.mezzofy.mzcustomercouponlib.Data.RedeemResponse;
import com.mezzofy.mzcustomercouponlib.Data.RedeemResponseModel;
import com.mezzofy.mzcustomercouponlib.Data.ReferenceUpdateData;
import com.mezzofy.mzcustomercouponlib.Data.SerialResponse;
import com.mezzofy.mzcustomercouponlib.Data.TransactionModel;
import com.mezzofy.mzcustomercouponlib.Data.TransationVoidModel;
import com.mezzofy.mzcustomercouponlib.Data.TransferCouponResponseData;
import com.mezzofy.mzcustomercouponlib.Data.TransferTo;
import com.mezzofy.mzcustomercouponlib.Data.TxnRedeem;
import com.mezzofy.mzcustomercouponlib.Data.TxnSerial;
import com.mezzofy.mzcustomercouponlib.Data.TxnVoid;
import com.mezzofy.mzcustomercouponlib.Data.VoidIssueReponseData;
import com.mezzofy.mzcustomercouponlib.RemoteUtils.mzApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login();
        SerialDealList();
        CouponDetail();
        SerialList();
        SerialListbyCouponId();
        SerialDetailbyOutletId();
        SerialListHistorybyCustomerId();
        getCustomerDetail();
        getMerchantSetting();
        getMerchantDownloadSetting();
        getMerchantDetailByMerchantId();
        getOutletByCouponCode();
        getOutletByRedeemPass();

////        //Transation API's
        postIssueCouponRollback();
        postIssueCommitCoupon();
        postIssueCoupon();
        postTransferCoupon();
        postVoidCoupon();
        postExpressRedeem();
        postRedeem();
        postRedeemCommit();
        postRedeemRollback();
        postRedeemVoidCoupon();
        IssueUpdateTransactionId();

////        Customer API's
//
        postForgotCustomerPassword();
         UpdateCustomerPassWord();
//        postCustomerLoginAuth();
        postCustomerRegister();
        CustomerProfileUpdate();
//
//        //Payment API's
        getPaymentlist();
        getActiveTractionByStatus();


    }

    public void UpdateCustomerPassWord(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "en");
        params.put("otp_code","526151");


        CustomerData customerData=new CustomerData();
        customerData.setNew_password("12345678");

        Call<CustomerData> customerDataCall= mzApiClient.getCustomerUpdatePasswordService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDA1OTMyNywiZXhwIjoxNjU0MDg4MTI3fQ.PZuqJodPdWSDLJ_n5SMmCOKTHPGP5amQ0zlLh3iHAk8",customerData).CustomerUpdatePassword("XYY9YG",params);

        customerDataCall.enqueue(new Callback<CustomerData>() {
            @Override
            public void onResponse(Call<CustomerData> call, Response<CustomerData> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CustomerData> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }


    public void CustomerProfileUpdate(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "en");
        params.put("encrypted","y");

        CustomerModel customerModel=new CustomerModel();

        CustomerData customerData=new CustomerData();
        customerData.setCustomer_email("aruna@inforios.com");
        customerData.setCustomer_password("12345678");
        customerData.setCustomer_first_name("Aruna");
        customerData.setCustomer_last_name("R");
        customerData.setCustomer_gender("F");
        customerData.setTemplate_id("MZ_CUSTOMER_UPDATE_PROFILE");
        customerData.setCustomer_code("Mezzofy");
        customerData.setReference_no("12345");


        customerModel.setCustomer(customerData);


        Call<CustomerModel> customerDataCall= mzApiClient.getCustomerUpdateService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDA1OTMyNywiZXhwIjoxNjU0MDg4MTI3fQ.PZuqJodPdWSDLJ_n5SMmCOKTHPGP5amQ0zlLh3iHAk8",customerModel).CustomerProfileUpdate("XYY9YG",params);

        customerDataCall.enqueue(new Callback<CustomerModel>() {
            @Override
            public void onResponse(Call<CustomerModel> call, Response<CustomerModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CustomerModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void postForgotCustomerPassword(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("encrypted", "y");
        params.put("lang", "en");


        Call<CustomerData> customerDataCall= mzApiClient.getCustomerServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDA1OTMyNywiZXhwIjoxNjU0MDg4MTI3fQ.PZuqJodPdWSDLJ_n5SMmCOKTHPGP5amQ0zlLh3iHAk8").postCustomerForgotPassword("shankar.j@mezzofy.com",params);

        customerDataCall.enqueue(new Callback<CustomerData>() {
            @Override
            public void onResponse(Call<CustomerData> call, Response<CustomerData> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CustomerData> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void postCustomerLoginAuth(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "en");

        CustomerModel customerModel=new CustomerModel();

        CustomerData customerData=new CustomerData();
        customerData.setCustomer_email("palani@inforios.com");
        customerData.setCustomer_password("12345678");

        customerModel.setCustomer(customerData);


        Call<CustomerModel> customerDataCall= mzApiClient.getCustomerAuthService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDA1OTMyNywiZXhwIjoxNjU0MDg4MTI3fQ.PZuqJodPdWSDLJ_n5SMmCOKTHPGP5amQ0zlLh3iHAk8",customerModel).postCustomerLoginAuth(params);

        customerDataCall.enqueue(new Callback<CustomerModel>() {
            @Override
            public void onResponse(Call<CustomerModel> call, Response<CustomerModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CustomerModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }


    public void postCustomerRegister(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("delivery_method", "S");

        CustomerRegisterModel customerModel=new CustomerRegisterModel();

        CustomerRegisterData customerData=new CustomerRegisterData();
        customerData.setCustomer_email("aruna6@mezzofy.com");
        customerData.setCustomer_first_name("tester");
        customerData.setCustomer_mobile("+919962542287");
        customerData.setUser_type("C");
        customerData.setCustomer_password("12345678");
        customerData.setCountry_code("IN");


        customerModel.setCustomer(customerData);


        Call<CustomerRegisterModel> customerDataCall= mzApiClient.getCustomerRegisterService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDA1OTMyNywiZXhwIjoxNjU0MDg4MTI3fQ.PZuqJodPdWSDLJ_n5SMmCOKTHPGP5amQ0zlLh3iHAk8",customerModel).postCustomerRegister(params);

        customerDataCall.enqueue(new Callback<CustomerRegisterModel>() {
            @Override
            public void onResponse(Call<CustomerRegisterModel> call, Response<CustomerRegisterModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CustomerRegisterModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void postIssueCouponRollback(){

        Call<IssueCommitResponseData> loginResponseCall= mzApiClient.getCouponIssueRollbackService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzM2NDI4MywiZXhwIjoxNjUzMzkzMDgzfQ.oMS1vKUpE-WV7NTdrm25iASFcJukhnPsgpyMGzCBL_8").postIssueCouponRollback("NKP84OAOXF");

        loginResponseCall.enqueue(new Callback<IssueCommitResponseData>() {
            @Override
            public void onResponse(Call<IssueCommitResponseData> call, Response<IssueCommitResponseData> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<IssueCommitResponseData> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }

    public void postIssueCommitCoupon(){

        IssueCommitData issueCouponModel=new IssueCommitData();
        issueCouponModel.setCoupon_delivery_type("W");
        issueCouponModel.setTemplate_id("MEZZOFY_MRMDR");
        issueCouponModel.setTransaction_amount(10);
        issueCouponModel.setPurchase_receipt("N");
        issueCouponModel.setTransaction_note("Paid");

        Call<IssueCommitResponseData> loginResponseCall= mzApiClient.getCouponIssueCommitService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzM2NDI4MywiZXhwIjoxNjUzMzkzMDgzfQ.oMS1vKUpE-WV7NTdrm25iASFcJukhnPsgpyMGzCBL_8",issueCouponModel).postIssueCouponCommit("4RDC3BZPTZ");

        loginResponseCall.enqueue(new Callback<IssueCommitResponseData>() {
            @Override
            public void onResponse(Call<IssueCommitResponseData> call, Response<IssueCommitResponseData> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<IssueCommitResponseData> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }

    public void IssueUpdateTransactionId(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("status", "R");

        ReferenceUpdateData referenceUpdateData=new ReferenceUpdateData();
        referenceUpdateData.setTransaction_ref_no("test api 01 Feb 2022");


        Call<Void> loginResponseCall= mzApiClient.getTransactionUpdateService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IjJIRkVBUiIsInBhc3N3b3JkIjoiOHFxaCIsImlhdCI6MTY1NTEwMzE2NywiZXhwIjoxNjU1MTMxOTY3fQ._EJurgx7D7M9fsaEwlGBHaQxxFyN2C80oOWEly7iIeg",referenceUpdateData).putTransactionUpdate("914UZ946MB",params);

        loginResponseCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }





    public void postIssueCoupon(){

        IssueCouponModel issueCouponModel=new IssueCouponModel();

        IssueCustomer customer=new IssueCustomer();
        customer.setCustomer_id("TTB60R");
        customer.setEmail("dannylewis.mt@outlook.com");
        customer.setMobile_no("919629033132");
        customer.setName("danny");

        ArrayList<IssueCouponData> issueCouponDataArrayList=new ArrayList<>();
        IssueCouponData issueCouponData=new IssueCouponData();
        issueCouponData.setCoupon_count(1);
        issueCouponData.setCoupon_code("1025480");
        issueCouponDataArrayList.add(issueCouponData);


        issueCouponModel.setCoupons(issueCouponDataArrayList);
        issueCouponModel.setIssue_type("CO");
        issueCouponModel.setCoupon_delivery_type("S");
        issueCouponModel.setDelivery_method("E");
        issueCouponModel.setCustomer(customer);
        issueCouponModel.setLang("en");

        issueCouponModel.setPayment_name("Stripe");
        issueCouponModel.setTransaction_amount(10);
        issueCouponModel.setTransaction_method("I");


        issueCouponModel.setPurchase_receipt("Y");
        issueCouponModel.setTemplate_id("HYATT_MRMDR");
        issueCouponModel.setReceipt_template_id("mezzofy");



        Call<IssueCouponResponseData> loginResponseCall= mzApiClient.getCouponIssueService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzM2NDI4MywiZXhwIjoxNjUzMzkzMDgzfQ.oMS1vKUpE-WV7NTdrm25iASFcJukhnPsgpyMGzCBL_8",issueCouponModel).postIssueCoupon();

        loginResponseCall.enqueue(new Callback<IssueCouponResponseData>() {
            @Override
            public void onResponse(Call<IssueCouponResponseData> call, Response<IssueCouponResponseData> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<IssueCouponResponseData> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }


    public void postTransferCoupon(){
        CouponTransferModel couponTransferModel=new CouponTransferModel();
        ArrayList<String> serivals=new ArrayList<>();
        serivals.add("SCZ0Q099RY");

        TransferTo transferTo=new TransferTo();
        transferTo.setSerials(serivals);
        transferTo.setCustomer_email("aruna@mezzofy.com");


        ArrayList<TransferTo> transferTos=new ArrayList<>();
        transferTos.add(transferTo);


        couponTransferModel.setTransfer_to(transferTos);
        couponTransferModel.setTransfer_template_id("mezzofy_transfer");
        couponTransferModel.setCustomer_id("T9N775");
        couponTransferModel.setSender_message("Hi, Take your Gift Pack");
        couponTransferModel.setLang("en");


        Call<TransferCouponResponseData> loginResponseCall= mzApiClient.getCouponTransactionService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzM2NDI4MywiZXhwIjoxNjUzMzkzMDgzfQ.oMS1vKUpE-WV7NTdrm25iASFcJukhnPsgpyMGzCBL_8",couponTransferModel).postCouponTransfer();

        loginResponseCall.enqueue(new Callback<TransferCouponResponseData>() {
            @Override
            public void onResponse(Call<TransferCouponResponseData> call, Response<TransferCouponResponseData> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<TransferCouponResponseData> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }

    public void postExpressRedeem(){
        ExpressRedeemModel expressRedeemModel=new ExpressRedeemModel();

        TxnRedeem txnRedeem=new TxnRedeem();
        txnRedeem.setLang("en");
        txnRedeem.setTransaction_by("Pin Redemption");
        txnRedeem.setTransaction_note("Test");
        txnRedeem.setOutlet_id("SPUFE");

        TxnSerial txnSerial=new TxnSerial();
        txnSerial.setSerial("4LHUIIVZ8N");
        txnSerial.setRedeem_value(0);

        ArrayList<TxnSerial> txnSerialList=new ArrayList();
        txnSerialList.add(txnSerial);

        expressRedeemModel.setTxn_redeem(txnRedeem);
        expressRedeemModel.setTxn_serials(txnSerialList);

        Call<RedeemResponseModel> loginResponseCall= mzApiClient.getRedeemExpressService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzMwMzQ2NiwiZXhwIjoxNjUzMzMyMjY2fQ.BI0BeJoSw3IbOeLwYP35ixXiAEHU6bT9KxntGX4Rcqs",expressRedeemModel).PostExpressRedeem();

        loginResponseCall.enqueue(new Callback<RedeemResponseModel>() {
            @Override
            public void onResponse(Call<RedeemResponseModel> call, Response<RedeemResponseModel> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<RedeemResponseModel> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }

//    public void postExpressRedeemExpiredCoupon(){
//
//
//        Call<RedeemResponseModel> loginResponseCall= mzApiClient.getRedeemExpressService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzMwMzQ2NiwiZXhwIjoxNjUzMzMyMjY2fQ.BI0BeJoSw3IbOeLwYP35ixXiAEHU6bT9KxntGX4Rcqs",expressRedeemModel).PostExpressRedeem();
//
//        loginResponseCall.enqueue(new Callback<RedeemResponseModel>() {
//            @Override
//            public void onResponse(Call<RedeemResponseModel> call, Response<RedeemResponseModel> response) {
//                Log.d("msg", "onResponse: "+response.toString());
//                if(response.isSuccessful())
//                    Log.d("msg", "onResponse: Success"+response.body().toString());
//                else
//                    Log.d("msg", "onResponse: Success"+response.raw().toString());
//            }
//            @Override
//            public void onFailure(Call<RedeemResponseModel> call, Throwable t) {
//                Log.d("TAG", "onResponse: Fail"+t.toString());
//            }
//        });
//    }


    public void postRedeem(){
        ExpressRedeemModel expressRedeemModel=new ExpressRedeemModel();

        TxnRedeem txnRedeem=new TxnRedeem();
        txnRedeem.setLang("en");
        txnRedeem.setTransaction_by("Pin Redemption");
        txnRedeem.setTransaction_note("Test");
        txnRedeem.setOutlet_id("RH11X");

        TxnSerial txnSerial=new TxnSerial();
        txnSerial.setSerial("5JZIFPLVRJ");
        txnSerial.setRedeem_value(0);

        ArrayList<TxnSerial> txnSerialList=new ArrayList();
        txnSerialList.add(txnSerial);

        expressRedeemModel.setTxn_redeem(txnRedeem);
        expressRedeemModel.setTxn_serials(txnSerialList);

        Call<RedeemResponse> loginResponseCall= mzApiClient.getRedeemService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzYyODIwMCwiZXhwIjoxNjUzNjU3MDAwfQ.6388uP6nuD6ZJ29DjmKD_sHbHws_QcQqTk8NmxBKOhI",expressRedeemModel).PostRedeem();

        loginResponseCall.enqueue(new Callback<RedeemResponse>() {
            @Override
            public void onResponse(Call<RedeemResponse> call, Response<RedeemResponse> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<RedeemResponse> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }

    public void postRedeemCommit(){
        RedeemCommit redeemCommit=new RedeemCommit();

        redeemCommit.setTransaction_note("Redeem commit");

        Call<RedeemResponseModel> loginResponseCall= mzApiClient.getRedeemCommitService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzYyODIwMCwiZXhwIjoxNjUzNjU3MDAwfQ.6388uP6nuD6ZJ29DjmKD_sHbHws_QcQqTk8NmxBKOhI",redeemCommit).PostRedeemCommit("IF6F4JOZSRPUNGM47T5J");

        loginResponseCall.enqueue(new Callback<RedeemResponseModel>() {
            @Override
            public void onResponse(Call<RedeemResponseModel> call, Response<RedeemResponseModel> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<RedeemResponseModel> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }


    public void postRedeemRollback(){
        RedeemCommit redeemCommit=new RedeemCommit();

        redeemCommit.setTransaction_note("rollback serial04012022");
        redeemCommit.setTransaction_ref_no("Rollbacked 04012022");



        Call<RedeemResponse> loginResponseCall= mzApiClient.getRedeemRollBackService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzYyODIwMCwiZXhwIjoxNjUzNjU3MDAwfQ.6388uP6nuD6ZJ29DjmKD_sHbHws_QcQqTk8NmxBKOhI",redeemCommit).PostRedeemRollBack("1J4CBOIBX9XLFN6DPN31");

        loginResponseCall.enqueue(new Callback<RedeemResponse>() {
            @Override
            public void onResponse(Call<RedeemResponse> call, Response<RedeemResponse> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.raw().toString());
            }
            @Override
            public void onFailure(Call<RedeemResponse> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail"+t.toString());
            }
        });
    }

    public void postRedeemVoidCoupon(){
        TransationVoidModel transationVoidModel=new TransationVoidModel();
        ArrayList<String> txnSerialList=new ArrayList<>();
        txnSerialList.add("6XOV29LMQL");

        TxnVoid txnVoid=new TxnVoid();
        txnVoid.setLang("en");
        txnVoid.setDelivery_method("E");
        txnVoid.setRemarks("Mezzofy");
        txnVoid.setReference_id("RH11X");
        txnVoid.setTemplate_id("REFUND_HYATT_COUPON");

        txnVoid.setOutlet_id("RH11X");

        transationVoidModel.setTxn_void(txnVoid);
        transationVoidModel.setTxn_serials(txnSerialList);

        Call<RedeemResponse> loginResponseCall= mzApiClient.getTransactionService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1Mzk3Mzc0OSwiZXhwIjoxNjU0MDAyNTQ5fQ.CynAT_SYUW-H20CRk6qhDlrvcZ4--jRrk00n0bZXVo0",transationVoidModel).PostVoidRedeemCoupon();

        loginResponseCall.enqueue(new Callback<RedeemResponse>() {
            @Override
            public void onResponse(Call<RedeemResponse> call, Response<RedeemResponse> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.errorBody().toString());
            }
            @Override
            public void onFailure(Call<RedeemResponse> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail");
            }
        });
    }



    public void postVoidCoupon(){
        TransationVoidModel transationVoidModel=new TransationVoidModel();
        ArrayList<String> txnSerialList=new ArrayList<>();
        txnSerialList.add("AOPJBI0S0F");

        TxnVoid txnVoid=new TxnVoid();
        txnVoid.setLang("en");
        txnVoid.setDelivery_method("E");
        txnVoid.setRemarks("Mezzofy");
        txnVoid.setReference_id("FGRU0");
        txnVoid.setTemplate_id("REFUND_MZ_COUPON");
        txnVoid.setCustomer_id("41K3XI");
        txnVoid.setOutlet_id("FGRU0");

        transationVoidModel.setTxn_void(txnVoid);
        transationVoidModel.setTxn_serials(txnSerialList);

        Call<VoidIssueReponseData> loginResponseCall= mzApiClient.getTransactionService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1MzMwMzQ2NiwiZXhwIjoxNjUzMzMyMjY2fQ.BI0BeJoSw3IbOeLwYP35ixXiAEHU6bT9KxntGX4Rcqs",transationVoidModel).postIssueCouponVoid();

        loginResponseCall.enqueue(new Callback<VoidIssueReponseData>() {
            @Override
            public void onResponse(Call<VoidIssueReponseData> call, Response<VoidIssueReponseData> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().toString());
                else
                    Log.d("msg", "onResponse: Success"+response.errorBody().toString());
            }
            @Override
            public void onFailure(Call<VoidIssueReponseData> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail");
            }
        });
    }

    public void login(){
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setUserName("HDCK5RHB7FFJWTWW");
        loginRequest.setPassWord("9Q70");

        Call<LoginResponse> loginResponseCall= mzApiClient.getLoginService(loginRequest).userLogin();

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d("msg", "onResponse: "+response.toString());
                if(response.isSuccessful())
                    Log.d("msg", "onResponse: Success"+response.body().getAccessToken().toString());
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("TAG", "onResponse: Fail");
            }
        });
    }



    public void getMerchantDetailByMerchantId(){

        Call<MerchantModel> merchantModelCall= mzApiClient.getMerchantServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDE0MjY2NSwiZXhwIjoxNjU0MTcxNDY1fQ.xhdMY8EtkkGnsByCq7SEUznl2tXxl2NUuqLP7pQp7pI").getMerchantDetailByMerchantId("8QYU");

        merchantModelCall.enqueue(new Callback<MerchantModel>() {
            @Override
            public void onResponse(Call<MerchantModel> call, Response<MerchantModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<MerchantModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void getActiveTractionByStatus(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("status", "I");

        Call<TransactionModel> merchantModelCall= mzApiClient.getTransactionService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDE0MjY2NSwiZXhwIjoxNjU0MTcxNDY1fQ.xhdMY8EtkkGnsByCq7SEUznl2tXxl2NUuqLP7pQp7pI").getActiveTransactionByStatus("I3DTES",params);

        merchantModelCall.enqueue(new Callback<TransactionModel>() {
            @Override
            public void onResponse(Call<TransactionModel> call, Response<TransactionModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<TransactionModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void getPaymentlist(){

        Call<PaymentModel> paymentModelCall= mzApiClient.getPaymentServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NDE0MjY2NSwiZXhwIjoxNjU0MTcxNDY1fQ.xhdMY8EtkkGnsByCq7SEUznl2tXxl2NUuqLP7pQp7pI").getPaymentlist();

        paymentModelCall.enqueue(new Callback<PaymentModel>() {
            @Override
            public void onResponse(Call<PaymentModel> call, Response<PaymentModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<PaymentModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });

    }


    public void SerialDealList(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", "20");
        params.put("skip", "0");


        Call<CouponModel> couponListModelCall= mzApiClient.getCouponServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOHF5dSIsImlhdCI6MTY1MzI4MjY1NiwiZXhwIjoxNjUzMzExNDU2fQ.NeHbntfyGL8qPmnX9Lss4t5NKn-GkjpB1QPk50idQzw").getCouponList(params);

        couponListModelCall.enqueue(new Callback<CouponModel>() {
            @Override
            public void onResponse(Call<CouponModel> call, Response<CouponModel> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CouponModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void CouponDetail(){

        Call<CouponData> couponDataCall= mzApiClient.getCouponServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOHF5dSIsImlhdCI6MTY1MzI4MjY1NiwiZXhwIjoxNjUzMzExNDU2fQ.NeHbntfyGL8qPmnX9Lss4t5NKn-GkjpB1QPk50idQzw").getCouponDetail("WIAWU4");

        couponDataCall.enqueue(new Callback<CouponData>() {
            @Override
            public void onResponse(Call<CouponData> call, Response<CouponData> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<CouponData> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void SerialList(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", "20");
        params.put("skip", "0");
        params.put("status", "R");

        Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("2z5SqHS8raVNlcbDM6cfpR1Gn2E7BVp1L2u3S1QttoSoXlqp1L2u3ScDaZg54jHQRp1L2u3SXZw9vLSLHRC4haZnqFGrIoEf2mM2hBFaMyTPCB7rbdnEgDSBi0qyA0vp1L2u3Sib6M1FR4Gw409gMHzBqhbGiJ3vs1L2a3S4hAuw21ScqcPdHNmvM35MEs1L2a3S4hKPqylnyuLs1L2a3S4hS3BkaTs1L2a3S4hFZky8xIjpkfb0H20yw6p1L2u3SYHz03CmDRp8xxI8s1L2a3S4hMopelIr53D4IkDYr9Stecwurs87L9p1L2u3SBiMp7Sce4oQa4ZZXnDcTVGrQ5Fvs1L2a3S4hLlpxs1L2a3S4h2NOwe1Q2u3A4le1Q2u3A4l").getSerialResponseByCustomerId("CFNE6Q",params);

        serialResponseCall.enqueue(new Callback<SerialResponse>() {
            @Override
            public void onResponse(Call<SerialResponse> call, Response<SerialResponse> response) {
                Log.e("TAG", "onResponse: Success");
            }
            @Override
            public void onFailure(Call<SerialResponse> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void SerialListbyCouponId(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", "20");
        params.put("skip", "0");
        params.put("coupon_id", "\'2JZBEI\'");


        Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkhEQ0s1UkhCN0ZGSldUV1ciLCJwYXNzd29yZCI6IjlRN1UiLCJpYXQiOjE2NTE4MTQ2MTgsImV4cCI6MTY1MTg0MzQxOH0.deoYG-WEkSmEpVDA1KpDXmmPDjcNJcpEBZ7g4k0zZkY").getSerialListByCustomerIdAndCouponId("8PX3GI",params);
        serialResponseCall.enqueue(new Callback<SerialResponse>() {
            @Override
            public void onResponse(Call<SerialResponse> call, Response<SerialResponse> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<SerialResponse> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });


    }


    public void SerialDetailbyOutletId(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("outlet_id", "FGRU0");

        Call<Couponserialresults> serialResponseCall= mzApiClient.getSerialServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOFFZVSIsImlhdCI6MTY1NTExMzIyMCwiZXhwIjoxNjU1MTQyMDIwfQ.bJXwV4ikNN-lU3yus2bzyMU9d_-Qr8xrGGE_y3LkFZ8").getSerialByOutletId("WJ7GFLKWOO",params);
        serialResponseCall.enqueue(new Callback<Couponserialresults>() {
            @Override
            public void onResponse(Call<Couponserialresults> call, Response<Couponserialresults> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<Couponserialresults> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });


    }

    public void SerialListHistorybyCustomerId(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", "20");
        params.put("skip", "0");
        params.put("history", "\'T\'");
        Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOHF5dSIsImlhdCI6MTY1MTgxOTU5MiwiZXhwIjoxNjUxODQ4MzkyfQ.RUkdCHXNG9VEoiV79ED1Kdh9lyeW7eKEEwQ3PLlEpVY").getSerialHistoryListByCustomerId("PNCEUL",params);
        serialResponseCall.enqueue(new Callback<SerialResponse>() {
            @Override
            public void onResponse(Call<SerialResponse> call, Response<SerialResponse> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<SerialResponse> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void getCustomerDetail(){


        Call<CustomerData> customerDataCall= mzApiClient.getCustomerServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkhEQ0s1UkhCN0ZGSldUV1ciLCJwYXNzd29yZCI6IjlRN1UiLCJpYXQiOjE2NTIxNjA2MDQsImV4cCI6MTY1MjE4OTQwNH0.GSfwYKNMRTlg8pyIZSuts8UgmbrlDlC7cYsbo0mzpXE").getCustomerDetailByCustomerId("8PX3GI");
        customerDataCall.enqueue(new Callback<CustomerData>() {
            @Override
            public void onResponse(Call<CustomerData> call, Response<CustomerData> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<CustomerData> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void getMerchantSetting(){


        Call<MerchantSettingModel> merchantSettingModelCall= mzApiClient.getCustomerServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkhEQ0s1UkhCN0ZGSldUV1ciLCJwYXNzd29yZCI6IjlRN1UiLCJpYXQiOjE2NTIxNjA2MDQsImV4cCI6MTY1MjE4OTQwNH0.GSfwYKNMRTlg8pyIZSuts8UgmbrlDlC7cYsbo0mzpXE").getMerchantSetting();
        merchantSettingModelCall.enqueue(new Callback<MerchantSettingModel>() {
            @Override
            public void onResponse(Call<MerchantSettingModel> call, Response<MerchantSettingModel> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<MerchantSettingModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }


    public void getMerchantDownloadSetting(){
        Call<MerchantDownloadSettings> merchantDownloadSettingsCall= mzApiClient.getMerchantServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkhEQ0s1UkhCN0ZGSldUV1ciLCJwYXNzd29yZCI6IjlRN1UiLCJpYXQiOjE2NTIyNDQ2NTQsImV4cCI6MTY1MjI3MzQ1NH0.NipLQvYhKMxD6uZjuGvrWxMuq-9ZXCiYmlJg15AloR0").getMerchantDownloadSetting();
        merchantDownloadSettingsCall.enqueue(new Callback<MerchantDownloadSettings>() {
            @Override
            public void onResponse(Call<MerchantDownloadSettings> call, Response<MerchantDownloadSettings> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<MerchantDownloadSettings> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }

    public void getOutletByCouponCode(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", "20");
        params.put("skip", "0");
        params.put("search_by", "Aravind");
        params.put("coupon_code","\'1004634\'");
        Call<OutletProfileModel> outletProfileModelCall= mzApiClient.getOutletService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkhEQ0s1UkhCN0ZGSldUV1ciLCJwYXNzd29yZCI6IjlRN1UiLCJpYXQiOjE2NTIyNDQ2NTQsImV4cCI6MTY1MjI3MzQ1NH0.NipLQvYhKMxD6uZjuGvrWxMuq-9ZXCiYmlJg15AloR0").getOutletByCouponCode(params);
        outletProfileModelCall.enqueue(new Callback<OutletProfileModel>() {
            @Override
            public void onResponse(Call<OutletProfileModel> call, Response<OutletProfileModel> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<OutletProfileModel> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }



    public void getOutletByRedeemPass(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("outlet_redeem_pass", "2222");

        Call<OutletProfile> outletProfileModelCall= mzApiClient.getOutletService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkhEQ0s1UkhCN0ZGSldUV1ciLCJwYXNzd29yZCI6IjlRN1UiLCJpYXQiOjE2NTIyNDQ2NTQsImV4cCI6MTY1MjI3MzQ1NH0.NipLQvYhKMxD6uZjuGvrWxMuq-9ZXCiYmlJg15AloR0").getOutletByRedeemPass(params);
        outletProfileModelCall.enqueue(new Callback<OutletProfile>() {
            @Override
            public void onResponse(Call<OutletProfile> call, Response<OutletProfile> response) {
                Log.e("TAG", "onResponse: "+response.body().toString());
            }
            @Override
            public void onFailure(Call<OutletProfile> call, Throwable t) {
                Log.e("TAG", "failed: ");
            }
        });
    }



}