package com.mezzofy.mzcustomercoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.mezzofy.mzcustomercouponlib.Data.CustomerData;
import com.mezzofy.mzcustomercouponlib.Data.LoginRequest;
import com.mezzofy.mzcustomercouponlib.Data.LoginResponse;
import com.mezzofy.mzcustomercouponlib.Data.MerchantDownloadSettings;
import com.mezzofy.mzcustomercouponlib.Data.MerchantSettingModel;
import com.mezzofy.mzcustomercouponlib.Data.OutletProfile;
import com.mezzofy.mzcustomercouponlib.Data.OutletProfileModel;
import com.mezzofy.mzcustomercouponlib.Data.SerialResponse;
import com.mezzofy.mzcustomercouponlib.RemoteUtils.mzApiClient;

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
//        login();
//        SerialList();
//        SerialListbyCouponId();
//        SerialListHistorybyCustomerId();
//        getCustomerDetail();
//        getMerchantSetting();
//        getMerchantDownloadSetting();
//        getOutletByCouponCode();
        getOutletByRedeemPass();
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

    public void SerialList(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", "20");
        params.put("skip", "0");
        params.put("status", "R");

        Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOHF5dSIsImlhdCI6MTY1MTg0MDI0MywiZXhwIjoxNjUxODY5MDQzfQ.HYVkQ4hqLpAmlOW_DgAMYwnSCBiGcb8eHYeEyZj2HYU").getSerialResponseByCustomerId("PNCEUL",params);

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