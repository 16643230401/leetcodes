package mianshi;


/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-06 21:00
 */
public class plusOne {

    public int[] plusOne(int[] digits) {
        int cur = 1;
        for (int length = digits.length - 1; length >= 0; length--) {
            if(cur == 0) break;
            digits[length] += cur;
            cur = 0;
            if(digits[length] > 9) {
                digits[length] = 0;
                cur = 1;
            }

        }

        if(cur == 1) {
            int [] ans = new int[digits.length + 1];
            ans[0] = 1;


            //加上这个for显得格外沙雕
//            for (int i = 0; i < digits.length; i++) {
//                ans[i + 1] = digits[i];
//            }

            return ans;
        }

        return  digits;


    }
}
