package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.mezzofy.mzcustomercouponlib.Data.LoginRequest;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mzApiClient {
    private static Retrofit getBasicRetrofit(LoginRequest loginRequest){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(loginRequest.getUserName(), loginRequest.getPassWord()))
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://auth.mzapiea.mezzofy.com/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    private static Retrofit getBearerRetrofit(String token){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://serial.mzapiea.mezzofy.com/")
                .client(client)
                .build();

        return retrofit;
    }


    public static class BasicAuthInterceptor implements Interceptor {

        private String credentials;
        private RequestBody body;


        public BasicAuthInterceptor(String user, String password) {
            this.credentials = Credentials.basic(user, password);
            this.body=RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "grant_type=client_credentials");

        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type","application/json")
                    .post(body).build();

            return chain.proceed(authenticatedRequest);
        }

    }

    public static LoginService getLoginService(LoginRequest loginRequest){
        LoginService loginService=getBasicRetrofit(loginRequest).create(LoginService.class);
        return loginService;
    }

    public static SerialServices getSerialServices(String token){
        SerialServices serialServices=getBearerRetrofit(token).create(SerialServices.class);
        return serialServices;
    }

}
