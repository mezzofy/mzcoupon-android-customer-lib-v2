package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.MerchantDownloadSettings;
import com.mezzofy.mzcustomercouponlib.Data.MerchantModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MerchantService {
    @GET("v2/merchantdownloadsettings/downloadsetting")
    Call<MerchantDownloadSettings> getMerchantDownloadSetting();

    @GET("v2/{MerchantId}")
    Call<MerchantModel> getMerchantDetailByMerchantId(@Path("MerchantId") String MerchantId);
}
