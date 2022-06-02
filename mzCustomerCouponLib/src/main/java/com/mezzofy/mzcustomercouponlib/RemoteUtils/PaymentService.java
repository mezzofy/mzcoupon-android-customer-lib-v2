package com.mezzofy.mzcustomercouponlib.RemoteUtils;


import com.mezzofy.mzcustomercouponlib.Data.PaymentModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PaymentService {
    @GET("v2/paymentlist?payment_status='A'")
    Call<PaymentModel> getPaymentlist();
}
