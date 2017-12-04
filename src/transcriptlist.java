/**
 * class used to retrieve data from the database table "transcript"
 * @author jyotsna
 *
 */
public class transcriptlist {
	
private String term, course, description, grade, GPA, term_GPA;

	public transcriptlist(String term, String course, String description, String grade, String GPA, String term_GPA)
	{
		this.term=term;
		this.course=course;
		this.description=description;
		this.grade=grade;
		this.GPA=GPA;
		this.term_GPA=term_GPA;
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
	public String getterm_GPA()
	{
		return term_GPA;
	}





}