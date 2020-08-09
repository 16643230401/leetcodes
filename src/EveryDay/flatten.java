package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-02 18:52
 */
public class flatten {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public void flatten(TreeNode root) {
        solution(root);
    }

    public TreeNode solution(TreeNode root) {
        if(root.left == null && root.right == null) return root;
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        TreeNode retNode = root;
        if(tempLeft != null) {
            root.left = null;
            root.right = tempLeft;
            retNode = solution(tempLeft);
        }
        if(tempRight != null) {
            retNode.right = tempRight;
            return solution(tempRight);
        }
        return root;
    }

}
