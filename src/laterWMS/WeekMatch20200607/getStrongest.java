package laterWMS.WeekMatch20200607;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-07 11:01
 */
public class getStrongest {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid =arr[(arr.length - 1) / 2];

        int l = 0;
        int r = arr.length - 1;
        int[] ans = new int[k];
        int p = 0;
        while (p < k) {
            if(mid - arr[l] > arr[r] - mid) {
                ans[p++] = arr[l++];
            } else {
                ans[p++] = arr[r--];
            }
        }
        return ans;
    }
}
