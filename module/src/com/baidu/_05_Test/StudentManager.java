package com.baidu._05_Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Condition notEmpty = lock.writeLock().newCondition();

    public void addStudent(Student student) {
        lock.writeLock().lock();
        try {
            students.add(student);
            notEmpty.signalAll(); // 唤醒等待的线程
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Student getFirstStudent() throws InterruptedException {
        lock.readLock().lock();
        try {
            while (students.isEmpty()) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    while (students.isEmpty()) {
                        notEmpty.await(); // 线程等待
                    }
                } finally {
                    lock.readLock().lock();
                    lock.writeLock().unlock();
                }
            }
            return students.get(0);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Student> getAllStudents() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(students);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void modifyStudentScoreUsingReflection(Student student, int newScore) throws Exception {
        Field scoreField = Student.class.getDeclaredField("score");
        scoreField.setAccessible(true);
        scoreField.set(student, newScore);
    }
}
