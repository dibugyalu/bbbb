package com.baidu._05_Test;

public class Student implements Cloneable {
    private int studentId;
    private String name;
    private int score;

    public Student(int studentId, String name, int score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 浅克隆
    }

    public Student deepClone() {
        return new Student(this.studentId, this.name, this.score); // 深克隆
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name='" + name + '\'' + ", score=" + score + '}';
    }
}
