package com.hezho.bean;

import java.util.List;

public class Grade {
    private int gradId;
    private String gradName;
    private List<Student> studentList;

    public int getGradId() {
        return gradId;
    }

    public void setGradId(int gradId) {
        this.gradId = gradId;
    }

    public String getGradName() {
        return gradName;
    }

    public void setGradName(String gradName) {
        this.gradName = gradName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
