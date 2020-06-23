package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-04 17:22
 */
public class rotate {
    public static void main(String[] args) {
        rotate rotate = new rotate();
        int[] nums = {1,2,3,4,5,6,7};
        rotate.rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }

    }

//    public void rotate(int[] nums, int k) {
//        dp(nums, nums.length - k, k, 0, nums.length - 1);
//    }

    public void dp(int[] nums, int l1, int l2, int left, int right) {
        if(l1 == l2) {
            for (int i = left; i < l1 + left; i++) {
                nums[i] = nums[i] ^ nums[l1 + i];
                nums[l1 + i] = nums[i] ^ nums[l1 + i];
                nums[i] = nums[i] ^ nums[l1 + i];
            }
        } else if(l1 > l2) {
            for (int i = left; i < l2 + left; i++) {
                nums[i] = nums[i] ^ nums[right - l2 + 1 + i - left];
                nums[right - l2 + 1 + i - left] = nums[i] ^ nums[right - l2 + 1 + i - left];
                nums[i] = nums[i] ^ nums[right - l2 + 1 + i - left];
            }
            dp(nums, l1 - l2, l2, l2 + left, right);

        } else {
            for (int i = left; i < l1 + left; i++) {
                nums[i] = nums[i] ^ nums[right - l1 + 1 + i - left];
                nums[right - l1 + 1 + i - left] = nums[i] ^ nums[right - l1 + 1 + i - left];
                nums[i] = nums[i] ^ nums[right - l1 + 1 + i - left];
            }

            dp(nums, l1, l2 - l1, left, right - l1);
        }
    }

    public void rotate(int[] nums, int k) {
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

    }

    public void reverseArray(int[] nums, int left, int right) {
        if(nums.length == 0) return;
        int mid = (left + right) / 2;
        for (int i = left; i <= mid; i++) {
            nums[i] = nums[i] ^ nums[right - i + left];
            nums[right - i + left] = nums[i] ^ nums[right - i + left];
            nums[i] = nums[i] ^ nums[right - i + left];
        }
    }


}
