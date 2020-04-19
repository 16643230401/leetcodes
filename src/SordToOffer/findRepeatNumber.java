package SordToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 03
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-24 21:20
 */
public class findRepeatNumber {

    public static void main(String[] args) {


    }

    public int findRepeatNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }

        return -1;
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i == nums[i]) {
                i ++;
                continue;
            }

            if(nums[nums[i]] == nums[i]) return nums[i];

            nums[nums[i]] = nums[i++];
        }

        return -1;
    }
}
