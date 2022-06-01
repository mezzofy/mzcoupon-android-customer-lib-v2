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



##### How to get Merchant Code & AccessToken

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


**Call Function For CUSTOMER -Register **

```java

Map<String, String> params = new HashMap<String, String>();  
params.put("delivery_method", "S");  
  
CustomerRegisterModel customerModel=new CustomerRegisterModel();  
  
CustomerRegisterData customerData=new CustomerRegisterData();  
customerData.setCustomer_email("test@test.com");  
customerData.setCustomer_first_name("tester");  
customerData.setCustomer_mobile("+91100000000");  
customerData.setUser_type("C");  
customerData.setCustomer_password("12345678");  
customerData.setCountry_code("IN");  
  
customerModel.setCustomer(customerData);  
  
Call<CustomerRegisterModel> customerDataCall= mzApiClient.getCustomerRegisterService(" Your AccessToken ",customerModel).postCustomerRegister(params);

```
**Return**
country_code;  
customer_id;  
customer_first_name;  
customer_last_name;  
customer_username;  
customer_password;  
customer_email;  
customer_mobile;  
customer_gender;  
customer_address;  
user_type;  
customer_status;


**Call Function For CUSTOMER -Login **

```java

Map<String, String> params = new HashMap<String, String>();  
params.put("lang", "en");  
  
CustomerModel customerModel=new CustomerModel();  
  
CustomerData customerData=new CustomerData();  
customerData.setCustomer_email("test@test.com");  
customerData.setCustomer_password("12345678");  
  
customerModel.setCustomer(customerData);  
  
  
Call<CustomerModel> customerDataCall= mzApiClient.getCustomerAuthService(" Your AccessToken ",customerModel).postCustomerLoginAuth(params);

```
**Return**
country_code;  
customer_id;  
customer_first_name;  
customer_last_name;  
customer_username;  
customer_password;  
customer_email;  
customer_mobile;  
customer_gender;  
customer_address;  
user_type;  
customer_status;


**Call Function For CUSTOMER -Forgot Password **

```java

Map<String, String> params = new HashMap<String, String>();  
params.put("encrypted", "y");  
params.put("lang", "en");  
  
Call<CustomerData> customerDataCall= mzApiClient.getCustomerServices(" Your Access Token ").postCustomerForgotPassword("test@test.com",params);

```
**Return**
country_code;  
customer_id;  
customer_first_name;  
customer_last_name;  
customer_username;  
customer_password;  
customer_email;  
customer_mobile;  
customer_gender;  
customer_address;  
user_type;  
customer_status;
otp_code;

**Call Function For CUSTOMER -Change  Password **

```java

Map<String, String> params = new HashMap<String, String>();  
params.put("lang", "en");  
params.put("otp_code","526151");  
  
CustomerData customerData=new CustomerData();  
customerData.setNew_password("12345678");  
  
Call<CustomerData> customerDataCall= mzApiClient.getCustomerUpdatePasswordService("Your Access Token",customerData).CustomerUpdatePassword("CustomerId",params);

```
**otp_code ---** you get forgot password response

**Return**
country_code;  
customer_id;  
customer_first_name;  
customer_last_name;  
customer_username;  
customer_password;  
customer_email;  
customer_mobile;  
customer_gender;  
customer_address;  
user_type;  
customer_status;


**Call Function For CUSTOMER -Update Customer Profile   **

```java

Map<String, String> params = new HashMap<String, String>();  
params.put("lang", "en");  
params.put("encrypted","y");  
  
CustomerModel customerModel=new CustomerModel();  
  
CustomerData customerData=new CustomerData();  
customerData.setCustomer_email("test@test.com");  
customerData.setCustomer_password("12345678");  
customerData.setCustomer_first_name("test");  
customerData.setCustomer_last_name("R");  
customerData.setCustomer_gender("F");  
customerData.setTemplate_id("MZ_CUSTOMER_UPDATE_PROFILE");  
customerData.setCustomer_code("Mezzofy");  
customerData.setReference_no("12345");  
  
customerModel.setCustomer(customerData);  
  
Call<CustomerModel> customerDataCall= mzApiClient.getCustomerUpdateService("Your Access Token",customerModel).CustomerProfileUpdate("CustomerId",params);

```

