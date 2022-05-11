package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.CustomerData;
import com.mezzofy.mzcustomercouponlib.Data.MerchantSettingModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CustomerService {

    @GET("v2/{CustomerId}")
    Call<CustomerData> getCustomerDetailByCustomerId(@Path("CustomerId") String CustomerId);

    @GET("v2/merchant/setting")
    Call<MerchantSettingModel> getMerchantSetting();


}
