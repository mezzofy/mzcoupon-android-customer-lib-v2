package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class Couponserial {
    private Coupon coupon;
    private Serial serial;
    private ArrayList<Outlet> outlets;
    private ArrayList<ImagesModel> coupon_images;
    private Merchant merchant;

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public ArrayList<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(ArrayList<Outlet> outlets) {
        this.outlets = outlets;
    }

    public ArrayList<ImagesModel> getCoupon_images() {
        return coupon_images;
    }

    public void setCoupon_images(ArrayList<ImagesModel> coupon_images) {
        this.coupon_images = coupon_images;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}

