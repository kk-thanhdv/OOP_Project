package database.pkg;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import object.pkg.Student;
import object.pkg.Time;
import object.pkg.Course;
import object.pkg.Grade;
import object.pkg.Grade.GradeComponent;
import object.pkg.User;

public class Converter {
	//  list JSON Object
	public static BasicDBList gradeComponentFromArray(List<Grade.GradeComponent> arrayGradeComponent) {
		List<DBObject> listDB = new ArrayList<DBObject>();
		int sz = arrayGradeComponent.size();
		for(int i = 0; i < sz; i++) {
			listDB.add(i, Converter.gradeComponentToDBObject(arrayGradeComponent.get(i)));
		}
		BasicDBList dblist = new BasicDBList();
		dblist.addAll(listDB);
		return dblist;
	}
	public static List<Grade.GradeComponent> toGradeComponentArray(BasicDBList listDB) {
		int sz = listDB.size();
		List<Grade.GradeComponent> arrayGradeComponent = new ArrayList<Grade.GradeComponent>();
		for(int i = 0; i < sz; i++) {
			arrayGradeComponent.add(i, Converter.toGradeComponent((DBObject) listDB.toArray()[i]));
		}
		return arrayGradeComponent;
	}
	public static BasicDBList studentFromArray(List<Student> arrayStudent) {
		List<DBObject> listDB = new ArrayList<DBObject>();
		int sz = arrayStudent.size();
		for(int i = 0; i < sz; i++) {
			listDB.add(i, Converter.studentToDBObject(arrayStudent.get(i)));
		}
		BasicDBList dblist = new BasicDBList();
		dblist.addAll(listDB);
		return dblist;
	}
	public static List<Student> toStudentArray(BasicDBList listDB) {
		int sz = listDB.size();
		List<Student> arrayStudent = new ArrayList<Student>();
		for(int i = 0; i < sz; i++) {
			arrayStudent.add(i, Converter.toStudent((DBObject) listDB.toArray()[i]));
		}
		return arrayStudent;
	}
	
	public static BasicDBList courseFromArray(List<Course> arrayCourse) {
		List<DBObject> listDB = new ArrayList<DBObject>();
		int sz = arrayCourse.size();
		for(int i = 0; i < sz; i++) {
			listDB.add(i, Converter.courseToDBOBject(arrayCourse.get(i)));
		}
		BasicDBList dblist = new BasicDBList();
		dblist.addAll(listDB);
		return dblist;
	}
	public static List<Course> toCourseArray(BasicDBList listDB) {
		List<Course> arrayCourse = new ArrayList<Course>();
		int sz = listDB.size();
		for(int i = 0; i < sz; i++) {
			arrayCourse.add(i, Converter.toCourse((DBObject) listDB.get(i)));
		}
		return arrayCourse;
	}
	
	public static DBObject gradeToDBObject(Grade g) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("grade", gradeComponentFromArray(g.getGrade()))
				.append("finalgrade", g.getFinalGrade())
				.append("gradeletter", g.getGradeLetter());
		return builder.get();
	}
	public static Grade toGrade(DBObject db) {
		Grade g = new Grade();
		g.setGrade(toGradeComponentArray((BasicDBList) db.get("grade")));
		g.setFinalGrade((double) db.get("finalgrade"));
		g.setGradeLetter((String) db.get("gradeletter"));
		return g;
	}
	
	public static DBObject gradeComponentToDBObject(Grade.GradeComponent gc) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("title", gc.getTitle())
				.append("grade", gc.getGrade())
				.append("maxgrade", gc.getMaxGrade())
				.append("scale", gc.getScale());
		return builder.get();
	}
	public static GradeComponent toGradeComponent(DBObject doc) {
		Grade g = new Grade();	
		Grade.GradeComponent gc = g.new GradeComponent();
		gc.setTitle((String) doc.get("title"));
		gc.setGrade((double) doc.get("grade"));
		gc.setMaxGrade((double) doc.get("maxgrade"));
		gc.setScale((double) doc.get("scale"));
		return gc;
	}
	
	public static DBObject userToDBObject(User u) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("user", u.getUser())
				.append("pass", u.getPass())
				.append("name", u.getName())
				.append("listcourse", courseFromArray(u.getListCourse()));
		return builder.get();
	}
	public static User toUser(DBObject db) {
		User u = new User();
		u.setUser((String) db.get("user"));
		u.setPass((String) db.get("pass"));
		u.setName((String) db.get("name"));
		u.setListCourse(toCourseArray((BasicDBList) db.get("listcourse")));
		return u;
	}
		
	public static DBObject timeToDBObject(Time t) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("day", t.getDay())
				.append("starthour", t.getStartHour())
				.append("startmin", t.getStartMin())
				.append("endhour", t.getEndHour())
				.append("endmin", t.getEndMin());
		return builder.get();
	}
	@SuppressWarnings("unchecked")
	public static Time toTime(DBObject db) {
		Time t = new Time();
		t.setDay((List<Integer>) db.get("day"));
		t.setStartHour((int) db.get("starthour"));
		t.setStartMin((int) db.get("startmin"));
		t.setEndHour((int) db.get("endhour"));
		t.setEndMin((int) db.get("endmin"));
		return t;
	}

	public static DBObject studentToDBObject(Student s) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", s.getName())
				.append("id", s.getId())
				.append("phone", s.getPhone())
				.append("major", s.getMajor())
				.append("grade", gradeToDBObject(s.getGrade()));
		return builder.get();
	}
	public static Student toStudent(DBObject db) {
		Student s = new Student();
		s.setName((String) db.get("name"));
		s.setId((String) db.get("id"));
		s.setPhone((String) db.get("phone"));
		s.setMajor((String) db.get("major"));
		s.setGrade((Grade) Converter.toGrade((DBObject) db.get("grade")));
		return s;
	}

	public static DBObject courseToDBOBject(Course c) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("credit", c.getCredit())
				.append("coursecode", c.getCourseCode())
				.append("coursename", c.getCourseName())
				.append("description", c.getDescription())
				.append("student", Converter.studentFromArray(c.getStudent()));
		return builder.get();
	}
	public static Course toCourse(DBObject db) {
		Course c = new Course();
		c.setCredit((double) db.get("credit"));
		c.setCourseCode((String) db.get("coursecode"));
		c.setCourseName((String) db.get("coursename"));
		c.setDescription((String) db.get("description"));
		c.setStudent(toStudentArray((BasicDBList) db.get("student")));
		return c;
	}
}
