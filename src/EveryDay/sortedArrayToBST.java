package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-08 21:16
 */
public class sortedArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return get(0, nums.length - 1, nums, new TreeNode(nums[(nums.length - 1) / 2]));

    }


    public TreeNode get(int left, int right, int nums[], TreeNode root) {
        if(left > right) return null;
        int mid = (left + right ) / 2;
        root.left = get(left, mid - 1, nums, new TreeNode(nums[(left + mid - 1) / 2]));
        root.right = get(mid + 1, right, nums, new TreeNode(nums[(mid + 1 + right) / 2]));

        return root;
    }
}
