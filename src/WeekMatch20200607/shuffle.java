package WeekMatch20200607;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-07 10:47
 */
public class shuffle {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        int p2 = n;
        for (int i = 0; i < n; i++, p2++) {
            arr[2 * i] = nums[i];
            arr[2 * i + 1] = nums[p2];
        }

        return arr;
    }
}
