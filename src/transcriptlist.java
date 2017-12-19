/**
 * class used to retrieve data from the database table "transcript"
 * @author Parisa
 *
 */
public class transcriptlist {

	private String studentId, courseId, courseName, grade, semester;
	private float point;

	public transcriptlist (String studentId, String courseId, String courseName, String grade, float Point, String semester)
	{
		this.studentId = studentId;
		this.courseId = courseId;
		this.courseName = courseName;
		this.grade = grade;
		this.point = point;
		this.semester = semester;

	}

	public String getStudentId() {return studentId; }
	public String getCourseId() {return courseId; }
	public String getCourseName()
	{
		return courseName;
	}
	public String getGrade()
	{
		return grade;
	}
	public float getPoint()
	{
		return point;
	}
	public String getSemester()
	{
		return semester;
	}
}