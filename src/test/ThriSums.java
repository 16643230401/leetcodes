package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2019-12-22 12:40
 */
public class ThriSums {


    /**
     * 15.三数之和
     * @param args
     */
    public static void main(String[] args) {
        ThriSums thiSum = new ThriSums();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> integers : thiSum.threeSum(nums)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println(" ");
        }


    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int left;
        int right;

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (sum == nums[left] + nums[right]) {
                    list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;

                } else if (nums[left] + nums[right] < sum) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (nums[left] + nums[right] > sum) {
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }

            }
        }


        return ans;
    }


}

/*
  -2 -2 4
  -4 -2 6
  -2  0 2
  -4  0 4
  -4  1 3
 */
