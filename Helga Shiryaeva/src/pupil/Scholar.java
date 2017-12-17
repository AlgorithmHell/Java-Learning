package pupil;

/**
 * Created by Helga on 12/3/2017.
 */
public class Scholar extends Pupil {

    private int grade;

    private int behaviour;

    public Scholar(String surname, String school, double score, int grade, int behaviour) {
       super(surname,school,score);

       this.grade = grade;
       this.behaviour = behaviour;
    }

    public int getGrade() {
        return grade;
    }

    public int getBehaviour() {
        return behaviour;
    }

    @Override
    public String toString() {
        return super.toString()+" Grade : "+grade+" Behaviour: "+behaviour;
    }
}
