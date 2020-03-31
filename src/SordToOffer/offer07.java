package SordToOffer;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-27 20:31
 */
public class offer07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int index, int[] inorder, int left, int right) {
        if(left >= right) return null;
        int i;
        for (i = left; i <= right; i++) {
            if(inorder[i] == preorder[index]) break;
        }
        TreeNode node = new TreeNode(preorder[index]);
        node.left = buildTreeHelper(preorder, index + 1, inorder, left, i - 1);
        node.right = buildTreeHelper(preorder, index + 1 + i - left, inorder, i + 1, right);
        return node;
    }
}
