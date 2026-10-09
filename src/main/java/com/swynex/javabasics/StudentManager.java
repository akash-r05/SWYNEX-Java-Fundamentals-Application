package com.swynex.javabasics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Handles student operations.
 * Demonstrates collections, methods, searching, updating and sorting.
 */
public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (findStudentById(student.getId()) != null) {
            throw new IllegalArgumentException("Student ID already exists.");
        }
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        String searchText = keyword.toLowerCase();

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchText)) {
                result.add(student);
            }
        }
        return result;
    }

    public void updateStudent(int id, String name, String course, double percentage)
            throws StudentNotFoundException {
        Student student = findStudentById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " was not found.");
        }

        student.setName(name);
        student.setCourse(course);
        student.setPercentage(percentage);
    }

    public void deleteStudent(int id) throws StudentNotFoundException {
        Student student = findStudentById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " was not found.");
        }
        students.remove(student);
    }

    public void sortByPercentageDescending() {
        students.sort(Comparator.comparingDouble(Student::getPercentage).reversed());
    }

    public double calculateAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (Student student : students) {
            total += student.getPercentage();
        }
        return total / students.size();
    }

    public int size() {
        return students.size();
    }
}
