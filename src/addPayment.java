/**
 * @author Parisanikzad
 */
public class addPayment {
    private String studentId;
    private float paid, debt;

        public addPayment(String studentId, float debt, float paid){

        this.studentId = studentId;
        this.paid=paid;
        this.debt=debt;

    }
    public String getStudentId()
    {
        return studentId;
    }
    public float getDebt()
    {
        return debt;
    }
    public float getPaid()
    {
        return paid;
    }

}
