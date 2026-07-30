import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentResultSystem {

    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Student> students = new HashMap<>();

    static class Student {
        String name;
        HashMap<String, Integer> marks;
        int total;
        double percentage;
        String grade;

        Student(String name, HashMap<String, Integer> marks, int total, double percentage, String grade) {
            this.name = name;
            this.marks = marks;
            this.total = total;
            this.percentage = percentage;
            this.grade = grade;
        }
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void addStudent() {
        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        HashMap<String, Integer> marks = new HashMap<>();

        String[] subjects = {"Math", "Physics", "Computer"};

        int total = 0;

        for (String subject : subjects) {
            System.out.print("Enter " + subject + " marks: ");
            int mark = sc.nextInt();
            sc.nextLine();
            marks.put(subject, mark);
            total += mark;
        }

        double percentage = (double) total / subjects.length;
        String grade = calculateGrade(percentage);

        Student student = new Student(name, marks, total, percentage, grade);
        students.put(rollNo, student);

        System.out.println("Student added successfully!\n");
    }

    public static void displayResults() {
        if (students.isEmpty()) {
            System.out.println("No records found");
            return;
        }

        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String roll = entry.getKey();
            Student data = entry.getValue();

            System.out.println("\n----------------------");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + data.name);
            System.out.println("Marks: " + data.marks);
            System.out.println("Total: " + data.total);
            System.out.printf("Percentage: %.2f%%\n", data.percentage);
            System.out.println("Grade: " + data.grade);
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        String roll = sc.nextLine();

        if (students.containsKey(roll)) {
            Student data = students.get(roll);

            System.out.println("\nStudent Result");
            System.out.println("Name: " + data.name);
            System.out.println("Marks: " + data.marks);
            System.out.printf("Percentage: %.2f%%\n", data.percentage);
            System.out.println("Grade: " + data.grade);
        } else {
            System.out.println("Student not found");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Result System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Results");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;

                case "2":
                    displayResults();
                    break;

                case "3":
                    searchStudent();
                    break;

                case "4":
                    System.out.println("Program Ended");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
