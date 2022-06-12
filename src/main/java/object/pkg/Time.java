package object.pkg;

import java.util.List;

public class Time {
	private List<Integer> day;
	private int startHour;
	private int startMin;
	private int endHour;
	private int endMin;
	public List<Integer> getDay() {
		return day;
	}
	public void setDay(List<Integer> day) {
		this.day = day;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMin() {
		return startMin;
	}
	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMin() {
		return endMin;
	}
	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}
	
}
