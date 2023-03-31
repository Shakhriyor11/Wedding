package com.example.wedding;

import android.graphics.PorterDuff;

public class Services {

    private int servicesImg;
    private String servicesTitle;
    private String ServicesDescription;
    private String servicesPrice;

    public Services(int servicesImg, String servicesTitle, String servicesDescription, String servicesPrice) {
        this.servicesImg = servicesImg;
        this.servicesTitle = servicesTitle;
        ServicesDescription = servicesDescription;
        this.servicesPrice = servicesPrice;
    }

    public int getServicesImg() {
        return servicesImg;
    }

    public void setServicesImg(int servicesImg) {
        this.servicesImg = servicesImg;
    }

    public String getServicesTitle() {
        return servicesTitle;
    }

    public void setServicesTitle(String servicesTitle) {
        this.servicesTitle = servicesTitle;
    }

    public String getServicesDescription() {
        return ServicesDescription;
    }

    public void setServicesDescription(String servicesDescription) {
        ServicesDescription = servicesDescription;
    }

    public String getServicesPrice() {
        return servicesPrice;
    }

    public void setServicesPrice(String servicesPrice) {
        this.servicesPrice = servicesPrice;
    }
}
