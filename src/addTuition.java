/**
 * @author Parisanikzad
 */
public class addTuition {
    private String semester, due;
    private float tuition, paid, debt;


    public addTuition(String semester, float tuition)
    {

        this.semester = semester;
        this.tuition = tuition;

    }
    public String getSemester()
    {
        return semester;
    }

    public float getTuition()
    {
        return tuition;
    }



}
