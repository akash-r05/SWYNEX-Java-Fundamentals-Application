package com.swynex.javabasics;

/**
 * Represents a student in the application.
 * Demonstrates class, object state, constructors, getters/setters and methods.
 */
public class Student {
    private final int id;
    private String name;
    private String course;
    private double percentage;

    public Student(int id, String name, String course, double percentage) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Name: %s | Course: %s | Percentage: %.2f | Grade: %s",
                id, name, course, percentage, getGrade()
        );
    }
}
