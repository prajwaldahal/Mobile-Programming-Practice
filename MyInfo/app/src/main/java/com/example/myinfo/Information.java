package com.example.myinfo;

public class Information {

    private String hobbies;
    private String skills;

    public Information(String hobbies, String skills) {
        this.hobbies = hobbies;
        this.skills = skills;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
