package EveryDay;

import java.util.Stack;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-04 21:35
 */
public class longestValidParentheses {


    /**
     * 动态规划   比较smooth
     * @param s
     * @return
     */
//    public int longestValidParentheses(String s) {
//        int[] dp = new int[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            if(')' == s.charAt(i) && i - 1 >= 0 && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
//                dp[i] = dp[i - 1] + 2;
//                if(i - 1 - dp[i - 1] - 1 >= 0) {
//                    dp[i] += dp[i - 1 - dp[i - 1] - 1];
//                }
//            }
//        }
//
//        int ans = 0;
//
//        for (int i = 0; i < dp.length; i++) {
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
//    }



    /**
     * 两个集合判断，野路子
     * @param s
     * @return
     */

//    public int longestValidParentheses(String s) {
//        int leftSet = 0;
//        int rightSet = 0;
//        int ans = 0;
//
//
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '(') {
//                leftSet ++;
//            } else {
//                rightSet ++;
//            }
//
//            if(leftSet == rightSet) {
//                ans = Math.max(leftSet, ans);
//            }else if(rightSet > leftSet) {
//                leftSet = 0;
//                rightSet = 0;
//            }
//        }
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if(s.charAt(i) == '(') {
//                leftSet ++;
//            } else {
//                rightSet ++;
//            }
//
//            if(leftSet == rightSet) {
//                ans = Math.max(leftSet, ans);
//            }else if(rightSet < leftSet) {
//                leftSet = 0;
//                rightSet = 0;
//            }
//        }
//
//
//        return ans;
//
//    }


    /**
     * 栈  括号匹配所使用的经典数据结构
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        int serFlag = 0;
        int tempCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.peek() != -1 &&s.charAt(stack.peek()) == '(') {
                    ans = Math.max(ans, i + 1 - stack.pop());
                    if(stack.peek() == -1) {
                        ans = Math.max(ans, i + 1);
                    }
                } else {
                    ans = Math.max(ans, i - 1 - stack.pop());
                    stack.push(i);
                }
            }
        }

        return ans;
    }
}
