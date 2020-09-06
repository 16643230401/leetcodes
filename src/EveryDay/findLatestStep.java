package EveryDay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-23 12:11
 */
public class findLatestStep {

    public static void main(String[] args) {
        findLatestStep findLatestStep = new findLatestStep();

        int[] arr=  {3,5,1,2,4};
        System.out.println(findLatestStep.findLatestStep(arr, 1));
    }
    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        int[] temp = new int[len];
        for(int i = 0; i < len; i++) {
            temp[i] = -1;
        }
        int ans = 0;
        int flag = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            temp[arr[i] - 1] = arr[i] - 1;
            left = arr[i] - 1;
            right = left;
            if(arr[i] != 1 && temp[arr[i] - 2] != -1) {
                if(arr[i] - 2 - temp[arr[i] - 2] + 1 == m) {
                    count--;
                }
                temp[arr[i] - 1] = temp[arr[i] - 2];
                temp[temp[arr[i] - 1]] = arr[i] - 1;
                left = temp[arr[i] - 1];
            }

            if(arr[i] != len && temp[arr[i]] != -1) {
                if(temp[arr[i]] - arr[i] + 1 == m) count --;
                temp[temp[arr[i] - 1]] = temp[arr[i]];
                temp[temp[arr[i]]] = temp[arr[i] - 1];
                left = temp[temp[arr[i]]];
                right = temp[arr[i]];
            }

            if(right - left + 1 == m) {
                count ++;
                flag = 1;
            }
            if(count != 0) {
                ans = i + 1;
            }
        }

        return flag == 0 ? -1 :ans;
    }
}
