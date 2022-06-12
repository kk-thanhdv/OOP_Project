package object.pkg;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String user;
	private String pass;
	private String name;
	private List<Course> listCourse;
	public User() {
		listCourse = new ArrayList<Course>();
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getListCourse() {
		return listCourse;
	}
	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	public void addCourse(Course c) {
		listCourse = new ArrayList<Course>(listCourse);
		listCourse.add(c);
	}
	public void setCourse(int i, Course c) {
		listCourse = new ArrayList<Course>(listCourse);
		listCourse.set(i, c);
	}
}
