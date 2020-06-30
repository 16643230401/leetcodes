package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-27 21:26
 */
public class trap {

    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = height.length - 1;
        int left = 1;
        int right = height.length - 2;

        int ans = 0;
        while (left < right) {
            while(left < right && height[leftMax] <= height[rightMax]) {
                if(height[left] <= height[leftMax]) {
                    ans += height[leftMax] - height[left];
                    left ++;
                } else {
                    leftMax = left;
                }
            }

            while(left < right && height[leftMax] > height[rightMax]) {
                if(height[right] <= height[rightMax]) {
                    ans += height[rightMax] - height[right];
                    right --;
                } else {
                    rightMax = right;
                }
            }
        }

        return ans;

    }
}
