package com.example.wedding;

public class VpEvents {
    private int imgs;
    private String title;

    public VpEvents(int imgs, String title) {
        this.imgs = imgs;
        this.title = title;
    }

    public int getImgs() {
        return imgs;
    }

    public void setImgs(int imgs) {
        this.imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
