package EveryDay;

import com.sun.xml.internal.ws.api.message.stream.InputStreamMessage;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-05 18:06
 */
public class isMatch {

    //44. 通配符匹配  和  10. 正则表达式匹配  都在这





    /**
     * 44. 通配符匹配  DP
     *
     * @param s
     * @param p
     * @return
     */
//    public boolean isMatch(String s, String p) {
//        int row = p.length() + 1;
//        int col = s.length() + 1;
//        int[][] dp = new int[row][col];
//        dp[0][0] = 1;
//        for (int i = 1; i < col; i++) {
//            dp[0][i] = 0;
//        }
//        int j1 = 1;
//        while (j1 < row && p.charAt(j1 - 1) == '*') {
//            dp[j1++][0] = 1;
//        }
//
//        while(j1 < row) {
//            dp[j1++][0] = 0;
//        }
//
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
//                    dp[i - 1][j - 1] = dp[i][j] = 1;
//                } else if(p.charAt(i - 1) == '*') {
//                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
//                }
//            }
//        }
//        return dp[row - 1][col - 1] == 1;
//    }
    public static void main(String[] args) {
        isMatch isMatch = new isMatch();
        isMatch.isMatch("mississippi", "mis*is*ip*.");
    }


    /**
     * 10. 正则表达式匹配  DP
     *
     * @param s
     * @param p
     * @return
     */

    public boolean isMatch(String s, String p) {
        int row = p.length() + 1;
        int col = s.length() + 1;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        int j1 = 1;
        while(j1 < row) {
            if(p.charAt(j1 - 1) == '*' && (dp[j1 - 1][0] == 1 || (j1 - 2 >= 0 && dp[j1 - 2][0] == 1))){
                dp[j1][0] = 1;
            }
            j1++;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(i - 1) == '*') {
//                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];

                    if(dp[i - 1][j] == 1 || (i - 2 >= 0 && dp[i - 2][j] == 1) ) {
                        dp[i][j] = 1;
                    } else if(i - 2 >= 0 && (s.charAt(j - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.') && dp[i][j - 1] == 1){
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return dp[row - 1][col - 1] == 1;
    }

}
