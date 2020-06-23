package mianshi;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-27 22:53
 */
public class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.keySet().contains(nums1[i])) {
                map.put(nums1[i],map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        int temp;
        for (int i = 0; i < nums2.length; i++) {
            if(!map.keySet().contains(nums2[i])) continue;
            list.add(nums2[i]);
            temp = map.get(nums2[i]);
            if(temp - 1 <= 0) map.remove(nums2[i]);
            else map.put(nums2[i], temp - 1);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }



        return ans;
    }



    public int[] intersect2(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1 ++;
            } else if (nums1[p1] > nums2[p2]) {
                p2 ++;
            } else {
                nums1[k++] = nums2[p2++];
                p1++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
