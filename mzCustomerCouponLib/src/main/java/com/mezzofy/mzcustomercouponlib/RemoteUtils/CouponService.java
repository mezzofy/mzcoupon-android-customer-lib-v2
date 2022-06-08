package com.mezzofy.mzcustomercouponlib.RemoteUtils;


import com.mezzofy.mzcustomercouponlib.Data.CouponData;
import com.mezzofy.mzcustomercouponlib.Data.CouponModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CouponService {
    @GET("v2?publish=A&include_merchant=S")
    Call<CouponModel> getCouponList(@QueryMap Map<String, String> PathParams);

    @GET("v2/{CouponId}?include_merchant=S")
    Call<CouponData> getCouponDetail(@Path("CouponId") String CouponId);

}
