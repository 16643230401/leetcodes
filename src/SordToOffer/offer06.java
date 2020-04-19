package SordToOffer;

import javax.xml.crypto.dsig.keyinfo.KeyName;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-26 22:01
 */
public class offer06 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        offer06 ans = new offer06();
        ans.solution();
    }

    public void solution() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        ListNode L = head;
        ListNode M = L.next;
        L.next = null;
        M.next = L;
        L = M;
        System.out.println(M.val);
        System.out.println(M.next.val);
        System.out.println(L.val);
        System.out.println(L.next.val);
    }

    public int[] reversePrint(ListNode head) {

        if(head == null) return new int[0];

        if(head.next == null) return new int[]{head.val};
        ListNode L = head;
        ListNode M = L.next;
        ListNode R = M.next;
        int len = 1;
        L.next = null;
        while(R != null) {
            len++;
            M.next = L;
            L = M;
            M = R;
            R = R.next;
        }
        len++;
        M.next = L;
        L = M;
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = L.val;
            L = L.next;
        }




        return ans;
    }
}
