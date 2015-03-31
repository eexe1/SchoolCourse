package utbm.java.project.SchoolCourse;

import java.util.HashSet;
import java.util.Set;

public class Course {

	private String code;

	private String title;

	private Set<CourseSession> CourseSessionRecords = 
			new HashSet<CourseSession>(0);
	
	public Set<CourseSession> getCourseSessionRecords() {
		return CourseSessionRecords;
	}

	public void setCourseSessionRecords(Set<CourseSession> courseSessionRecords) {
		CourseSessionRecords = courseSessionRecords;
	}

	public Course() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Course(String code, String title	) {
		this.code = code;
		this.title = title;
	}
	
}


