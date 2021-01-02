package laterWMS.WeekMatch20200705;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-05 10:42
 */
public class canMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int div = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] != div) return false;
        }

        return true;
    }
}
