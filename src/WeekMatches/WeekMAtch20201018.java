package WeekMatches;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-10-18 16:42
 */
public class WeekMAtch20201018 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int len = ages.length;
        int[][] map = new int[len][2];

        for (int i = 0; i < map.length; i++) {
            map[i][0] = ages[i];
            map[i][1] = scores[i];
        }

        Arrays.sort(map, (o1, o2)->{
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[len];
        int ans = 0;
        dp[0] = map[0][1];
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(map[i][1] >= map[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + map[i][1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
