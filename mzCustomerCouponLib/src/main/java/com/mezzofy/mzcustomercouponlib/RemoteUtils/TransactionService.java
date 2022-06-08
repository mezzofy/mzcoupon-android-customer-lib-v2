package com.mezzofy.mzcustomercouponlib.RemoteUtils;



import com.mezzofy.mzcustomercouponlib.Data.CustomerData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCommitResponseData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCouponResponseData;
import com.mezzofy.mzcustomercouponlib.Data.RedeemResponse;
import com.mezzofy.mzcustomercouponlib.Data.TransactionModel;
import com.mezzofy.mzcustomercouponlib.Data.TransferCouponResponseData;
import com.mezzofy.mzcustomercouponlib.Data.VoidIssueReponseData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface TransactionService {

    @POST("v2/void/issue")
    Call<VoidIssueReponseData> postIssueCouponVoid();


    @POST("v2/transfer")
    Call<TransferCouponResponseData> postCouponTransfer();

    @POST("v2/issue")
    Call<IssueCouponResponseData> postIssueCoupon();


    @POST("v2/issue/{TransactionId}/commit")
    Call<IssueCommitResponseData> postIssueCouponCommit(@Path("TransactionId") String TransactionId);

    @POST("v2/issue/{TransactionId}/rollback")
    Call<IssueCommitResponseData> postIssueCouponRollback(@Path("TransactionId") String TransactionId);

    @POST("v2/void/redeem")
    Call<RedeemResponse> PostVoidRedeemCoupon();

    @GET("v2/transactions/{CustomerId}?")
    Call<TransactionModel> getActiveTransactionByStatus(@Path("CustomerId") String CustomerId,@QueryMap Map<String, String> PathParams);




}
