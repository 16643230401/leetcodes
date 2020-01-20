package WeekMAtch20200119;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * <p>1326. 灌溉花园的最少水龙头数目</p>
 *
 * 贪心算法
 *
 * @Author : bairuoyu
 * @Date : 2020-01-19
 * @Version : v1.0
 */
public class minTaps {
    public static void main(String[] args) {
        minTaps minTaps = new minTaps();
        int[] ranges = {1,2,1,0,2,1,0,1};
        System.out.println(minTaps.minTaps(7, ranges));
    }

    public int minTaps(int n, int[] ranges) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ranges.length - 1; i++) {
            list.add(0);
        }
        for (int i = 0; i < ranges.length; i++) {
            int leftBound = Math.max(0, i - ranges[i]);
            int rightBound = Math.min(n - 1, i + ranges[i] - 1);
            for (int j = leftBound; j <= rightBound; j++) {
                list.set(j, Math.max(rightBound,list.get(i)));
            }
        }

        int ans = 0;
        int temp = 0;
        while (temp < n) {
            if(list.get(temp) == 0) return -1;
            temp = list.get(temp) + 1;
            ans += 1;
        }

        return ans;
    }

}
