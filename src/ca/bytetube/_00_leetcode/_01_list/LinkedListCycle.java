package ca.bytetube._00_leetcode._01_list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author dal
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }


        return false;
    }
}
