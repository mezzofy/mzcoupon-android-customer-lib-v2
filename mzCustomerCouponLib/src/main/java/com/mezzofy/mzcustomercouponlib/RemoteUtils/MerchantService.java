package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.MerchantDownloadSettings;


import retrofit2.Call;
import retrofit2.http.GET;

public interface MerchantService {
    @GET("v2/merchantdownloadsettings/downloadsetting")
    Call<MerchantDownloadSettings> getMerchantDownloadSetting();
}
