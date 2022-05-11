package com.mezzofy.mzcustomercouponlib.Data;

import java.util.Date;

public class CustomerSetting {
    private String cus_setting_id;
    private String block_list_email;
    private Date created_on;
    private String merchant_id;
    private Date updated_on;
    private String banner_url;
    private String wallet_banner_url;
    private String secure_status;

    public String getCus_setting_id() {
        return cus_setting_id;
    }

    public void setCus_setting_id(String cus_setting_id) {
        this.cus_setting_id = cus_setting_id;
    }

    public String getBlock_list_email() {
        return block_list_email;
    }

    public void setBlock_list_email(String block_list_email) {
        this.block_list_email = block_list_email;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getWallet_banner_url() {
        return wallet_banner_url;
    }

    public void setWallet_banner_url(String wallet_banner_url) {
        this.wallet_banner_url = wallet_banner_url;
    }

    public String getSecure_status() {
        return secure_status;
    }

    public void setSecure_status(String secure_status) {
        this.secure_status = secure_status;
    }
}
