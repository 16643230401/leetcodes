package WeekMatch20200614;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-14 10:31
 */
public class runningSum {

    public int[] runningSum(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }
}
