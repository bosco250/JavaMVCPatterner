package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try (Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Courses")) {
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setTeacherId(rs.getInt("teacher_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void addCourse(Course course) {
        String sql = "INSERT INTO Courses (name, teacher_id) VALUES (?, ?)";
        try (Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, course.getName());
            pstmt.setInt(2, course.getTeacherId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE Courses SET name = ?, teacher_id = ? WHERE id = ?";
        try (Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, course.getName());
            pstmt.setInt(2, course.getTeacherId());
            pstmt.setInt(3, course.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM Courses WHERE id = ?";
        try (Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
