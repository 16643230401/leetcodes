package EveryDay;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-26 12:35
 */
public class removeDuplicateNodes {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) return null;
        boolean[] set = new boolean[20001];
        ListNode p = head;
        set[head.val] = true;
        while(p.next != null) {
            if(set[p.next.val]) {
                p.next = p.next.next;
            } else {
                set[p.next.val] = true;
                p = p.next;
            }
        }

        return head;
    }
}
