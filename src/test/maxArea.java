package test;

/**
 * <p>盛水最多的容器</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-11
 * @Version : v1.0
 */
public class maxArea {
    public static void main(String[] args) {
        maxArea maxArea = new maxArea();
        System.out.println(maxArea.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        if(height.length < 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int tempSum = 0;

        while (left < right) {
            tempSum = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, tempSum);
            if(height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return ans;
    }
}
