package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-28 20:15
 */
public class minSubArrayLen {

    public static void main(String[] args) {
        minSubArrayLen minSubArrayLen = new minSubArrayLen();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0 || s == 0) return 0;
        int left = 0;
        int right = 0;
        int windoeCount = nums[0];
        int ans = nums.length + 1;
        while (right < nums.length) {
            while (windoeCount < s) {
                right ++;
                if(right < nums.length)
                    windoeCount += nums[right];
                else break;
            }
            while (windoeCount >= s) {
                ans = Math.min(ans, right - left + 1);
                if(left <= right)
                    windoeCount -= nums[left];
                left++;
            }
        }

        return ans > nums.length ? 0 : ans;

    }
}



