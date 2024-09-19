package com.example.gridview;

public class Picture {
    private String url;
    private  long id;
    private String name;

    public Picture(String url, long id, String name) {
        this.url = url;
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
