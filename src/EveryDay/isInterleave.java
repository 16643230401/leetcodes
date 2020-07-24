package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-18 18:03
 */
public class isInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int [len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 0; i < len2; i++) {
            if(s2.charAt(i) == s3.charAt(i)) dp[0][i + 1] = 1;
            else break;
        }
        for (int i = 0; i < len1; i++) {
            if(s1.charAt(i) == s3.charAt(i)) dp[i + 1][0] = 1;
            else break;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if(dp[i][j - 1] == 1 && s3.charAt(i + j - 1) == s2.charAt(j - 1)) dp[i][j] = 1;
                else if(dp[i - 1][j] == 1 && s3.charAt(i + j - 1) == s1.charAt(i - 1)) dp[i][j] = 1;
            }
        }

        return dp[len1][len2] == 1;
    }
}
