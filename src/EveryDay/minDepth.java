package EveryDay;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-22 19:23
 */
public class minDepth {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        int rowSum = 1;
        int nextRowSum = 0;
        int ans = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            if(rowSum == 0) {
                rowSum = nextRowSum;
                nextRowSum = 0;
                ans++;
                continue;
            }

            TreeNode temp = q.poll();
            if(temp.left != null && temp.right != null) return ans;
            if(temp.left != null) {
                q.add(temp.left);
                nextRowSum ++;
            }

            if(temp.right != null) {
                q.add(temp.right);
                nextRowSum ++;
            }

            rowSum --;
        }

        return ans;
    }
}
