package BaseAlgorithm;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-10 22:51
 */
public class TreeAlgorithm {


    class BinNode{
        int val;
        BinNode left;
        BinNode right;

        public BinNode (int val) {this.val = val;}
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * N叉树前序遍历(迭代法)
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if(root == null) return new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();

        while(!stack.isEmpty()) {
            Node temp = stack.pop();
            ans.add(temp.val);
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.push(temp.children.get(i));
            }
        }
        return ans;
    }

    /**
     * N叉树前序遍历（递归法）
     * @param root
     * @return
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder2(Node root) {
        solutionForpreorder2(root);
        return ans;
    }

    public void solutionForpreorder2(Node root){
        if(root == null) return;
        ans.add(root.val);

        for (int i = 0; i < root.children.size(); i++) {
            solutionForpreorder2(root.children.get(i));
        }
    }


    /**
     * 二叉树中序遍历（迭代法）
     * 每周写一遍加深理解，这个刚开始可能不太好想
     * 思路：
     *      左子树弄完，让指针指向空（左子树直接为空，或者最右节点的右节点，因为中序遍历下，原则上每一个节点前驱节点就是左子树中最右节点）
     *      然后弄右子树，思路一样
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(BinNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<BinNode> stack = new Stack<>();

        //刚开始的时候，或者遍历完左子树回到根节点的时候，可能出现栈为空的情况，但是没遍历完
        //这时候就要依靠root是否为空来判断是否遍历结束
        while(root != null || !stack.isEmpty()) {
            //实际上就是深度优先，只不过这种思想下没有记录节点访问情况，节省了空间
            //先把左节点都入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //这时候左节点都入栈了，root该null了，root指回栈顶元素（就是当前子树的根节点），保存值之后该弄右边了
            root = stack.pop();
            ans.add(root.val);
            //弄右子树
            root = root.right;
        }

        return ans;
    }


    /**
     * 二叉树后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(BinNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<BinNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right == null) {
                BinNode temp = stack.pop();
                ans.add(temp.val);
                while(!stack.isEmpty() && stack.peek().right == temp) {
                    temp = stack.pop();
                    ans.add(temp.val);
                }
                root = null;
            } else {
                root = root.right;
            }
        }

        long a = 1000000007;
        return ans;
    }

      public static class TreeNode {
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


    public static int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        int ans = Integer.MAX_VALUE;
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        int prev = ans;
        while(s.isEmpty() || temp != null) {
            while (temp != null){
                s.push(temp);
                temp = temp.left;
            }

            temp = s.pop();
            if(prev == Integer.MAX_VALUE)prev = temp.val;
            else {
                ans = Math.min(ans, temp.val - prev);
                prev = temp.val;
            }

            temp = temp.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(90);
        TreeNode r = root;
        root.left = new TreeNode(69);
        root = root.left;
        root.left = new TreeNode(49);
        root.right = new TreeNode(89);
        root = root.left;
        root.right = new TreeNode(52);
        minDiffInBST(r);
    }




}
