package WeekMatches;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-09 10:30
 */
public class WeekMatch20200809 {
    public static void main(String[] args) {
        int i = 'Z';//小写97-122  大写65-90
        System.out.println(i);
    }


    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(;i < s.length() - 1; i++) {
            if(Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                i++;
            } else {
                if(sb.length() == 0)sb.append(s.charAt(i));
                else if(Math.abs(sb.charAt(sb.length() - 1) - s.charAt(i)) == 32) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(s.charAt(i));
                }            }
        }

        if(i < s.length()) {
            if(sb.length() == 0)sb.append(s.charAt(i));
            else if(Math.abs(sb.charAt(sb.length() - 1) - s.charAt(i)) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }



        return sb.toString();
    }

    public char findKthBit(int n, int k) {
        k -= 1;
        String S1 = "0";
        String S2 = "011";
        String S3 = "0111001";
        String S4 = "011100110110001";

        if(n == 1) return S1.charAt(k);
        if(n == 2) return S2.charAt(k);
        if(n == 3) return S3.charAt(k);
        if(n == 4) return S4.charAt(k);

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < S4.length(); i++) {
            list.add(S4.charAt(i));
        }

        int tempCount = n;

        while (tempCount <= n) {

            int len = list.size();
            list.add('1');
            for (int i = len - 1; i >= 0; i--) {
                if(list.get(i) == '0') {
                    list.add('1');
                } else {
                    list.add('0');
                }
            }
            tempCount++;
        }

        return list.get(k);
    }


    public int maxNonOverlapping(int[] nums, int target) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(nums[i] == target || set.contains(sum - temp)) {
                set.clear();
                ans += 1;
                sum = 0;
            } else {
                sum += nums[i];
                set.add(sum);
            }
        }




        return ans;
    }




    int ans = 0;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length + 2][cuts.length + 2];
        int[] vals = new int[cuts.length + 2];
        vals[0] = 0;
        vals[vals.length - 1] = n;
        for (int i = 1; i < vals.length - 1; i++) {
            vals[i] = cuts[i - 1];
        }
        for (int i = 1; i < vals.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k > j; k--) {
                    min = Math.min(min, dp[j][k] + dp[k][i] + vals[i] - vals[j]);
                }
                dp[j][i] = min;
            }
        }
        return dp[0][vals.length - 1];
    }
}
