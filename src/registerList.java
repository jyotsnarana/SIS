/**
 * class used to retrieve the contents of "register_student" database.
 * @author jyotsna
 *
 */
public class registerList {
	private String courseId, courseName, semester, professor, time, room, capacity;

	public registerList (String courseId, String courseName, String semester, String professor, String time, String room, String capacity)
	{
		this.courseId = courseId;
		this.courseName = courseName;
		this.semester = semester;
		this.professor=professor;
		this.time=time;
		this.room=room;
		this.capacity=capacity;
	}

	public String getCourseId() {return courseId; }
	public String getCourseName()
	{
		return courseName;
	}
	public String getSemester()
	{
		return semester;
	}
	public String getProfessor()
	{
		return professor;
	}
	public String getTime()
	{
		return time;
	}
	public String getRoom()
	{
		return room;
	}
	public String getCapacity()
	{
		return capacity;
	}
}
