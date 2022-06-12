package object.pkg;

import java.util.ArrayList;
import java.util.List;

public class Grade {
	public class GradeComponent {
		private int id;
		private String title;
		private double grade;
		private double maxGrade;
		private double scale;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public GradeComponent() {
			
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getGrade() {
			return grade;
		}
		public void setGrade(double d) {
			this.grade = d;
		}
		public double getMaxGrade() {
			return maxGrade;
		}
		public void setMaxGrade(double maxGrade) {
			this.maxGrade = maxGrade;
		}
		public double getScale() {
			return scale;
		}
		public void setScale(double scale) {
			this.scale = scale;
		}
	}
	
	private List<GradeComponent> grade;
	private double finalGrade;
	private String gradeLetter;
	
	public Grade() {
		grade = new ArrayList<GradeComponent>();
		finalGrade = -1;
		gradeLetter = "?";
	}
	
	public void addGrade(GradeComponent gc) {
		grade = new ArrayList<GradeComponent>(grade);
		grade.add(gc);
	}
	
	public void setGrade(int i, GradeComponent gc) {
		grade.set(i, gc);
	}

	public List<GradeComponent> getGrade() {
		return grade;
	}

	public void setGrade(List<GradeComponent> grade) {
		this.grade = grade;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double d) {
		this.finalGrade = d;
	}

	public String getGradeLetter() {
		return gradeLetter;
	}

	public void setGradeLetter(String gradeLetter) {
		this.gradeLetter = gradeLetter;
	}
	
	public double calculateGrade() {
		double totalPercent = 0;
		for(GradeComponent gc: grade) {
			totalPercent += gc.getScale();
		}
		if(totalPercent == 100) {
			double sum = 0;
			for(GradeComponent i: grade) {
				sum += i.getGrade() / i.getMaxGrade() * i.getScale();
			}
			return sum;
		}
		return -1;
	}
	
	public String calculateLetter() {
		double grade = calculateGrade();
		if(grade == -1) return "?";
		if(grade > 90) return "A";
		else if(grade > 85) return "A-";
		else if(grade > 80) return "B+";
		else if(grade > 75) return "B";
		else if(grade > 70) return "B-";
		else if(grade > 65) return "C+";
		else if(grade > 60) return "C";
		else if(grade > 55) return "C-";
		else if(grade > 50) return "D";
		return "F";
	}
}
