package series;

/**
 * Created by Helga on 11/13/2017.
 */
public class Exponential extends Series {
    public Exponential(int first, int delimeter, int amount){

        this.amount = amount;
        this.first = first;
        this.delimeter = delimeter;
    }
    @Override
    public int calculate(int index) {
        int result=first;
        for(int i=1;i<index;i++){
            result*=delimeter;
        }
        return result;
    }
}
