package utbm.java.project.SchoolCourse;

public class Course {

	private String code;

	private String title;

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


