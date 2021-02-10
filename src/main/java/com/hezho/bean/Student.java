package com.hezho.bean;

public class Student {
    private String studentName;  // 属性名要和数据库的列名相同（大小写先不用管）
    private int studentId;
    private int gradId;
    private int stuId;
    private Grade grade;

    // 要声明一个无参构造方法
    // https://blog.csdn.net/zuihongyan518/article/details/91448016
    public Student(){}

    public Student(int studentId, String studentName, int gradId){
        this.studentId = studentId;
        this.studentName = studentName;
        this.gradId = gradId;
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

    // 这里需要重写 toString，否则 System.out.pringln(student) 只会返回一个内存地址
    @Override
    public String toString(){
        return "Student{" +
                "studentId=" + studentId + + '\'' +
                ", studentName=" + studentName + '\'' +
                ", gradId=" + gradId + '\'' +
                ", stuId=" + stuId + '\'' +
                '}';
    }

    public int getGradId() {
        return gradId;
    }

    public void setGradId(int gradId) {
        this.gradId = gradId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
