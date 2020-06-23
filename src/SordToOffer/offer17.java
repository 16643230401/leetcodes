package SordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-07 20:08
 */
public class offer17 {

    public int[] printNumbers(int n) {
        int[] arr = new int[(int)Math.pow(10, n)];
        for (int i = 0; i < (int) Math.pow(10, n); i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
