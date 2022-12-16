package com.example.studentlist.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance= new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        for(int i=0; i<5; i++) {
            addStudent(new Student("name " + i, "" + i, "0545566778", "sokolov st: " +i , "",false));
        }
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }
}
