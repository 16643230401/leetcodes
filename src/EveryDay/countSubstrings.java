package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-19 20:48
 */
public class countSubstrings {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = s.length();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int len = s.length();

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = (j == i - 1 || dp[j + 1][i - 1]) && s.charAt(j) == s.charAt(i);
                if(dp[j][i]) ans++;
            }
        }

        return ans;
    }
}
