/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-17 20:42
 */
public class NetEase2016 {
    public static void main(String[] args) {


    }

    public int Solution(int[] powers, int sum, int len) {
        int ans = 0;

        int[][] dp = new int[powers.length][sum + 1];
        for (int i = 0; i < powers.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < sum; i++) {
            dp[0][i] = powers[0];
        }

        //dp[p][k] = max(dp[p - 1][k - 1], dp[





        return ans;
    }


}
