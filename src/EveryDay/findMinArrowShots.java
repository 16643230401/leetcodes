package EveryDay;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 11/23/20 10:28 PM
 *
 * 452 气球
 */
public class findMinArrowShots {

    public static void main(String[] args) {
        Integer[] arr = {1000, -2147483645};

        Arrays.sort(arr, (o1, o2)->{
            return o1 - o2;
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }



    }


    public static int findMinArrowShots(int[][] p) {
        int l = Integer.MIN_VALUE;
        int ans = 0;
        Arrays.sort(p, (o1, o2)->Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1])));

        for(int i = 0; i < p.length; i++) {
            if(p[i][0] != Integer.MIN_VALUE && p[i][0] <= l) continue;
            l = p[i][1];
            ans ++;
        }

        return ans;
    }
}
