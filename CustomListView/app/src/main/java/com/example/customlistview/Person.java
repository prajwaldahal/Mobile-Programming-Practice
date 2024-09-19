package com.example.customlistview;

public class Person {
    private int id;

    private int pp;
    private String name,email,phone;


    public Person(int id, String name, String email, String phone,int pp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pp=pp;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

}
