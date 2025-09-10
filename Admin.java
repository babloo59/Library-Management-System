import java.util.Scanner;

public class Admin {
    public void adminMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View All Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // restart menu
            }

            if (choice == 0) {
                System.out.println("Exiting Admin Menu.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter course name to add: ");
                    String newCourse = sc.nextLine();
                    CourseManager.addCourse(newCourse);
                    System.out.println("Course '" + newCourse + "' added.");
                    break;

                case 2:
                    System.out.print("Enter course name to remove: ");
                    String courseToRemove = sc.nextLine();
                    if (CourseManager.removeCourse(courseToRemove)) {
                        System.out.println("Course '" + courseToRemove + "' removed.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    System.out.println("All Courses:");
                    for (String course : CourseManager.getCourses()) {
                        System.out.println("- " + course);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
