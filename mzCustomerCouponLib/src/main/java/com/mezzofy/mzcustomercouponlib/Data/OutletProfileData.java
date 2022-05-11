package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class OutletProfileData {
    private OutletProfile profile;
    private ArrayList<CouponAccess> coupon_access;


    public OutletProfile getProfile() {
        return profile;
    }

    public void setProfile(OutletProfile profile) {
        this.profile = profile;
    }

    public ArrayList<CouponAccess> getCoupon_access() {
        return coupon_access;
    }

    public void setCoupon_access(ArrayList<CouponAccess> coupon_access) {
        this.coupon_access = coupon_access;
    }
}
