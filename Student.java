import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    public void studentMenu() {
        Scanner sc = new Scanner(System.in);
        List<String> enrolledCourses = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. View available Courses");
            System.out.println("2. Enroll in a Course");
            System.out.println("3. View Enrolled Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Viewing available courses...");
                    if (CourseManager.getCourses().isEmpty()) {
                        System.out.println("No courses available.");
                    } else {
                        for (String course : CourseManager.getCourses()) {
                            System.out.println("- " + course);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter course name to enroll: ");
                    String newCourse = sc.nextLine();
                    if (CourseManager.getCourses().contains(newCourse)) {
                        if (enrolledCourses.contains(newCourse)) {
                            System.out.println("You are already enrolled in " + newCourse);
                        } else {
                            enrolledCourses.add(newCourse);
                            System.out.println("Enrolled in course: " + newCourse);
                        }
                    } else {
                        System.out.println("Course not found. Please ask admin to add it first.");
                    }
                    break;

                case 3:
                    System.out.println("Enrolled Courses:");
                    if (enrolledCourses.isEmpty()) {
                        System.out.println("You are not enrolled in any courses.");
                    } else {
                        for (String course : enrolledCourses) {
                            System.out.println("- " + course);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting Student Menu.");
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
