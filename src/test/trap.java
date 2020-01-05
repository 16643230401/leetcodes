package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-01-03 21:12
 */
public class trap {

    /**
     * 接雨水
     * @param args
     */
    public static void main(String[] args) {

        trap t = new trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(height));

    }


    /**
     * 超时的算法
     *
     * @param height
     * @return
     */
    public int trap_overTime(int[] height) {
        int temp = 0;
        int len = height.length;
        int ans = 0;
        int tempAns = 0;

        while (true) {
            temp = 0;
            tempAns = 0;
            while (temp < len && height[temp] == 0) {
                if (height[temp] > 0) height[temp]--;
                temp++;
            }
            if (temp == len) break;
            if (height[temp] > 0) height[temp]--;
            temp++;
            while (temp < len) {
                if (height[temp] == 0) {
                    tempAns++;
                } else {
                    ans += tempAns;
                    tempAns = 0;
                }
                if (height[temp] > 0) height[temp]--;
                temp++;
            }
        }
        return ans;
    }


    /**
     * 双指针解法
     * @param height
     */
    public int trap (int[] height) {
        int left = 0;
        while (height[left] == 0) left ++;
        int right = height.length - 1;
        while (height[right] == 0) right --;
        int maxOfLeft = left;
        int maxOfRight = right;
        int ans = 0;
         while (left < right) {
             if(height[maxOfLeft] <= height[maxOfRight]) {
                 left ++;
                 if(height[left] > height[maxOfLeft]) {
                     maxOfLeft = left;
                 } else {
                     ans += height[maxOfLeft] - height[left];
                 }
             } else {
                 right --;
                 if(height[right] > height[maxOfRight]) {
                     maxOfRight = right;
                 } else {
                     ans += height[maxOfRight] - height[right];
                 }
             }
         }

         return ans;
    }
}
