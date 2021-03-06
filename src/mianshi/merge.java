package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-25 21:22
 */
public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        m -= 1;
        n -= 1;

        while(m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) nums1[p--] = nums1[m--];
            else nums1[p--] =nums2[n--];
        }
        if(n >= 0) {
            while(n >= 0) {
                nums1[p--] = nums2[n--];
            }
        }
    }
}
