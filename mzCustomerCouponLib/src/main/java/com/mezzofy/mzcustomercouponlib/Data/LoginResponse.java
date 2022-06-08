package com.mezzofy.mzcustomercouponlib.Data;

public class LoginResponse {
    private String accessToken;
    private String accessTokenExpiresAt;
    private String customerCouponAccessToken;
    private String customerCouponAccessTokenExpiresAt;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    public void setAccessTokenExpiresAt(String accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    public String getCustomerCouponAccessToken() {
        return customerCouponAccessToken;
    }

    public void setCustomerCouponAccessToken(String customerCouponAccessToken) {
        this.customerCouponAccessToken = customerCouponAccessToken;
    }

    public String getCustomerCouponAccessTokenExpiresAt() {
        return customerCouponAccessTokenExpiresAt;
    }

    public void setCustomerCouponAccessTokenExpiresAt(String customerCouponAccessTokenExpiresAt) {
        this.customerCouponAccessTokenExpiresAt = customerCouponAccessTokenExpiresAt;
    }
}
