package BaseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-10 22:51
 */
public class TreeAlgorithm {

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




}
