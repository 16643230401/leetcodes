package WeekMatches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-11-08 11:50
 */
public class WeekMatch20201108 {

    public static void main(String[] args) {
        int[] a = {1000000000};
        System.out.println(maxProfit(a, 1000000000));

    }

    public static int maxProfit(int[] a, int o) {
        Arrays.sort(a);
        int len = a.length;
        int nowSum = 1;
        int point= len - 1;
        int ans = 0;
        int mod = 1000000007;
        while(point >= 0) {
            //当前并排的长度
            while((point > 0 && a[point - 1] == a[point])) {
                nowSum ++;
                point --;
            }
            if(point < 0) point ++;

            while((point == 0 || (point > 0 && a[point] > a[point - 1])) && a[point] >= 0) {
                if(nowSum > o) {
                    ans = (ans + o * a[point]) % mod;
                    return ans;
                } else {
                    ans = (ans + nowSum * a[point]) % mod;
                    o-=nowSum;
                }
                a[point]--;
            }
        }
        return ans;
    }
}
