package WeekMatch20200405;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-05 10:36
 */
public class minSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        if(nums.length == 0) return null;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sum2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            sum2 += nums[i];
            list.add(nums[i]);
            if(sum2 > sum / 2) break;
        }


        return list;

    }
}
