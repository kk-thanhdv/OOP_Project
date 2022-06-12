package object.pkg;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private double credit;
	private String courseCode;
	private String courseName;
	private String description;
	private List<Student> student;
	private Time time;
	public void addStudent(Student s) {
		student = new ArrayList<Student>(student);
		student.add(s);
	}
	public void setStudent(int id, Student s) {
		student = new ArrayList<Student>(student);
		student.set(id, s);
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
}
