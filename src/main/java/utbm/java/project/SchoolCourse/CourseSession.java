package utbm.java.project.SchoolCourse;

import java.util.Date;

public class CourseSession {

	private int id;

	private Date start;

	private Date end;

	private String course_code;
	
	private int location_id;
	
	public CourseSession() {
		
	}
	
	public CourseSession(int id, Date start, Date end, String course_code, int location_id) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.course_code = course_code;
		this.location_id = location_id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	
}
