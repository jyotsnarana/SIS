/**
 * @author Parisanikzad
 */
public class addTuition {
    private String semester, due;
    private float tuition, paid, debt;

//    public addTuition(String semester, String due, float tuition, float debt, float paid)
    public addTuition(String semester, float tuition)
    {

        this.semester = semester;
        this.tuition = tuition;
//        this.due = due;
//        this.paid=paid;
//        this.debt=debt;

    }
    public String getSemester()
    {
        return semester;
    }
//    public String getDue()
//    {
//        return due;
//    }
    public float getTuition()
    {
        return tuition;
    }
//    public float getDebt()
//    {
//        return debt;
//    }
//    public float getPaid()
//    {
//        return paid;
//    }


}
