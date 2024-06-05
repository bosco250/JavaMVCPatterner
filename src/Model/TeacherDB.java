package Model;
import java.sql.*;
import java.util.ArrayList;

public class TeacherDB {
	public ArrayList<Teacher>getAllTeacher(){
		ArrayList<Teacher>teachers=new ArrayList<>();
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
			Statement stmt=connection.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM Teachers");
		            while (rs.next()) {
		                Teacher teacher = new Teacher();
		                teacher.setId(rs.getInt("id"));
		                teacher.setName(rs.getString("name"));
		                teacher.setEmail(rs.getString("email"));
		                teachers.add(teacher);
		            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return teachers;
	}
	public void addTeacher(Teacher teacher) {
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
			PreparedStatement ps=connection.prepareStatement("INSERT INTO Teachers (name, email) VALUES (?, ?)");
			ps.setString(1, teacher.getName());
			ps.setString(2,teacher.getEmail());
			ps.executeUpdate();
				
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void updateTeacher(Teacher teacher) {
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
			PreparedStatement ps=connection.prepareStatement("UPDATE Teachers SET name = ?, email = ? WHERE id = ?");
			ps.setString(1,teacher.getName());
			ps.setString(2,teacher.getEmail());
			ps.setInt(3, teacher.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void deleteTeacher(int id) {
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseManagement","root","Dusengimana@123");
			PreparedStatement ps=connection.prepareStatement("DELETE FROM TEACHERS WHERE id = ?");
			 ps.setInt(1, id);
	            ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
