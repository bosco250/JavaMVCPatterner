package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Course;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CourseView extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField teacherIdField;
    JLabel l1,l2,l3;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    DefaultTableModel dtm;
    JTable t;
    JScrollPane scp;

    public CourseView() {
        setTitle("Course Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dtm=new DefaultTableModel();
        t=new JTable(dtm);
        scp=new JScrollPane(t);
        String col[]= {"ID","Name","TeacherId"};
        for(String cl:col) {
        	dtm.addColumn(cl);
        }
        
        idField = new JTextField(5);
        nameField = new JTextField(15);
        teacherIdField = new JTextField(15);
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        l1=new JLabel("ID:");
        l2=new JLabel("Name:");
        l3=new JLabel("TeacherId:");

        // Set the layout constraints for each component
        idField.setBounds(110, 10, 100, 20);
        nameField.setBounds(110, 40, 200, 20);
        teacherIdField.setBounds(110, 70, 200, 20);
        addButton.setBounds(10, 100, 80, 20);
        updateButton.setBounds(100, 100, 80, 20);
        deleteButton.setBounds(190, 100, 80, 20);
        l2.setBounds(10, 40, 50, 20);
        l1.setBounds(10, 10, 50, 20);
        l3.setBounds(10, 70, 70, 20);
        scp.setBounds(10, 130, 460, 360);
        
        add(l1);add(l2);add(l3);
        add(idField);add(nameField);add(teacherIdField);
        add(addButton);add(updateButton);add(deleteButton);
        add(scp);
        
        setLayout(null);
        //setResizable(false);
        setVisible(true);
    }


    public void displayCourses(ArrayList<Course> courses) {
        dtm.setRowCount(0);
        for (Course course : courses) {
          dtm.addRow(new Object[] {course.getId(),course.getName(),course.getTeacherId()});
        }
    }

    public String getCourseName() {
        return nameField.getText();
    }

    public int getCourseTeacherId() {
        return Integer.parseInt(teacherIdField.getText());
    }

    public int getCourseId() {
        return Integer.parseInt(idField.getText());
    }

    public void setAddButtonActionListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void setUpdateButtonActionListener(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public void setDeleteButtonActionListener(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }
    public void clearFields() {
        nameField.setText("");
        teacherIdField.setText("");
        idField.setText("");
    }

}
