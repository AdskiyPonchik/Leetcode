package NeedCode.LinkedList;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode first = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = slow.next;
        slow.next = null;
        secondhalf = reverseList(secondhalf);
        while(secondhalf != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondhalf.next;
            first.next = secondhalf;
            secondhalf.next = tmp1;
            first = tmp1;
            secondhalf = tmp2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        if(curr == null){
            return null;
        }
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
