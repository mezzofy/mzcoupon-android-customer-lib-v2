package com.mezzofy.mzcustomercouponlib.RemoteUtils;



import com.mezzofy.mzcustomercouponlib.Data.IssueCommitResponseData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCouponResponseData;
import com.mezzofy.mzcustomercouponlib.Data.TransferCouponResponseData;
import com.mezzofy.mzcustomercouponlib.Data.VoidIssueReponseData;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TransactionService {

    @POST("v2/void/issue")
    Call<VoidIssueReponseData> postCouponVoid();


    @POST("v2/transfer")
    Call<TransferCouponResponseData> postCouponTransfer();

    @POST("v2/issue")
    Call<IssueCouponResponseData> postIssueCoupon();


    @POST("v2/issue/{TransactionId}/commit")
    Call<IssueCommitResponseData> postIssueCouponCommit(@Path("TransactionId") String TransactionId);

    @POST("v2/issue/{TransactionId}/rollback")
    Call<IssueCommitResponseData> postIssueCouponRollback(@Path("TransactionId") String TransactionId);


}
