package com.example.studentlist.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance= new Model();

    public static Model instance() {
        return _instance;
    }

    private Model() {
        addStudent(new Student("Ofri Akerman", "1234", "0542154788", "sokolov 33", "",false));
        addStudent(new Student("Amit Sabag", "12345", "0548888788", "peres 33", "",false));
        addStudent(new Student("Israla Israeli", "0571234", "0542154788", "sokolov 40", "",false));
        addStudent(new Student("Bla Bla", "7781234", "0542154788", "hashalom 30", "",false));
        addStudent(new Student("Avi Avi", "12784", "0542154788", "tel aviv 1", "",false));
        addStudent(new Student("Avia Avia", "1234664", "0542154788", "yerushalaim 7", "",false));

    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
        //notifyAll();
    }

    public void deleteStudent(int pos){
        data.remove(pos);
    }
}
