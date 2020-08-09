package EveryDay;

import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-01 17:41
 */
public class smallestRange {


    /**
     * 多指针，可以用堆进行优化
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] pointerArr = new int[k];
        int[] ans = new int[2];
        ans[0] = nums.get(0).get(0);
        ans[1] = ans[0];
        int minIndex = 0;
        int minval = 0;
        int maxval = 0;
        for (int i = 1; i < k; i++) {
            if(ans[0] > nums.get(i).get(0)){
                minIndex = i;
                ans[0] = nums.get(i).get(0);
            }
            ans[1] = Math.max(nums.get(i).get(0), ans[1]);
        }
        minval = ans[0];
        maxval = ans[1];
        while (true) {
            if(pointerArr[minIndex] == nums.get(minIndex).size() - 1) break;
            pointerArr[minIndex] += 1;
            maxval = Math.max(nums.get(minIndex).get(pointerArr[minIndex]), minval);
            minval = nums.get(minIndex).get(pointerArr[minIndex]);
            for (int i = 0; i < k; i++) {
                if(nums.get(i).get(pointerArr[i]) < minval) {
                    minIndex = i;
                    minval = nums.get(i).get(pointerArr[i]);
                }
            }
            if(maxval - minval < ans[1] - ans[0]) {
                ans[0] = minval;
                ans[1] = maxval;
            }

        }

        return ans;
    }
}
