
public class registerList {
	private String term, course, description, professor, start_date, end_date, start_time, end_time, vacancy;

	public registerList (String term, String course, String description, String professor, String start_date, String end_date, String start_time, String end_time, String vacancy )
	{
		this.term=term;
		this.course=course;
		this.description=description;
		this.start_date=start_date;
		this.end_date=end_date;
		this.start_time=start_time;
		this.end_time=end_time;
		this.vacancy=vacancy;
		this.professor=professor;
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
	public String getprofessor()
	{
		return professor;
	}
	public String getstartdate()
	{
		return start_date;
	}
	public String getenddate()
	{
		return end_date;
	}
	public String getstarttime()
	{
		return start_time;
	}
	public String getendtime()
	{
		return end_time;
	}
	public String getvacancy()
	{
		return vacancy;
	}
}
