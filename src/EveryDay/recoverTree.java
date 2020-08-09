package EveryDay;

import java.util.Stack;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-08 16:36
 */
public class recoverTree {
    
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

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root = root.left;
        TreeNode preNode = null;
        TreeNode n1 = null;
        TreeNode n2 = null;

        while(!stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(preNode != null && preNode.val > root.val) {
                if(n1 == null) n1 = preNode;
                else {
                    n2 = root;
                    break;
                }
            }

            preNode = root;
            root = root.right;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

    }
}
