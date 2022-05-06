package com.mezzofy.mzcustomercoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.mezzofy.mzcustomercouponlib.Data.LoginRequest;
import com.mezzofy.mzcustomercouponlib.Data.LoginResponse;
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
        SerialListbyCouponId();
        SerialListHistorybyCustomerId();
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

        Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ik9MVE1GMyIsInBhc3N3b3JkIjoiOHF5dSIsImlhdCI6MTY1MTgyNzIzOSwiZXhwIjoxNjUxODU2MDM5fQ.DO1FofsDm8iAZKxj1GMZ33qCJC9cK5CqrMufM-n2KSE").getSerialResponseByCustomerId("PNCEUL",params);
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
}