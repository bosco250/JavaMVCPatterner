package Controller;

import Model.Teacher;
import Model.TeacherDB;
import View.TeacherView;

import java.util.ArrayList;

public class TeacherController {
    private TeacherDB teacherDB;
    private TeacherView teacherView;

    public TeacherController(TeacherDB teacherDB2, TeacherView teacherView2) {
        this.teacherDB = teacherDB2;
        this.teacherView = teacherView2;
    }

    public void listAllTeachers() {
        ArrayList<Teacher> teachers = teacherDB.getAllTeacher();
        teacherView.displayTeachers(teachers);
    }

    public void addTeacher(Teacher teacher) {
        teacherDB.addTeacher(teacher);
        listAllTeachers();
    }

    public void updateTeacher(Teacher teacher) {
        teacherDB.updateTeacher(teacher);
        listAllTeachers();
    }

    public void deleteTeacher(int id) {
        teacherDB.deleteTeacher(id);
        listAllTeachers();
    }
}