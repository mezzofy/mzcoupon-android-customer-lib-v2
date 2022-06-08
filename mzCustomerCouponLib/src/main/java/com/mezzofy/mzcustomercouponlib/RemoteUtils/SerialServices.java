package com.mezzofy.mzcustomercouponlib.RemoteUtils;


import com.mezzofy.mzcustomercouponlib.Data.SerialResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface SerialServices {

    @GET("v2/customer/{CustomerId}?include_merchant=S")
    Call<SerialResponse> getSerialResponseByCustomerId(@Path("CustomerId") String CustomerId, @QueryMap Map<String, String> PathParams);


    @GET("v2/customer/{CustomerId}/")
    Call<SerialResponse> getSerialListByCustomerIdAndCouponId(@Path("CustomerId") String CustomerId, @QueryMap Map<String, String> PathParams);


    @GET("v2/customer/{CustomerId}/")
    Call<SerialResponse> getSerialHistoryListByCustomerId(@Path("CustomerId") String CustomerId, @QueryMap Map<String, String> PathParams);

  }
