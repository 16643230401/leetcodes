package mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-23 22:30
 */
public class majorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], 1);
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if(map.get(nums[i]) > nums.length / 2) return nums[i];
            }
        }

        return -1;
    }

    /**
     *Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if(nums.length == 0) return -1;
        int vote = 0;
        int candidate =  nums[0];
        for (int num : nums) {
            if(vote == 0) candidate = num;
            if(num == candidate) vote += 1;
            else vote -= 1;
        }
        return candidate;
    }
}
