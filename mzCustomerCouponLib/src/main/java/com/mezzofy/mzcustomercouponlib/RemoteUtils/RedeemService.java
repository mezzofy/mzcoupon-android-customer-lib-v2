package com.mezzofy.mzcustomercouponlib.RemoteUtils;



import com.mezzofy.mzcustomercouponlib.Data.RedeemResponse;
import com.mezzofy.mzcustomercouponlib.Data.RedeemResponseModel;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RedeemService {
    @POST("v2")
    Call<RedeemResponseModel> PostExpressRedeem();
    @POST("v2/redeem")
    Call<RedeemResponse> PostRedeem();

    @POST("v2/redeem/{TransactionId}/commit")
    Call<RedeemResponseModel> PostRedeemCommit(@Path("TransactionId") String TransactionId);

    @POST("v2/redeem/{TransactionId}/rollback")
    Call<RedeemResponse> PostRedeemRollBack(@Path("TransactionId") String TransactionId);




}
