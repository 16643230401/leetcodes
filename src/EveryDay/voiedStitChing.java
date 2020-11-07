package EveryDay;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-10-24 16:44
 */
public class voiedStitChing {

    public static void main(String[] args) {
        voiedStitChing v = new voiedStitChing();

//        v.videoStitching();
    }


    //贪心
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (o1, o2)->{
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        if(clips[0][0] > 0) return -1;

        int min = clips[0][1];
        int max = min;
        int ans = 1;

        int len = clips.length;
        for(int i = 0; i < len; i++) {
            if(clips[i][0] > min) {
                if(clips[i][0] > max) break;
                if(clips[i][1] < max) continue;

                ans++;
                min = max;
                max = clips[i][1];
                if(max >= T) return ans;
            } else {
                max = Math.max(max, clips[i][1]);
            }
        }

        if(max >= T) return ans;

        return -1;

    }


    //dp
    public int videoStitching_dp(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
