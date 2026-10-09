# SWYNEX Java Fundamentals Application

A console-based Java application created for the SWYNEX Java Fundamentals task.

## Objective
The application demonstrates:
- Classes and objects
- Constructors, encapsulation and methods
- Java Collections (`ArrayList`)
- Searching, updating, deleting and sorting
- Exception handling
- Custom exceptions
- Input validation
- Clean and modular code structure

## Features
1. Add Student
2. View All Students
3. Search Student by Name
4. Update Student
5. Delete Student
6. Sort Students by Percentage
7. Calculate Average Percentage
8. Exit

## Technologies
- Java 21
- Maven
- Git/GitHub

## Project Structure
```text
SWYNEX-Java-Fundamentals-Application/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── swynex/
                    └── javabasics/
                        ├── Main.java
                        ├── Student.java
                        ├── StudentManager.java
                        └── StudentNotFoundException.java
```

## How to Run

### Option 1: IntelliJ IDEA / Eclipse / NetBeans
Open the project and run:
`com.swynex.javabasics.Main`

### Option 2: Maven
From the project folder:
```bash
mvn clean compile
mvn exec:java
```

## Concepts Demonstrated
- **Class & Object:** `Student`, `StudentManager`
- **Methods:** CRUD, search, sort and average calculation
- **Collection:** `ArrayList<Student>`
- **Exception Handling:** `try-catch`, `IllegalArgumentException`, `NumberFormatException`
- **Custom Exception:** `StudentNotFoundException`
- **Clean Code:** Separate model, manager/service-style logic and application entry point

## Sample Output
```text
SWYNEX - JAVA FUNDAMENTALS APPLICATION

1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Sort by Percentage
7. Calculate Average Percentage
8. Exit
```

## Learning Outcome
This project helped me strengthen Java fundamentals by applying object-oriented programming, collections, methods, exception handling and clean code practices in a practical console application.
