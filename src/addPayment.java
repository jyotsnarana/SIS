/**
 * @author Parisanikzad
 */
public class addPayment {
    private String studentId;
    private float paid, debt;

    public addPayment(String studentId, float paid){

        this.studentId = studentId;
        this.paid=paid;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public float getPaid()
    {
        return paid;
    }

}
