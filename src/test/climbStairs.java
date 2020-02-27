package test;

/**
 *
 * 70. 爬楼梯
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-09 19:02
 */
public class climbStairs {

    public static void main(String[] args) {

        climbStairs climbStairs = new climbStairs();
        System.out.println(climbStairs.climbStairs2(44));
    }

    /**
     * DP自底向上的算法，正解
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    /**
     * 用滚动数组优化上一个算法的空间效率
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i % 3] = arr[(i - 1) % 3] + arr[(i - 2) % 3];
        }

        return arr[n % 3];
    }

    /**
     * DP自顶向下的算法，超时
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        return n <= 1 ? 1: climbStairs3(n - 1) + climbStairs3(n - 2);
    }



}


//dp[n] = dp[n - 1] + dp[n - 2]
