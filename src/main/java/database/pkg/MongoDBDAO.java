package database.pkg;
import java.util.Collections;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import object.pkg.Course;
import object.pkg.User;

public class MongoDBDAO {
	private DBCollection col;
	public MongoDBDAO(MongoClient mongo) {
		this.col = mongo.getDB("oop_project").getCollection("user");
	}
	public void createUser(String name, String username, String password) {
		User u = new User();
		System.out.println(username + " " + password + " " + name);
		u.setUser(username);
		u.setPass(password);
		u.setName(name);
		u.setListCourse(Collections.<Course>emptyList());
		System.out.println(u.getUser());
		DBObject db = Converter.userToDBObject(u);
		this.col.insert(db);
	}
	public User queryUser(String username) {
		DBObject query = BasicDBObjectBuilder.start().append("user", username).get();
		DBObject user = this.col.findOne(query);
		if(user == null) return null;
		System.out.println(user);
		return Converter.toUser(user);
	}
	public void modifyUser(String username, User u) {
		DBObject query = BasicDBObjectBuilder.start().append("user", username).get();
		DBObject user = this.col.findOne(query);
		this.col.update(user, Converter.userToDBObject(u));
	}
}
