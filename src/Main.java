import Controller.TeacherController;
import Model.TeacherDB;
import Model.Teacher;
import View.TeacherView;

import Controller.CourseController;
import Model.CourseDB;
import Model.Course;
import View.CourseView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        TeacherDB teacherDB = new TeacherDB();
        TeacherView teacherView = new TeacherView();
        TeacherController teacherController = new TeacherController(teacherDB, teacherView);
        
        CourseDB courseDB=new CourseDB();
        CourseView courseView=new CourseView();
        CourseController courseController=new CourseController(courseDB,courseView);

        teacherView.setVisible(true);
        courseView.setVisible(true);

        teacherController.listAllTeachers();
        courseController.listAllCourses();

        teacherView.setAddButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher = new Teacher();
                teacher.setName(teacherView.getTeacherName());
                teacher.setEmail(teacherView.getTeacherEmail());
                teacherController.addTeacher(teacher);
                teacherView.clearFields();
            }
        });
        courseView.setAddButtonActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		Course course=new Course();
        		course.setName(courseView.getCourseName());
        		course.setTeacherId(courseView.getCourseTeacherId());
        		courseController.addCourse(course);
        		courseView.clearFields();
        	}
        });
        
        

        teacherView.setUpdateButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher = new Teacher();
                teacher.setId(teacherView.getTeacherId());
                teacher.setName(teacherView.getTeacherName());
                teacher.setEmail(teacherView.getTeacherEmail());
                teacherController.updateTeacher(teacher);
                teacherView.clearFields();
            }
        });

        teacherView.setDeleteButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = teacherView.getTeacherId();
                teacherController.deleteTeacher(id);
                teacherView.clearFields();
            }
        });
    }
}