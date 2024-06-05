package Controller;

import Model.Course;
import Model.CourseDB;
import View.CourseView;

import java.util.ArrayList;

public class CourseController {
    private CourseDB courseDB;
    private CourseView courseView;

    public CourseController(CourseDB courseDB, CourseView courseView) {
        this.courseDB = courseDB;
        this.courseView = courseView;
    }

    public void listAllCourses() {
       ArrayList<Course> courses = courseDB.getAllCourses();
        courseView.displayCourses(courses);
    }

    public void addCourse(Course course) {
        courseDB.addCourse(course);
        listAllCourses();
    }

    public void updateCourse(Course course) {
        courseDB.updateCourse(course);
        listAllCourses();
    }

    public void deleteCourse(int id) {
        courseDB.deleteCourse(id);
        listAllCourses();
    }
}
