import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private static List<String> courses = new ArrayList<>();

    // initialize with some default courses
    static {
        courses.add("Math");
        courses.add("Science");
        courses.add("History");
    }

    public static List<String> getCourses() {
        return courses;
    }

    public static void addCourse(String course) {
        courses.add(course);
    }

    public static boolean removeCourse(String course) {
        return courses.remove(course);
    }
}
