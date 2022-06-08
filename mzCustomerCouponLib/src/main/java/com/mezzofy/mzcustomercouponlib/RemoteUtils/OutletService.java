package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.OutletProfile;
import com.mezzofy.mzcustomercouponlib.Data.OutletProfileModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface OutletService {
    @GET("v2?")
    Call<OutletProfileModel> getOutletByCouponCode(@QueryMap Map<String, String> PathParams);

    @GET("v2?")
    Call<OutletProfile> getOutletByRedeemPass(@QueryMap Map<String, String> PathParams);

}
