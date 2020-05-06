package mianshi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-23 21:53
 */
public class singleNumber {

    public static void main(String[] args) {
        singleNumber singleNumber = new singleNumber();
        int[] arr = {2, 2, 1};
        System.out.println(singleNumber.singleNumber(arr));
    }
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) set.add(nums[i]);
            else set.remove(nums[i]);
        }

        return new ArrayList<>(set).get(0);

    }

    /**
     * 最优解
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
