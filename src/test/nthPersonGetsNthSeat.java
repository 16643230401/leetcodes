package test;

import java.math.BigDecimal;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-01-06 21:16
 */
public class nthPersonGetsNthSeat {

    //P(n) = P(n - 1) + (1 - P(n - 1)) * 1/2;
    //     = 1/2 + 1/2 * P(n - 1)

    //P(n - 1) = P(n - 2) + (1 - P(n - 2)) * 1/3;
    //         = 1/3 + 2/3 * P(n - 2);

    //P(n - i) = 1/(i + 2) + (i + 1)/(i + 2) * P(n - i - 1);
    //if (n - i) < 2 : P(n - i) = 1 / n - i;

    public static void main(String[] args) {
        nthPersonGetsNthSeat nthPersonGetsNthSeat = new nthPersonGetsNthSeat();
        System.out.println(nthPersonGetsNthSeat.nthPersonGetsNthSeat(3));
    }

    public double nthPersonGetsNthSeat(int n) {
        return p(n,0);
    }

    public double p(double n, double i) {
        if(n - i <= 2) return (double)1 / n - i;

        return 1/(i + 2) + (i + 1)/(i + 2) * p(n, i + 1);
    }
}
