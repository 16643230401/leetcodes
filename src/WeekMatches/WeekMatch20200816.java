package WeekMatches;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-16 10:26
 */
public class WeekMatch20200816 {

    public boolean threeConsecutiveOdds(int[] arr) {
        return false;
    }

    public int minOperations(int n) {

        return 0;
    }


    //dp[n] =
    //1.dp[n - 1] + 1;
    //2.dp[n / 2] + 1;
    //3.dp[n / 3] + 1;
    public int minDays_OOM(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n <= 3) return 2;
        int[] dp = new int[n + 1];
        int ans = 0;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            if(i % 2 == 0 && i % 3 == 0) {
                ans = Math.min(ans + 1, Math.min(dp[i / 2] + 1, dp[i / 3] + 1));
            } else if(i % 2 == 0) {
                ans = Math.min(ans + 1, dp[i / 2] + 1);
            } else if(i % 3 == 0) {
                ans = Math.min(ans + 1, dp[i / 3] + 1);
            } else {
                ans = ans + 1;
            }
            if(i < dp.length)
                dp[i] = ans;
        }
        return ans;
    }


    Map<Integer, Integer> map = new HashMap<>();
    public int minDays_SOF(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n <  4) return 2;
        int ans = 0;
        if(map.containsKey(n)) return map.get(n);

        if(n % 2 == 0 && n % 3 == 0) {
            ans = Math.min(minDays_SOF(n - 1) + 1, Math.min(minDays_SOF(n / 2) + 1, minDays_SOF(n / 3) + 1));
        } else if(n % 2 == 0) {
            ans = Math.min(minDays_SOF(n - 1) + 1, minDays_SOF(n / 2) + 1);
        } else if(n % 3 == 0) {
            ans = Math.min(minDays_SOF(n - 1) + 1, minDays_SOF(n / 3) + 1);
        } else {
            ans = minDays_SOF(n - 1);
        }

        map.put(n, ans);

        return map.get(n);
    }


    public int minDays(int n) {


        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n <  4) return 2;
        int ans = 0;
        if(map.containsKey(n)) return map.get(n);

        ans = Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);

        map.put(n, ans);

        return map.get(n);

    }



    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int min = 1;
        int max = (position[len - 1] + position[0]) / (m - 1);

        while(min < max) {
            int mid = (min + max) / 2;
            int count = 0;
            int sum = 0;
            for (int i = 1; i < len; i++) {
                sum += position[i] - position[i - 1];
                if(sum >= mid || i == len - 1) {
                    count++;
                    sum = 0;
                }
            }

            if(count >= m) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }


}


