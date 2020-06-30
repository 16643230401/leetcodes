package EveryDay;

import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-29 22:05
 */
public class findKthLargest {

    public static void main(String[] args) {
        findKthLargest findKthLargest = new findKthLargest();
        int[] arr = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.println(findKthLargest.findKthLargest(arr, 20));
    }

    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k > nums.length) return -1;
        int[] heap = createHeap(nums, k + 1);
        for (int i = k; i < nums.length; i++) {
            if(nums[i] <= heap[1]) continue;
            heap[1] = nums[i];
            int p = 1;
            while (p * 2 + 1 <= k && (heap[p] > heap[p * 2] || heap[p] > heap[p * 2 + 1])) {
                p = heap[p * 2] < heap[p * 2 + 1] ? p * 2 : p * 2 + 1;
                swap(heap, p / 2, p);
            }
            if (p * 2 == k) {
                if (heap[p] > heap[p * 2]) swap(heap, p, p * 2);
                p = p * 2;
            }

        }

        return heap[1];


    }

    public int[] createHeap(int[] nums, int len/*k + 1*/) {
        int[] heap = new int[len];
        for (int i = 0; i < len - 1; i++) {
            heap[i + 1] = nums[i];
        }
        int p;
        int k = len - 1;
        for(int i = k/ 2; i >= 1; i--){
            p = i;
            while(p * 2 + 1 <= k && (heap[p] > heap[p * 2] || heap[p] > heap[p * 2 + 1])) {
                p = heap[p * 2] < heap[p * 2 + 1] ? p * 2 : p * 2 + 1;
                swap(heap, p / 2, p);
            }
            if (p * 2 == k) {
                if (heap[p] > heap[p * 2]) swap(heap, p, p * 2);
                p = p * 2;
            }
        }

        return heap;
    }


    public void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
