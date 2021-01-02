package laterWMS.WeekMath20200301;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-01 11:17
 */
public class isSubPath {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        if(root.val == head.val && findEle(head, root)) return true;
        while(!q.isEmpty()) {
            if(q.peek().left != null) {
                q.add(q.peek().left);
                if(q.peek().left.val == head.val && findEle(head,q.peek().left)) return true;
            }
            if(q.peek().right != null) {
                q.add(q.peek().right);
                if(q.peek().right.val == head.val && findEle(head, q.peek().right)) return true;
            }
            q.remove();
        }




        return false;
    }

    public boolean findEle(ListNode head, TreeNode root) {
        if(head.val != root.val) return false;
        if(head.next == null) return true;

        if(findEle(head.next, root.left) || findEle(head.next, root.right)) return true;


        return false;
    }
}
