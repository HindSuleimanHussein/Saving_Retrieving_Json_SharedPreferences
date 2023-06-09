package com.example.myapplication;

public class Student {
    private String name;
    private String email;
    private String gender;
    private Boolean finalYear;

    public Student(String name, String email, String gender, Boolean finalYear) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.finalYear = finalYear;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getFinalYear() {
        return finalYear;
    }

    public void setFinalYear(Boolean finalYear) {
        this.finalYear = finalYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", finalYear=" + finalYear +
                '}';
    }
}
