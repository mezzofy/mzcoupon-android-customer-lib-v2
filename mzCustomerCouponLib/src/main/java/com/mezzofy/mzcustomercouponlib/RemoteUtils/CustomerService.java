package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.CustomerData;
import com.mezzofy.mzcustomercouponlib.Data.CustomerModel;
import com.mezzofy.mzcustomercouponlib.Data.CustomerRegisterModel;
import com.mezzofy.mzcustomercouponlib.Data.MerchantSettingModel;
import com.mezzofy.mzcustomercouponlib.Data.TransferCouponResponseData;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface CustomerService {

    @GET("v2/{CustomerId}")
    Call<CustomerData> getCustomerDetailByCustomerId(@Path("CustomerId") String CustomerId);

    @GET("v2/merchant/setting")
    Call<MerchantSettingModel> getMerchantSetting();

    @POST("v2/forgotpassword/{CustomerEmail}?")
    Call<CustomerData> postCustomerForgotPassword(@Path("CustomerEmail") String CustomerEmail,@QueryMap Map<String, String> PathParams);

    @POST("v2/loginauth?")
    Call<CustomerModel> postCustomerLoginAuth(@QueryMap Map<String, String> PathParams);

    @POST("v2/signup?")
    Call<CustomerRegisterModel> postCustomerRegister(@QueryMap Map<String, String> PathParams);

    @PUT("v2/profileupdate/{CustomerId}?")
    Call<CustomerModel> CustomerProfileUpdate(@Path("CustomerId") String CustomerId,@QueryMap Map<String, String> PathParams);


    @PUT("v2/changepassword/{CustomerId}?")
    Call<CustomerData> CustomerUpdatePassword(@Path("CustomerId") String CustomerId,@QueryMap Map<String, String> PathParams);

}
