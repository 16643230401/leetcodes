package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-01 21:35
 */
public class findLength {


    /**
     * DP
     * @param A
     * @param B
     * @return
     */
//    public int findLength(int[] A, int[] B) {
//        int[][] dp = new int[A.length][B.length];
//        int ans = 0;
//        for (int i = 0; i < A.length; i++) {
//            if(B[0] == A[i]) {
//                dp[i][0] = 1;
//                ans = 1;
//            }
//        }
//
//        for (int i = 0; i < B.length; i++) {
//            if(A[0] == B[i]) {
//                dp[0][i] = 1;
//                ans = 1;
//            }
//        }
//        for (int i = 1; i < A.length; i++) {
//            for (int j = 1; j < B.length; j++) {
//                if(A[i] == B[j]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    ans = Math.max(ans, dp[i][j]);
//                }
//            }
//        }
//
//        return ans;
//
//    }


    /**
     * 滑动窗口
     * @param a
     * @param b
     * @return
     */
    public int findLength(int[] a, int[] b) {
        int ans = 0;
        for (int i = b.length - 1; i > -1; i--) {
            int left = 0;
            int right = i;
            int temp = 0;
            while(right < b.length && left < a.length) {
                if(a[left] == b[right]) {
                    temp ++;
                } else {
                    ans = Math.max(ans, temp);
                    temp = 0;
                }
                ans = Math.max(ans, temp);
                left ++;
                right ++;
            }

        }

        for (int i = 0; i < a.length; i++) {
            int left = i;
            int right = 0;
            int temp = 0;
            while(left < a.length && right < b.length) {
                if(a[left] == b[right]) {
                    temp ++;
                } else {
                    ans = Math.max(ans, temp);
                    temp = 0;
                }
                ans = Math.max(ans, temp);
                left ++;
                right ++;
            }
        }

        return ans;
    }
}
