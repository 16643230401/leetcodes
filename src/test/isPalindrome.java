package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-01-02 23:24
 */
public class isPalindrome {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 回文链表
     * @param args
     */
    public static void main(String[] args) {
        isPalindrome isPalindrome = new isPalindrome();


        isPalindrome.test();

    }


    public void test() {
        ListNode listNode = new ListNode(-129);
        ListNode listNode1 = new ListNode(-129);
        listNode.next = listNode1;
        System.out.println(isPalindrome(listNode));

    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode temp;
        ListNode reverseHead = null;

        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp.next = reverseHead;
            reverseHead = temp;
        }

        if(fast == null) {
            slow = slow.next;
        } else {
            temp = slow;
            slow = slow.next;
            temp.next = reverseHead;
            reverseHead = temp;
        }

        while (slow != null) {
            if(slow.val == reverseHead.val) {
                slow = slow.next;
                reverseHead = reverseHead.next;
            } else {
                break;
            }
        }
        if(slow == null) {
            return true;
        }
        return false;


    }
}
