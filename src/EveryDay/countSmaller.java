package EveryDay;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-11 20:50
 */
public class countSmaller {

    public static void main(String[] args) {
        countSmaller c = new countSmaller();
        int[] a = new int[]{-1,-1};
        System.out.println(c.countSmaller(a));
    }
    Map<Integer, Integer> map = new HashMap<>();
    int[] c;

    public void init(int[] nums) {
        int[] num2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(num2);
        int j = 2;
        map.put(num2[0], 1);
        for (int i = 1; i < num2.length; i++) {
            if(num2[i] == num2[i - 1]) continue;

            map.put(num2[i], j++);
        }
        c = new int[map.size() + 1];

    }


    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) return new LinkedList<>();
        init(nums);
        List<Integer> ans = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            update(nums[i], 1);
            ans.add(0, getSum(nums[i]));
        }
        return ans;
    }


    public int lowbit(int x) {
        return x & (-x);
    }


    public void update(int k, int val){
        int n = c.length;
        //角标
        int cur = map.get(k);
        //更新
        for (int i = cur; i < n; i += lowbit(i)) {
            c[i] += val;
        }
    }

    public int getSum(int k) {
        //角标
        int cur = map.get(k) - 1;
        if(cur <= 0) return 0;

        int sum = 0;

        System.out.println();
        for (int i = cur; i > 0; i -= lowbit(i)) {
            sum += c[i];
        }
        return sum;
    }


}
