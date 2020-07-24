package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-24 21:40
 */
public class divisorGame {

    public boolean divisorGame(int n) {

        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(i % j != 0) continue;
                if(!dp[i - j]){
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }



        return dp[n];
    }
}
