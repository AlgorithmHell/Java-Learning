import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Helga on 11/22/2017.
 */
public class ReverseInteger {

    public int reverse(int x) {
        long res = 0;
        boolean isNegative = false;
        if (x < 0) {
            x = -1 * x;
            isNegative = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        while(x!=0){
            queue.add(x % 10);
            x = x / 10;
        }
        while(!queue.isEmpty()){
            res = res + queue.remove() * (long)Math.pow(10 , queue.size());
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }



        return (int) (isNegative ? -1 * res : res);
    }
}
