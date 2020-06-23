package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-30 20:15
 */
public class reverseInt {

    public int reverse(int x) {


        int ans = 0;
        int temp = 0;

        while (x != 0) {
            temp = x % 10;
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7)) return 0;
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && temp < -8)) return 0;
            ans = ans * 10 + temp;
            x = x / 10;
        }


        return ans;

    }
}