package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-06 21:11
 */
public class moveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) return;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeroCount += 1;
            else if(zeroCount > 0) {
                nums[i - zeroCount] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