**Return**
country_code;  
customer_id;  
customer_first_name;  
customer_last_name;  
customer_username;  
customer_password;  
customer_email;  
customer_mobile;  
customer_gender;  
customer_address;  
user_type;  
customer_status;



**Call Function For CUSTOMER-- Get Customer Detail**
``` java
Call<CustomerData> customerDataCall= mzApiClient.getCustomerServices("Your Access Token").getCustomerDetailByCustomerId("CustomerId");  
```

**Return**
country_code;  
customer_id;  
customer_first_name;  
customer_last_name;  
customer_username;  
customer_password;  
customer_email;  
customer_mobile;  
customer_gender;  
customer_address;  
user_type;  
customer_status;


**Call Function For Get Merchant Setting**
``` java
Call<MerchantSettingModel> merchantSettingModelCall= mzApiClient.getCustomerServices("Your Access Token").getMerchantSetting();
```

**Return**
cus_setting_id;  
 block_list_email;  
created_on;  
merchant_id;  
updated_on;  
banner_url;  
wallet_banner_url;  
secure_status;

**Call Function For Get Merchant Download Setting**
``` java

Call<MerchantDownloadSettings> merchantDownloadSettingsCall= mzApiClient.getMerchantServices("Your Access Token").getMerchantDownloadSetting();

```

**Return**
merchant_id;  
coupon_number_encoding;  
gs1_gln;  
sms_charge_flag;  
option_id;  
option_name;  
policy_url;  
analytic_id;  
analytic_name;  
header_script;  
body_script_start;  
body_script_end;  
wallet_status;  
serial_status;  
single_bundle_status;  
booklet_status;  
event_status;  
shop_status;  
daily_issue_limit_flag;  
reference_flag;  
supervisor_flag;  
supervisor_pin_code;  
low_inventory_email;  
refund_email;  
b2b_marketplace;  
updated_by;  
email_footer;  
selected_language;  
localization;  
default_lang;

