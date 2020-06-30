package EveryDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-30 21:17
 */
public class lengthOfLIS {

    /**
     *  Re:C
     */


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < dp.length; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[dp.length - 1];
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < list.get(0)) {
                list.set(0, nums[i]);
            }else if(nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                findAndSwap(list, nums[i]);
            }
        }

        return list.size();
    }


    public void findAndSwap(List<Integer> list, int k) {

        int left = 0;
        int right = list.size() - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if(k > list.get(mid)) left = mid + 1;
            else if (k < list.get(mid)) right = mid;
            else return;
        }
        list.set(left, k);
    }


}
