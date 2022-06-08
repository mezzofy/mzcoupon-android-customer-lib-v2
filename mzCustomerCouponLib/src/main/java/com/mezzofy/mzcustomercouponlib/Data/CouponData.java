package com.mezzofy.mzcustomercouponlib.Data;

import java.util.ArrayList;

public class CouponData {
    private Coupon coupon;
    private CouponCounts coupon_counts;
    private CouponMetadata coupon_metadata;
    private CouponTimings coupon_timings;
    private CouponLinks coupon_links;
    private Localization localization;
    private ArrayList<CouponImage> coupon_images;
    private ArrayList<CouponOutlet> coupon_outlets;
//    private ArrayList<CouponTag> coupon_tags;
    private Merchant merchant;

    public ArrayList<CouponImage> getCoupon_images() {
        return coupon_images;
    }

    public void setCoupon_images(ArrayList<CouponImage> coupon_images) {
        this.coupon_images = coupon_images;
    }

    public ArrayList<CouponOutlet> getCoupon_outlets() {
        return coupon_outlets;
    }

    public void setCoupon_outlets(ArrayList<CouponOutlet> coupon_outlets) {
        this.coupon_outlets = coupon_outlets;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public CouponCounts getCoupon_counts() {
        return coupon_counts;
    }

    public void setCoupon_counts(CouponCounts coupon_counts) {
        this.coupon_counts = coupon_counts;
    }

    public CouponMetadata getCoupon_metadata() {
        return coupon_metadata;
    }

    public void setCoupon_metadata(CouponMetadata coupon_metadata) {
        this.coupon_metadata = coupon_metadata;
    }

    public CouponTimings getCoupon_timings() {
        return coupon_timings;
    }

    public void setCoupon_timings(CouponTimings coupon_timings) {
        this.coupon_timings = coupon_timings;
    }

    public CouponLinks getCoupon_links() {
        return coupon_links;
    }

    public void setCoupon_links(CouponLinks coupon_links) {
        this.coupon_links = coupon_links;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
