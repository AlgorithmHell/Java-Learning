import java.util.Scanner;

/**
 * Created by Helga on 11/25/2017.
 */
public class IfAPowerOfTwo {
    public boolean isAPowerOfTwo(int a) {
        if(a <= 0) return false;
        if(a == 1) return true;
        if(a % 2 == 1) return false;

        isAPowerOfTwo(a / 2);

        return true;
    }

    public boolean isAPowerOfTwoConstantTime(int a) {

        return (a >= 1)&&((a&(~a + 1)) == a);
    }

}
