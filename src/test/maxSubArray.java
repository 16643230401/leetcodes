package test;

/**
 * <p>53.最大子序和</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-22
 * @Version : v1.0
 */
public class maxSubArray {
    public static void main(String[] args) {
        maxSubArray maxSubArray = new maxSubArray();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(arr));
    }

    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int ans = 0;
        int a = nums[0];
        int b = a;
        ans = a;
        for (int j = 1; j < nums.length; j++) {
            a += nums[j];
            b = a;
            ans = Math.max(ans, a);
            for (int i = 1; i <= j; i++) {
                b -= nums[i - 1];
                ans = Math.max(ans, b);
            }
        }

        return ans;
    }

//    public int maxSubArray2(int[] nums) {
//
//    }
}
