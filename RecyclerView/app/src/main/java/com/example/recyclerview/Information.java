package com.example.recyclerview;

public class Information {
    private String imageUrl;
    private String info;
    private int id;

    public Information(int id,String imageUrl, String info) {
        this.imageUrl = imageUrl;
        this.info = info;
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
