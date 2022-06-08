package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.LoginRequest;
import com.mezzofy.mzcustomercouponlib.Data.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("v2/token")
    Call<LoginResponse> userLogin();
}
