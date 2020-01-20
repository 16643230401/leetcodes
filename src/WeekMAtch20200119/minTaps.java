package WeekMAtch20200119;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>最小水龙头数量</p>
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
        int ans = 0;
        List<Integer> list = new ArrayList<>(ranges.length - 1);
        for (int i = 0; i < ranges.length; i++) {
            list.add(0);
        }
        ans = dynamicProcessing(list, n, ranges, 0);
        return ans;
    }

    public boolean isFull(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        if(sum == list.size()) return true;
        return false;
    }


    public int dynamicProcessing(List<Integer> list, int n, int[] ranges, int minSum) {
        if(isFull(list)) return minSum;
        if(n == 0 ) return -1;
        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);
        for (int i = n - 1; i > 0 && i > n - 1 - ranges[n]; i--) {
            list1.set(i, 1);
        }
        for (int i = n; i < list.size() && i < n + ranges[n]; i++) {
            list1.set(i, 1);
        }
        int a = dynamicProcessing(list2, n - 1, ranges, minSum);
        System.out.println(a);
        int b = dynamicProcessing(list1, n - 1 , ranges, minSum + 1);
        System.out.println(b);
        return Math.min(a,b) == -1 ? Math.max(a,b) : -1;
    }
}
