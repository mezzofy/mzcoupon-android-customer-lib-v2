package com.mezzofy.mzcustomercouponlib.Data;

public class tLocalization {
    public SelectedLanguage getEmail_footer() {
        return email_footer;
    }

    public void setEmail_footer(SelectedLanguage email_footer) {
        this.email_footer = email_footer;
    }

    public OutletName getOutlet_name() {
        return outlet_name;
    }

    public void setOutlet_name(OutletName outlet_name) {
        this.outlet_name = outlet_name;
    }

    public OutletDesc getOutlet_desc() {
        return outlet_desc;
    }

    public void setOutlet_desc(OutletDesc outlet_desc) {
        this.outlet_desc = outlet_desc;
    }

    public OutletAddress getOutlet_address() {
        return outlet_address;
    }

    public void setOutlet_address(OutletAddress outlet_address) {
        this.outlet_address = outlet_address;
    }

    private SelectedLanguage email_footer;
    private OutletName outlet_name;
    private OutletDesc outlet_desc;
    private OutletAddress outlet_address;


}
