package WeekMatch20200801;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-02 10:31
 */
public class countGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans= 0 ;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }

        }
        return ans;
    }

    public int getWinner(int[] arr, int k) {
        int max = Math.max(arr[0], arr[1]);
        if(k == 1) return max;
        int count = 1;
        for (int i = 2; i < arr.length; i++) {
            count ++;
            if(arr[i] > max) {
                max = arr[i];
                count = 1;
            }
            if(count == k) return max;
        }

        return max;
    }



    public int minSwaps(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int canCol = grid.length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j >= 1; j--) {
                if(grid[i][j] == 0) {
                    canCol--;
                }else {
                    break;
                }
            }

//            if(canCol < grid.length - 1 && !map.keySet().contains(canCol)) {
//                map.put(canCol, i);
//            }

            while(canCol < grid.length - 1) {
                if(!map.keySet().contains(canCol)) {
                    map.put(canCol, i);
                    break;
                }
                canCol ++;
            }
            canCol = grid.length - 1;
        }
        if(map.entrySet().size() < grid.length - 1) return -1;
        int ans = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            if(map.get(i) != i) {
                ans += map.get(i) - i;
                for (Integer integer : map.keySet()) {
                    if(map.get(integer) < map.get(i))
                        map.put(integer, map.get(integer) + 1);
                }
            }
            map.remove(i);
        }

        return ans;
    }


    public int maxSum(int[] nums1, int[] nums2) {
        long[] val1 = new long[nums1.length];
        long[] val2 = new long[nums2.length];
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
//        if(nums1[p1] == nums2[p2]) {
//            val1[p1] = nums1[p1];
//            val2[p2] = nums2[p2];
//            p1--;
//            p2--;
//        }
//        while(p1 >= 0 && p2 >= 0 && nums1[p1] == nums2[p2]) {
//            val1[p1] = nums1[p1] + val1[p1 + 1];
//            val2[p2] = nums2[p2] + val2[p2 + 1];
//            p1--;
//            p2--;
//        }
//        if(nums1[p1] > nums2[p2]) {
//            val1[p1] = (p1 == nums1.length - 1) ? nums1[p1] : nums1[p1] + val1[p1 + 1];
//            p1--;
//        } else {
//            val2[p2] = (p2 == nums2.length - 1) ? nums2[p2] : nums2[p2] + val2[p2 + 1];
//            p2--;
//        }
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                val1[p1] = ((p1 == nums1.length - 1) ? nums1[p1] : nums1[p1] + val1[p1 + 1]);
                p1--;
            } else if(nums1[p1] < nums2[p2]) {
                val2[p2] = ((p2 == nums2.length - 1) ? nums2[p2] : nums2[p2] + val2[p2 + 1]);
                p2--;
            } else if(nums1[p1] == nums2[p2]) {
                if(p1 == nums1.length - 1 && p2 == nums2.length - 1) {
                    val1[p1] = nums1[p1];
                    val2[p2] = nums2[p2];
                } else if(p1 == nums1.length - 1){
                    val1[p1] = (nums1[p1] + val2[p2 + 1]);
                    val2[p2] = (nums2[p2] + val2[p2 + 1]);
                } else if(p2 == nums2.length - 1) {
                    val1[p1] = (nums1[p1] + val1[p1 + 1]);
                    val2[p2] = (nums2[p2] + val1[p1 + 1]);
                } else {
                    val1[p1] = (nums1[p1] + Math.max(val1[p1 + 1], val2[p2 + 1]));
                    val2[p2] = (nums2[p2] + Math.max(val1[p1 + 1], val2[p2 + 1]));
                }
                p1--;
                p2--;
            }

        }

        while(p1 >= 0) {
            val1[p1] = ((p1 == nums1.length - 1) ? nums1[p1] : nums1[p1] + val1[p1 + 1]);
            p1--;
        }

        while(p2 >= 0) {
            val2[p2] = ((p2 == nums2.length - 1) ? nums2[p2] : nums2[p2] + val2[p2 + 1]);
            p2--;
        }

        return (int)(Math.max(val1[0], val2[0]) % 1000000007);
    }
}
