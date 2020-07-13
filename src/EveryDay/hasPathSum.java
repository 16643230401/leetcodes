package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-07 22:25
 */
public class hasPathSum {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        return (root!= null) &&
                (((sum -= root.val) == 0 && root.left == null && root.right == null) ||
                (root.left != null && hasPathSum(root.left, sum)) ||
                (root.right != null && hasPathSum(root.right, sum)));
    }
}
