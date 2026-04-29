package NeedCode.LinkedList;

public class ReverseKgroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            for(int i = 0; i < k; i++){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k){
        while(node!=null && k > 0){
            node = node.next;
            k--;
        }
        return node;
    }
}

