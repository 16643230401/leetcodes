package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-27 12:21
 */
public class firstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return i + 1;
        }


        return nums.length + 1;
    }
}
