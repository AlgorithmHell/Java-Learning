/**
 * Created by Helga on 11/26/2017.
 */
public class DivideWithoutDividing {

        public int divide(int dividend, int divisor) {
            if(divisor == 0) return Integer.MAX_VALUE;
            boolean isNegative = false;
            if(divisor < 0) {
                isNegative = !isNegative;
                divisor = -1 * divisor;
            }
            if (dividend < 0) {
                isNegative = !isNegative;
                dividend = -1 * dividend;
            }

            int result = 0 ;
            int savedDivisor = divisor;
            while(divisor <= dividend) {
                divisor = divisor + savedDivisor ;
                result++;
            }
            return isNegative ? -1 * result : result ;
        }

}
