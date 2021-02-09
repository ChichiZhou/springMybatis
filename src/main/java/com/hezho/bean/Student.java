package com.hezho.bean;

public class Student {
    private String studentName;  // 属性名要和数据库的列名相同（大小写先不用管）
    private int studentId;

    public Student(int studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
