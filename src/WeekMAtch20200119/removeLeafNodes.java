package WeekMAtch20200119;

import com.ibm.nws.ejs.ras.Tr;

/**
 * <p>删除值为target的叶子节点</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-19
 * @Version : v1.0
 */
public class removeLeafNodes {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static void main(String[] args) {

    }

    public boolean isLeave(TreeNode node) {
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        deepFirst(root, target);
        if(isLeave(root) && root.val == target) return null;
        return root;
    }

    public void deepFirst(TreeNode root, int target) {
        if(root != null) {
            deepFirst(root.left, target);
            deepFirst(root.right, target);
            if(root.left != null && (isLeave(root.left) && root.left.val == target)) {
                root.left = null;
            }
            if(root.right != null && (isLeave(root.right) && root.right.val == target)) {
                root.right = null;
            }
        }
    }



}
