package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-23 23:13
 */
public class preorderTraversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ans = new LinkedList<>();

        TreeNode temp ;
        while(!stack.empty()) {
            temp = stack.pop();
            ans.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }

        return ans;
    }
}
