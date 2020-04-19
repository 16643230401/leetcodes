package test;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 96. 不同的二叉搜索树
 * 95. 不同的二叉搜索树 II
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-18 22:14
 */
public class numTrees {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        numTrees numTrees = new numTrees();
        System.out.println(numTrees.numTrees(3));
    }



    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public List<TreeNode> generateTrees(int n) {

        return solution(1,n);
    }

    public List<TreeNode> solution(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();
        List<TreeNode> leftList = new ArrayList<>();
        List<TreeNode> rightList = new ArrayList<>();
        TreeNode temp;

        for (int i = left; i <= right; i++) {
            leftList = new ArrayList<>();
            rightList = new ArrayList<>();
            if(i == left) {
                leftList.add(null);
            } else {
                leftList = solution(left, i - 1);
            }

            if(i == right) {
                rightList.add(null);
            } else {
                rightList = solution(i + 1, right);
            }

            for (int i1 = 0; i1 < leftList.size(); i1++) {
                for (int i2 = 0; i2 < rightList.size(); i2++) {
                    temp = new TreeNode(i);
                    temp.left = leftList.get(i1);
                    temp.right = rightList.get(i2);
                    ans.add(temp);
                }
            }


        }

        return ans;

    }
}
