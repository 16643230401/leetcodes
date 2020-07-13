package EveryDay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-08 20:54
 */
public class divingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if(shorter == longer) return new int[]{shorter * k};
        if(k == 0) return new int[0];
        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i] = (k - i) * shorter + i * longer;
        }

        return ans;
    }
}
