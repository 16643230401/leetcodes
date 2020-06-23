package WeekMatch20200524;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-24 10:58
 */
public class pseudoPalindromicPaths {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }



    public int pseudoPalindromicPaths (TreeNode root) {
         if(root == null) return 0;
         if(root.left == null && root.right == null) return 1;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<Integer> set = new HashSet<>();
        set.add(root.val);
        TreeNode temp = null;
        int ans = 0;
        while(!stack.empty()) {
            if((stack.peek().left == null && stack.peek().right == null)|| (stack.peek().right != null && temp == stack.peek().right) || (temp == stack.peek().left && null == stack.peek().right)){
              temp = stack.pop();
              if(stack.peek().left == null && stack.peek().right == null && set.size() <= 1) ans += 1;
              if(set.contains(temp.val)) {
                  set.remove(temp.val);
              } else {
                  set.add(temp.val);
              }
            } else if(temp != stack.peek().left && stack.peek().left != null) {
                stack.push(stack.peek().left);
                if(set.contains(stack.peek().val)) {
                    set.remove(stack.peek().val);
                } else {
                    set.add(stack.peek().val);
                }
            } else if(temp != stack.peek().right && stack.peek().right != null) {
                stack.push(stack.peek().right);
                if(set.contains(stack.peek().val)) {
                    set.remove(stack.peek().val);
                } else {
                    set.add(stack.peek().val);
                }
            }
        }

        return ans;
     }
}