**Call Function For Active Coupon List**
![](https://mzcoupon.s3.ap-southeast-1.amazonaws.com/logo/8F0A4D7B-9E6A-478E-827E-F94BD7ABF835.jpg)
 

``` java
Map<String, String> params = new HashMap<String, String>();  
params.put("limit", "20");  
params.put("skip", "0");  
  
  
Call<CouponModel> couponListModelCall= mzApiClient.getCouponServices(" Your AccessToken ").getCouponList(params);

```
limit -> returns a reduced stream of first N elements
skip -> returns a stream of remaining elements after skipping first N elements

**Return**
Summary summary;  
ArrayList<**CouponData**> results;
**CouponData**
Coupon;  
CouponCounts ;  
CouponMetadata;  
CouponTimings;  
CouponLinks;  
Localization;  
ArrayList<CouponImage>;  
ArrayList<CouponOutlet>;

**Call Function For Coupon Detail By CouponId**

![](https://mzcoupon.s3.ap-southeast-1.amazonaws.com/logo/finalimage.png)
``` java
Call<CouponData> couponDataCall= mzApiClient.getCouponServices(" Your AccessToken ").getCouponDetail("CouponId");
```
**Return**
**CouponData**
Coupon;  
CouponCounts ;  
CouponMetadata;  
CouponTimings;  
CouponLinks;  
Localization;  
ArrayList<CouponImage>;  
ArrayList<CouponOutlet>;

**Call Function For ISSUE COUPON --- Void Coupon Issue**
``` java
TransationVoidModel transationVoidModel=new TransationVoidModel();  
ArrayList<String> txnSerialList=new ArrayList<>();  
txnSerialList.add("AOPJBI0S0F");  
  
TxnVoid txnVoid=new TxnVoid();  
txnVoid.setLang("en");  
txnVoid.setDelivery_method("E");  
txnVoid.setRemarks("Mezzofy");  
txnVoid.setReference_id("FGRU0");  
txnVoid.setTemplate_id("REFUND_MZ_COUPON");  
txnVoid.setCustomer_id("41K3XI");  
txnVoid.setOutlet_id("FGRU0");  
  
transationVoidModel.setTxn_void(txnVoid);  
transationVoidModel.setTxn_serials(txnSerialList);  
  
Call<VoidIssueReponseData> loginResponseCall= mzApiClient.getTransactionService("Your AccessToken",transationVoidModel).postCouponVoid();
```
Delivery Method
Parameter values
E -> via Email
S -> via SMS
I -> via Customer ID

Coupon Delivery Type**
Parameter values
S -> Single Email
W -> Wallet
N -> None
** This parameter value is used for Database storing purpose. Parameter value in the COMMIT API will be considered

lang
Supported language and code mentioned below

 "en" > English
 "zh-Hant" > Chinese Traditional
 "zh-Hans" > Chinese Simplified
 "kr" > Korean
 "jp" > Japanese
 "th" > Thai
 "id" > Indonesia Bahasa 

payment name
This parameter value is used for Database storing purpose. Parameter value in the COMMIT API will be considered (e.g Stripe)

Purchase receipt
Parameter values
Y -> Yes then billing template will be used (Client Specific)
N -> No

receipt_template_id
- Used to generate receipt template** (e.g mezzofy - Mezzofy template) 
- purchase_receipt should be "Y"

**Return**
transaction_id;  
merchant_id;  
user_type;  
lang;  
transaction_type;  
transaction_status;  
created_on;  
updated_on;  
reference_id;


**Call Function For ISSUE COUPON ---  Coupon Issue**
``` java
IssueCouponModel issueCouponModel=new IssueCouponModel();  
  
IssueCustomer customer=new IssueCustomer();  
customer.setCustomer_id("TTB60R");  
customer.setEmail("dannylewis.mt@outlook.com");  
customer.setMobile_no("919629033132");  
customer.setName("danny");  
  
ArrayList<IssueCouponData> issueCouponDataArrayList=new ArrayList<>();  
IssueCouponData issueCouponData=new IssueCouponData();  
issueCouponData.setCoupon_count(1);  
issueCouponData.setCoupon_code("1025480");  
issueCouponDataArrayList.add(issueCouponData);  

issueCouponModel.setCoupons(issueCouponDataArrayList);  
issueCouponModel.setIssue_type("CO");  
issueCouponModel.setCoupon_delivery_type("S");  
issueCouponModel.setDelivery_method("E");  
issueCouponModel.setCustomer(customer);  
issueCouponModel.setLang("en");  
  
issueCouponModel.setPayment_name("Stripe");  
issueCouponModel.setTransaction_amount(10);  
issueCouponModel.setTransaction_method("I");  
  
issueCouponModel.setPurchase_receipt("Y");  
issueCouponModel.setTemplate_id("HYATT_MRMDR");  
issueCouponModel.setReceipt_template_id("mezzofy");  
  
Call<IssueCouponResponseData> loginResponseCall= mzApiClient.getCouponIssueService("Your AccessToken",issueCouponModel).postIssueCoupon();
```

**Return**
transaction_id;  
updated_on;  
po_status;  
po_date;  
pay_response;  
merchant_id;  
pay_receipt;  
coupon_via;  
po_total;  
hash_code;  
created_on;  
reward_point;  
payment_name;  
customer_id;  
po_no;



**Call Function For ISSUE COUPON ---  Issue Coupon Commit**
![](https://mzcoupon.s3.ap-southeast-1.amazonaws.com/logo/5D0BC9FF-2E0F-4D8B-A782-CCF815FE66B8.jpg)
``` java
IssueCommitData issueCouponModel=new IssueCommitData();  
issueCouponModel.setCoupon_delivery_type("W");  
issueCouponModel.setTemplate_id("MEZZOFY_MRMDR");  
issueCouponModel.setTransaction_amount(10);  
issueCouponModel.setPurchase_receipt("N");  
issueCouponModel.setTransaction_note("Paid");  
  
Call<IssueCommitResponseData> loginResponseCall= mzApiClient.getCouponIssueCommitService("Your AccessToken",issueCouponModel).postIssueCouponCommit("TransactionId");
```

**Return**
coupon_via;  
created_on;  
customer_id;  
hash_code;  
merchant_id;  
pay_receipt;  
pay_response;  
payment_name;  
po_date;  
transaction_id;  
po_no;  
po_status;  
reward_point;  
updated_on;  
po_total;  
ArrayList<**CustomerCouponData**>;



**Call Function For ISSUE COUPON ---  Issue Coupon Transfer**
``` java
CouponTransferModel couponTransferModel=new CouponTransferModel();  
ArrayList<String> serivals=new ArrayList<>();  
serivals.add("SCZ0Q099RY");  

TransferTo transferTo=new TransferTo();  
transferTo.setSerials(serivals);  
transferTo.setCustomer_email("test@test.com"); 
  
ArrayList<TransferTo> transferTos=new ArrayList<>();  
transferTos.add(transferTo);  

couponTransferModel.setTransfer_to(transferTos);  
couponTransferModel.setTransfer_template_id("mezzofy_transfer");  
couponTransferModel.setCustomer_id("T9N775");  
couponTransferModel.setSender_message("Hi, Take your Gift Pack");  
couponTransferModel.setLang("en");  
  
  
Call<TransferCouponResponseData> loginResponseCall= mzApiClient.getCouponTransactionService("Your AccessToken",couponTransferModel).postCouponTransfer();
```

**Return**
transfer_id;  
from_customer_id;  
merchant_id;  
status;  
sender_message;  
ArrayList<**ToCustomer**> to_customer;


**Call Function For ISSUE COUPON ---  Issue Coupon RollBack**
``` java
Call<IssueCommitResponseData> loginResponseCall= mzApiClient.getCouponIssueRollbackService("Your AccessToken").postIssueCouponRollback("TransactionId");
```

**Return**
coupon_via;  
created_on;  
customer_id;  
hash_code;  
merchant_id;  
pay_receipt;  
pay_response;  
payment_name;  
po_date;  
transaction_id;  
po_no;  
po_status;  
reward_point;  
updated_on;  
po_total;  
ArrayList<**CustomerCouponData**>;



**Call Function For REDEEM COUPON ---  Redeem Coupon**
``` java
ExpressRedeemModel expressRedeemModel=new ExpressRedeemModel();  
  
TxnRedeem txnRedeem=new TxnRedeem();  
txnRedeem.setLang("en");  
txnRedeem.setTransaction_by("Pin Redemption");  
txnRedeem.setTransaction_note("Test");  
txnRedeem.setOutlet_id("RH11X");  
  
TxnSerial txnSerial=new TxnSerial();  
txnSerial.setSerial("5JZIFPLVRJ");  
txnSerial.setRedeem_value(0);  
  
ArrayList<TxnSerial> txnSerialList=new ArrayList();  
txnSerialList.add(txnSerial);  
  
expressRedeemModel.setTxn_redeem(txnRedeem);  
expressRedeemModel.setTxn_serials(txnSerialList);  
  
Call<RedeemResponse> loginResponseCall= mzApiClient.getRedeemService("Your AccessToken",expressRedeemModel).PostRedeem();
```

**Return**
outlet_id;  
created_on;  
hash_code;  
order_date;  
order_no;  
order_status;  
order_type;  
updated_on;  
customer_id;  
merchant_id;  
lang;  
transaction_id;  
guestckId;  
branchCode;



**Call Function For REDEEM COUPON ---  Redeem Commit Coupon**
``` java
RedeemCommit redeemCommit=new RedeemCommit();  
  
redeemCommit.setTransaction_note("Redeem commit");  
  
Call<RedeemResponseModel> loginResponseCall= mzApiClient.getRedeemCommitService("Your AccessToken",redeemCommit).PostRedeemCommit("transaction_id");
```

**Return**
outlet_id;  
created_on;  
hash_code;  
order_date;  
order_no;  
order_status;  
order_type;  
updated_on;  
customer_id;  
merchant_id;  
lang;  
transaction_id;  
guestckId;  
branchCode;


**Call Function For REDEEM COUPON ---  Redeem Rollback Coupon**
``` java
RedeemCommit redeemCommit=new RedeemCommit();  
  
redeemCommit.setTransaction_note("rollback serial04012022");  
redeemCommit.setTransaction_ref_no("Rollbacked 04012022");  
  
Call<RedeemResponse> loginResponseCall= mzApiClient.getRedeemRollBackService("Your AccessToken",redeemCommit).PostRedeemRollBack("transaction_id");
```

**Return**
outlet_id;  
created_on;  
hash_code;  
order_date;  
order_no;  
order_status;  
order_type;  
updated_on;  
customer_id;  
merchant_id;  
lang;  
transaction_id;  
guestckId;  
branchCode;


**Call Function For REDEEM COUPON ---  Redeem Void Coupon**
``` java
TransationVoidModel transationVoidModel=new TransationVoidModel();  
ArrayList<String> txnSerialList=new ArrayList<>();  
txnSerialList.add("6XOV29LMQL");  
  
TxnVoid txnVoid=new TxnVoid();  
txnVoid.setLang("en");  
txnVoid.setDelivery_method("E");  
txnVoid.setRemarks("Mezzofy");  
txnVoid.setReference_id("RH11X");  
txnVoid.setTemplate_id("REFUND_HYATT_COUPON");  
  
txnVoid.setOutlet_id("RH11X");  
  
transationVoidModel.setTxn_void(txnVoid);  
transationVoidModel.setTxn_serials(txnSerialList);  
  
Call<RedeemResponse> loginResponseCall= mzApiClient.getTransactionService("Your AccessToken",transationVoidModel).PostVoidRedeemCoupon();
```

**Return**
outlet_id;  
created_on;  
hash_code;  
order_date;  
order_no;  
order_status;  
order_type;  
updated_on;  
customer_id;  
merchant_id;  
lang;  
transaction_id;  
guestckId;  
branchCode;

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

  ![](https://mzcoupon.s3.ap-southeast-1.amazonaws.com/logo/E46D138D-8450-4C61-BB8A-63E26D3D367E.jpg)

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


**Call Function For Get Outlet By CouponCode**
``` java

Map<String, String> params = new HashMap<String, String>();  
params.put("limit", "20");  
params.put("skip", "0");  
params.put("search_by", "Aravind");  
params.put("coupon_code","\'1004634\'");  
Call<OutletProfileModel> outletProfileModelCall= mzApiClient.getOutletService("Your Access Token").getOutletByCouponCode(params);

```

**Return**
OutletProfileModel;


**Call Function For Get Outlet By RedeemPass**
``` java


Map<String, String> params = new HashMap<String, String>();  
params.put("outlet_redeem_pass", "2222");  
  
Call<OutletProfile> outletProfileModelCall= mzApiClient.getOutletService("Your Access Token").getOutletByRedeemPass(params);


```

**Return**
OutletProfile;




  

##### Click here for [Full Implementation Guide](https://github.com/mezzofy/mzcoupon-android-customer-lib-v2)

  

# Licenses

  

All source code is licensed under the [MIT License.](https://raw.githubusercontent.com/mezzofy/mzcoupon-android-customer-lib/9f6d85cdaa1a03f323a81d6adf45df36cebb4c75/LICENSE)

  

  

### End