package WeekMatch20200531;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-31 10:39
 */
public class maxProduct {
    public int maxProduct(int[] nums) {
        if(nums.length == 2) return (nums[0] - 1) * (nums[1] - 1);
        int Max1 = nums[0];
        int Max2 = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > Max1) {
                Max2 = Max1;
                Max1 = nums[i];
            } else if(nums[i] > Max2){
                Max2 = nums[i];
            }
        }

        return (Max1  - 1 )* (Max2 - 1);
    }
}
