
public class transcriptlist {
	
private String term, course, description, grade, GPA, grade_Points;

	public transcriptlist(String term, String course, String description, String grade, String GPA, String grade_Points)
	{
		this.term=term;
		this.course=course;
		this.description=description;
		this.grade=grade;
		this.GPA=GPA;
		this.grade_Points=grade_Points;
	}
	public String getterm()
	{
		return term;
	}
	public String getcourse()
	{
		return course;
	}
	public String getdescription()
	{
		return description;
	}
	public String getgrade()
	{
		return grade;
	}
	public String getGPA()
	{
		return GPA;
	}
	public String getgrade_Points()
	{
		return grade_Points;
	}





}