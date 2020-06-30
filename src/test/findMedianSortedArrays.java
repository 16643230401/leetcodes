package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-26 18:20
 */
public class findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] min = nums1.length > nums2.length ? nums2 : nums1;
        int[] max = nums1.length <= nums2.length ? nums2 : nums1;
        int mid1 = min.length / 2;int left1 = 0, right1 = min.length - 1;
        int mid2 = max.length / 2;int left2 = 0, right2 = max.length - 1;
        int temp = 0;
        int flag = (min.length + max.length) % 2;
        while (true) {
            if(min[mid1] > max[mid2]) {
                //看看中位数是不是找大了
                if((mid1 > 0 && min[mid1 - 1] > max[mid2] )|| max[mid2 + 1] < min[mid1]) {//大了
                    temp = mid1;
                    mid1 = (left1 + mid1) / 2;
                    mid2 += temp - mid1;
                    right1 = mid1;
                } else {
                    if (flag == 1) {
                        return Math.max(min[mid1], max[mid2]);
                    }
                    return (min[mid1] + max[mid2]) / 2;
                }
                

            } else if(min[mid1] < max[mid2]){
                //看看是不是找小了
                if( (mid1 < min.length - 1 && min[mid1 + 1] < max[mid2]) || max[mid2 - 1] > min[mid1]) {//xiaole
                    temp = mid1;
                    mid1 = (mid1 + right1) / 2;
                    left1 = mid1;
                    mid2 -= mid1 - temp;
                } else {
                    if(flag == 1) {
                        return Math.max(min[mid1], max[mid2]);
                    }
                    return (min[mid1] + max[mid2]) / 2;
                }
            } else {
                return min[mid2];
            }

        }

    }
}

