package com.mezzofy.mzcustomercouponlib.RemoteUtils;

import com.google.gson.Gson;
import com.mezzofy.mzcustomercouponlib.Data.CouponTransferModel;
import com.mezzofy.mzcustomercouponlib.Data.CustomerData;
import com.mezzofy.mzcustomercouponlib.Data.CustomerModel;
import com.mezzofy.mzcustomercouponlib.Data.CustomerRegisterModel;
import com.mezzofy.mzcustomercouponlib.Data.ExpressRedeemModel;
import com.mezzofy.mzcustomercouponlib.Data.IssueCommitData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCommitResponseData;
import com.mezzofy.mzcustomercouponlib.Data.IssueCouponModel;
import com.mezzofy.mzcustomercouponlib.Data.LoginRequest;
import com.mezzofy.mzcustomercouponlib.Data.RedeemCommit;
import com.mezzofy.mzcustomercouponlib.Data.Transactions;
import com.mezzofy.mzcustomercouponlib.Data.TransationVoidModel;

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
                .baseUrl("https://auth.mzapiqc.mezzofy.com/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }



    private static Retrofit getBearerRetrofit(String token,String url){
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
                .baseUrl(url)
                .client(client)
                .build();

        return retrofit;
    }





    private static Retrofit PostDataAuthBearer(String token,String url,String jsonString){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonString.trim());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .post(body).build();

                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .client(client)
                .build();

        return retrofit;
    }


    private static Retrofit PutDataAuthBearer(String token,String url,String jsonString){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonString.trim());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .put(body).build();

                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
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
        SerialServices serialServices=getBearerRetrofit(token,"https://serial.mzapi.mezzofy.com/").create(SerialServices.class);
        return serialServices;
    }

    public static CouponService getCouponServices(String token){
        CouponService couponServices=getBearerRetrofit(token,"https://coupon.mzapi.mezzofy.com/").create(CouponService.class);
        return couponServices;
    }

    public static PaymentService getPaymentServices(String token){
        PaymentService paymentService=getBearerRetrofit(token,"https://payment.mzapi.mezzofy.com/").create(PaymentService.class);
        return paymentService;
    }

    public static CustomerService getCustomerServices(String token){
        CustomerService customerService=getBearerRetrofit(token,"https://customer.mzapi.mezzofy.com/").create(CustomerService.class);
        return customerService;
    }

    public static CustomerService getCustomerAuthService(String token, CustomerModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        CustomerService customerService=PostDataAuthBearer(token,"https://customer.mzapi.mezzofy.com/",postString).create(CustomerService.class);
        return customerService;
    }

    public static CustomerService getCustomerUpdateService(String token, CustomerModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        CustomerService customerService=PutDataAuthBearer(token,"https://customer.mzapi.mezzofy.com/",postString).create(CustomerService.class);
        return customerService;
    }

    public static CustomerService getCustomerUpdatePasswordService(String token, CustomerData redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        CustomerService customerService=PutDataAuthBearer(token,"https://customer.mzapi.mezzofy.com/",postString).create(CustomerService.class);
        return customerService;
    }

    public static CustomerService getCustomerRegisterService(String token, CustomerRegisterModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        CustomerService customerService=PostDataAuthBearer(token,"https://customer.mzapi.mezzofy.com/",postString).create(CustomerService.class);
        return customerService;
    }

    public static RedeemService getRedeemExpressService(String token, ExpressRedeemModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        RedeemService redeemService=PostDataAuthBearer(token,"https://exredeem.mzapi.mezzofy.com/",postString).create(RedeemService.class);
        return redeemService;
    }

    public static TransactionService getTransactionService(String token, TransationVoidModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        TransactionService transactionService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(TransactionService.class);
        return transactionService;
    }

    public static TransactionService getTransactionService(String token){
        TransactionService transactionService=getBearerRetrofit(token,"https://activities.mzapi.mezzofy.com/").create(TransactionService.class);
        return transactionService;
    }


    public static TransactionService getCouponTransactionService(String token, CouponTransferModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        TransactionService transactionService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(TransactionService.class);
        return transactionService;
    }

    public static TransactionService getCouponIssueService(String token, IssueCouponModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        TransactionService transactionService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(TransactionService.class);
        return transactionService;
    }


    public static TransactionService getCouponIssueCommitService(String token, IssueCommitData redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        TransactionService transactionService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(TransactionService.class);
        return transactionService;
    }

    public static TransactionService getCouponIssueRollbackService(String token){
        TransactionService transactionService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/","").create(TransactionService.class);
        return transactionService;
    }

    public static MerchantService getMerchantServices(String token){
        MerchantService merchantService=getBearerRetrofit(token,"https://merchant.mzapi.mezzofy.com/").create(MerchantService.class);
        return merchantService;
    }

    public static OutletService getOutletService(String token){
        OutletService outletService=getBearerRetrofit(token,"https://outlet.mzapi.mezzofy.com/").create(OutletService.class);
        return outletService;
    }

    public static RedeemService getRedeemService(String token,  ExpressRedeemModel redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        RedeemService redeemService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(RedeemService.class);
        return redeemService;
    }

    public static RedeemService getRedeemCommitService(String token,  RedeemCommit redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        RedeemService redeemService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(RedeemService.class);
        return redeemService;
    }

    public static RedeemService getRedeemRollBackService(String token,  RedeemCommit redeemobject){
        Gson gson = new Gson();
        String postString=gson.toJson(redeemobject).toString();
        RedeemService redeemService=PostDataAuthBearer(token,"https://transaction.mzapi.mezzofy.com/",postString).create(RedeemService.class);
        return redeemService;
    }

}
