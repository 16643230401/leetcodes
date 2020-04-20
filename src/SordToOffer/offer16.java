package SordToOffer;

import sun.awt.image.IntegerComponentRaster;

import java.util.function.DoubleBinaryOperator;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-06 20:35
 */
public class offer16 {

    public static void main(String[] args) {
        offer16 offer16 = new offer16();
//        System.out.println(offer16.myPow(10, Integer.MIN_VALUE));
        long b = -Integer.MIN_VALUE;
        System.out.println(b / 2);
    }
    public double myPow(double x, int n) {

        if(n == 0) return 1;
        if(n == 1) return x;
        int sign = 0;
        if(n < 0) {
            if(n == Integer.MIN_VALUE && Math.abs(x) > 1) {
                return 0.00;
            } else if(n == Integer.MIN_VALUE && Math.abs(x) < 1){
                return Double.POSITIVE_INFINITY;
            } else if(n == Integer.MIN_VALUE && Math.abs(x) == 1){
                return 1;
            }
            n = -n;
            sign = 1;
        }
//        System.out.println(b);

        double res = myPow(x, n >> 1);

        double val = res * res;


        if((n & 1) == 0) {
            if(sign == 1) {
                return 1 / val;
            }
            return val;
        }


        if(sign == 1) {
            return 1 / (val * x);
        }
        return val * x;
    }
}
