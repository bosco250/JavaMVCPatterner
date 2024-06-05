package View;

import Model.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.*;

public class TeacherView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField;
    private JTextField emailField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField idField;
    private JLabel l1, l2, l3;

    public TeacherView() {
        setTitle("Teacher Management");
        setSize(520, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        String col[]= {"Id","Name","Email"};
        for(int i=0;i<col.length;i++) {
        tableModel.addColumn(col[i]);
        }

        idField = new JTextField(5);
        nameField = new JTextField(15);
        emailField = new JTextField(15);
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        l1 = new JLabel("id");
        l2 = new JLabel("Name");
        l3 = new JLabel("Email");

        add(l1);
        add(idField);
        add(l2);
        add(nameField);
        add(l3);
        add(emailField);
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(scrollPane);

        // Set the layout constraints for each component
        l1.setBounds(10, 10, 50, 20);
        idField.setBounds(60, 10, 100, 20);
        l2.setBounds(10, 40, 50, 20);
        nameField.setBounds(60, 40, 200, 20);
        l3.setBounds(10, 70, 50, 20);
        emailField.setBounds(60, 70, 200, 20);
        addButton.setBounds(10, 100, 80, 20);
        updateButton.setBounds(100, 100, 80, 20);
        deleteButton.setBounds(190, 100, 80, 20);
        scrollPane.setBounds(10, 130, 480, 360);

        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void displayTeachers(ArrayList<Teacher> teachers) {
        // Clear the table
        tableModel.setRowCount(0);

        // Add the teachers to the table
        for (Teacher teacher : teachers) {
            tableModel.addRow(new Object[]{teacher.getId(), teacher.getName(), teacher.getEmail()});
        }
    }

    public String getTeacherName() {
        return nameField.getText();
    }

    public String getTeacherEmail() {
        return emailField.getText();
    }

    public int getTeacherId() {
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
        emailField.setText("");
        idField.setText("");
    }
}