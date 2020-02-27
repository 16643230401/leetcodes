package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 300. 最长上升子序列
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-22 17:08
 */
public class lengthOfLIS {

    public static void main(String[] args) {
        lengthOfLIS lengthOfLIS = new lengthOfLIS();
        int[] arr = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS.lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        List<Integer> ansList = new ArrayList<>();

        ansList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= ansList.get(0)) {
                ansList.set(0, nums[i]);
                continue;
            }
            if(nums[i] > ansList.get(ansList.size() - 1)) {
                ansList.add(nums[i]);
                continue;
            }

            int flag = halfFind(ansList, nums[i], 0, ansList.size() - 1);
            if(flag > 0) ansList.set(flag, nums[i]);
        }

        return ansList.size();
    }


    /**
     * 二分查找，这里涉及到一个取值的问题，每次递归边界的处理方式
     * @param list
     * @param e
     * @param left
     * @param right
     * @return
     */
    public int halfFind(List<Integer> list, int e, int left, int right) {
        int mid = (left + right) / 2;
        if(left == right) return left;
//        if(list.get(mid) == e) return -1;
        if(list.get(mid) >= e) return halfFind(list, e, left, mid);//边界处理方式，这里mid没有+1
        else return halfFind(list, e, mid + 1, right);//边界处理方式，这里mid+1，二者区别主要是要取到较大的一个值
    }
}
