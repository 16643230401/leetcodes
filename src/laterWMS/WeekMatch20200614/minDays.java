package laterWMS.WeekMatch20200614;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-14 11:19
 */
public class minDays {

    public int minDays(int[] bloomDay, int m, int k) {
        int[] temp  = Arrays.copyOf(bloomDay,bloomDay.length);
        Arrays.sort(temp);
        int left = 0;
        int right = temp.length;
        int mid;
        int ans = -1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(isNAns(bloomDay, m, k, temp[mid])) {
                ans = temp[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;


    }



    public boolean isNAns(int[] bloomDay, int m, int k, int days){

        int temp = 0;
        int count = 0;
        int a;
        for (int i = 0; i < bloomDay.length; i++) {
            a = bloomDay[i] - days;
            if(a > 0) {
                temp = 0;
            } else {
                temp ++;
                if(temp == k) {
                    count ++;
                    temp = 0;
                }
            }
        }

        return m <= count;
    }
}
