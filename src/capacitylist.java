/**
 * class to extract the contents of database table "capacity" to be shown in weekly schedule used for professor
 * @author jyotsna
 *
 */
public class capacitylist {
	private String course, description, schedule, time, room, capacity;

	public capacitylist(String course, String description, String schedule, String time, String room, String capacity)
	{
		this.course=course;
		this.description=description;
		this.schedule=schedule;
		this.time=time;
		this.room=room;
		this.capacity=capacity;
	}

	public String getcourse()
	{
		return course;
	}
	public String getdescription()
	{
		return description;
	}
	public String getschedule()
	{
		return schedule;
	}
	public String gettime()
	{
		return time;
	}
	public String getroom()
	{
		return room;
	}
	public String getcapacity()
	{
		return capacity;
	}



}
