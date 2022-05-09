# MZCustomerCoupon Android SDK

  

  

![](http://www.mezzofy.com/images/logoz.png)

  

This is a repository of our open source Android SDK, and the information presented here serves as a reference manual for our Android SDK. See the [Getting started](https://developer.android.com/guide/slices/getting-started) section for more details.

  

  

#### Installation Guide for MZCoupon

  

In your `build.gradle`: app

```groovy

allprojects {

repositories {

maven { url 'https://www.jitpack.io' }

}

}

```

```groovy

dependencies {

'com.github.mezzofy:mzcoupon-android-customer-lib-v2:1.0.2'

}

```

## Initialize MZCustomerCoupon

  

### Configure your AndroidManifest.xml

  

Note: Provide internet permission. MZCustomerCoupon SDK need internet access to talk to Mezzofy APIs.

  

#### Add your MZCoupon key to your project.

  

Edit your manifest file to have the above items

```xml

<manifest xmlns:android="http://schemas.android.com/apk/res/android"

android:versionCode="1"

android:versionName="1.0" >

  

<uses-permission android:name="android.permission.INTERNET" />

  

</manifest>

```

***Hints:***



##### How to get Company Code & AccessToken

Login to Merchant Account

  

![](https://mzcoupon.s3.ap-southeast-1.amazonaws.com/logo/apikeyscreen.png)

  

  

### Implementation Guide

  

**Call Function For Authentication Bearer Token**

```java

LoginRequest loginRequest=new LoginRequest();  
loginRequest.setUserName("A3GUJSOHTY164RIQ");
loginRequest.setPassWord("EXNN");  
  
Call<LoginResponse> loginResponseCall= mzApiClient.getLoginService(loginRequest).userLogin();  
loginResponseCall.enqueue(new Callback<LoginResponse>() {  
    @Override  
  public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {  
        Log.d("msg", "onResponse: "+response.toString());  
 if(response.isSuccessful())  
            Log.d("msg", "onResponse: Success"+response.body().getAccessToken().toString());  
  }  
    @Override  
  public void onFailure(Call<LoginResponse> call, Throwable t) {  
        Log.d("TAG", "onResponse: Fail");  
  }  
});



```

**Return**

accessToken;  
accessTokenExpiresAt;  
customerCouponAccessToken;  
customerCouponAccessTokenExpiresAt;

  

**Call Function For Serial Detail By Customer**

  

``` java

Map<String, String> params = new HashMap<String, String>();  
params.put("limit", "20");  
params.put("skip", "0");  
params.put("status", "R");  
  
Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("Your AccessToken").getSerialResponseByCustomerId("CustomerId",params);

```

**Return**

 Summary summary;  
List<CouponSerialResults> results;




**Call Function For Serial Detail By Customer and Coupon**

  

``` java

Map<String, String> params = new HashMap<String, String>();  
params.put("limit", "20");  
params.put("skip", "0");  
params.put("coupon_id", "\'CouponId\'");  
  
  
Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("Your Access Token").getSerialListByCustomerIdAndCouponId("CustomerId",params);

```

**Return**

 Summary summary;  
List<CouponSerialResults> results;




**Call Function For Serial Detail By Status**

  

``` java

Map<String, String> params = new HashMap<String, String>();  
params.put("limit", "20");  
params.put("skip", "0");  
params.put("history", "\'T\'");  
Call<SerialResponse> serialResponseCall= mzApiClient.getSerialServices("Your Access Token").getSerialHistoryListByCustomerId("CustomerId",params);

```

**Return**

 Summary summary;  
List<CouponSerialResults> results;




  

##### Click here for [Full Implementation Guide](https://github.com/mezzofy/mzcoupon-android-customer-lib)

  

# Licenses

  

All source code is licensed under the [MIT License.](https://raw.githubusercontent.com/mezzofy/mzcoupon-android-customer-lib/9f6d85cdaa1a03f323a81d6adf45df36cebb4c75/LICENSE)

  

  

### End