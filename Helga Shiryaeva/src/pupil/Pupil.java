package pupil;

/**
 * Created by Helga on 12/3/2017.
 */
public abstract class Pupil {

    protected String surname;

    protected String school;

    protected double score;

    public Pupil(String surname, String school, double score) {

        this.surname = surname;
        this.school = school;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public String getSchool() {
        return school;
    }

    public double getScore() {
        return score;
    }

    public  String toString() {
      return "Surname : "+surname+" School : "+school+" Score : "+score;
    }
}
