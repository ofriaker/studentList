package com.example.studentlist.Model;

public class Student {

    public String name;
    public String id;
    public String avatarURL;
    public boolean cb;

    public Student(String name, String id, String avatarURL, boolean cb) {
        this.name = name;
        this.id = id;
        this.avatarURL = avatarURL;
        this.cb = cb;
    }
}
