package com.mezzofy.mzcustomercouponlib.Data;

public class Outlet {
    private String outlet_id;
    private String outlet_name;
    private String outlet_address;
    private String outlet_contact;
    private String outlet_status;
    private double outlet_latitude;
    private double outlet_longitude;
    private String outlet_location;
    private Localization localization;

    public String getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(String outlet_id) {
        this.outlet_id = outlet_id;
    }

    public String getOutlet_name() {
        return outlet_name;
    }

    public void setOutlet_name(String outlet_name) {
        this.outlet_name = outlet_name;
    }

    public String getOutlet_address() {
        return outlet_address;
    }

    public void setOutlet_address(String outlet_address) {
        this.outlet_address = outlet_address;
    }

    public String getOutlet_contact() {
        return outlet_contact;
    }

    public void setOutlet_contact(String outlet_contact) {
        this.outlet_contact = outlet_contact;
    }

    public String getOutlet_status() {
        return outlet_status;
    }

    public void setOutlet_status(String outlet_status) {
        this.outlet_status = outlet_status;
    }

    public double getOutlet_latitude() {
        return outlet_latitude;
    }

    public void setOutlet_latitude(double outlet_latitude) {
        this.outlet_latitude = outlet_latitude;
    }

    public double getOutlet_longitude() {
        return outlet_longitude;
    }

    public void setOutlet_longitude(double outlet_longitude) {
        this.outlet_longitude = outlet_longitude;
    }

    public String getOutlet_location() {
        return outlet_location;
    }

    public void setOutlet_location(String outlet_location) {
        this.outlet_location = outlet_location;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }
}
