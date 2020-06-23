package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-03 18:08
 */
public class removeDuplicates {

    public int removeDuplicates(int[] nums) {
        int ele = nums[0];
        int whiteLen = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != ele) {
                ele = nums[i];
                nums[i - whiteLen] = nums[i];
            } else {
                whiteLen += 1;
            }
        }
        return nums.length - whiteLen;
    }

}
