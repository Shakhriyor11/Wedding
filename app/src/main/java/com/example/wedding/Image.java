package com.example.wedding;


import java.util.ArrayList;

public class Image {

    private int imgResource;
    private int imgResource1;
    private int imgResource2;

    public Image(int imgResource,int imgResource1,int imgResource2) {
        this.imgResource = imgResource;
        this.imgResource1 = imgResource1;
        this.imgResource2 = imgResource2;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public int getImgResource1() {
        return imgResource1;
    }

    public void setImgResource1(int imgResource1) {
        this.imgResource1 = imgResource1;
    }

    public int getImgResource2() {
        return imgResource2;
    }

    public void setImgResource2(int imgResource2) {
        this.imgResource2 = imgResource2;
    }
}
