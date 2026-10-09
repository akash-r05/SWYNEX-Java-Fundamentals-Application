package com.swynex.javabasics;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the SWYNEX Java Fundamentals Application.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        seedSampleData();

        System.out.println("==============================================");
        System.out.println("   SWYNEX - JAVA FUNDAMENTALS APPLICATION");
        System.out.println("==============================================");

        boolean running = true;

        while (running) {
            displayMenu();

            try {
                int choice = readInt("Enter your choice: ");

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> deleteStudent();
                    case 6 -> sortStudents();
                    case 7 -> showAverage();
                    case 8 -> {
                        running = false;
                        System.out.println("Thank you for using the application!");
                    }
                    default -> System.out.println("Invalid choice. Please select 1-8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n------------- MENU -------------");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Sort by Percentage");
        System.out.println("7. Calculate Average Percentage");
        System.out.println("8. Exit");
        System.out.println("--------------------------------");
    }

    private static void addStudent() {
        int id = readInt("Enter student ID: ");
        String name = readText("Enter student name: ");
        String course = readText("Enter course: ");
        double percentage = readPercentage("Enter percentage (0-100): ");

        try {
            manager.addStudent(new Student(id, name, course, percentage));
            System.out.println("Student added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudents() {
        List<Student> students = manager.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nStudents:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("Total students: " + manager.size());
    }

    private static void searchStudent() {
        String keyword = readText("Enter name to search: ");
        List<Student> results = manager.searchByName(keyword);

        if (results.isEmpty()) {
            System.out.println("No student found.");
            return;
        }

        for (Student student : results) {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        int id = readInt("Enter student ID to update: ");
        String name = readText("Enter new name: ");
        String course = readText("Enter new course: ");
        double percentage = readPercentage("Enter new percentage (0-100): ");

        try {
            manager.updateStudent(id, name, course, percentage);
            System.out.println("Student updated successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        int id = readInt("Enter student ID to delete: ");

        try {
            manager.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sortStudents() {
        manager.sortByPercentageDescending();
        System.out.println("Students sorted by percentage (highest to lowest).");
        viewStudents();
    }

    private static void showAverage() {
        System.out.printf("Average percentage: %.2f%%%n", manager.calculateAverage());
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readPercentage(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine().trim());

                if (value < 0 || value > 100) {
                    System.out.println("Percentage must be between 0 and 100.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid percentage.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private static void seedSampleData() {
        manager.addStudent(new Student(101, "Akash", "MCA", 78.5));
        manager.addStudent(new Student(102, "Rahul", "BCA", 82.0));
        manager.addStudent(new Student(103, "Sneha", "MCA", 91.0));
    }
}
