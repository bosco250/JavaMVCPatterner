package Model;

public class Course {
	private int id;
    private String name;
    private int teacherId;
//	public Course(int id, String name, int teacherId) {
//		this.id=id;
//		this.name=name;
//		this.teacherId=teacherId;
//		
//	}
	public void setId( int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name; 
	}
	public void setTeacherId(int teacherId) {
		this.teacherId=teacherId;
	}
	public int getTeacherId() {
		return teacherId;
	}

}
