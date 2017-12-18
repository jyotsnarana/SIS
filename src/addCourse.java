/**
 * class used to extract contents from the database table "addcourse"
 * @author jyotsna
 *
 */
public class addCourse {
	private String courseId, courseName, semester, professor, time, room, capacity;
	
	public addCourse(String courseId, String courseName, String semester, String professor, String time, String room, String capacity)
	{

		this.courseId = courseId;
		this.courseName = courseName;
		this.semester = semester;
		this.professor=professor;
		this.time=time;
		this.room=room;
		this.capacity=capacity;



	}
	public String getCourseId()
	{
		return courseId;
	}
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
