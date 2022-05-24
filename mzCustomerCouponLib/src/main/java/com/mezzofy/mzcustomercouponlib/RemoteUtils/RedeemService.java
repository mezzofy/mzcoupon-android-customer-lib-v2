package com.mezzofy.mzcustomercouponlib.RemoteUtils;



import com.mezzofy.mzcustomercouponlib.Data.RedeemResponseModel;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RedeemService {
    @POST("v2")
    Call<RedeemResponseModel> PostExpressRedeem();
}
