package pupil;

/**
 * Created by Helga on 12/3/2017.
 */
public class Student extends Pupil {

    private int course;

    public Student(String surname, String school, double score, int course) {
        super(surname, school, score);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return super.toString()+" Course : "+course;
    }
}
