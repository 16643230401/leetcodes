package laterWMS.WeekMatch20200705;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-05 10:54
 */
public class getLastMoment {

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i : left) {
            ans = Math.max(ans, i);
        }

        for (int i : right) {
            ans = Math.max(ans, n - i);
        }

        return ans;
    }
}
