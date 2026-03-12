package NeedCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public Node copyRandomListOld(Node head) {
        if(head == null){return null;}
        Map<Node, Node> map = new HashMap<>();
        Node curnode = head;
        while(curnode != null){
            map.put(curnode, new Node(curnode.val));
            curnode= curnode.next;
        }
        curnode = head;
        while(curnode!=null){
            map.get(curnode).next = map.get(curnode.next);
            map.get(curnode).random = map.get(curnode.random);
            curnode = curnode.next;
        }
        return map.get(head);
    }
    // alternative solution with O(1) memory

    public Node copyRandomList(Node head){
        if(head == null){return null;}
        Node curnode = head;
        while(curnode!=null){
            Node next = curnode.next;
            Node copy = new Node(curnode.val);
            curnode.next = copy;
            copy.next = next;
            curnode = next;
        }
        curnode = head;
        while(curnode!=null){
            if(curnode.random!=null){
                curnode.next.random = curnode.random.next;
            }
            curnode = curnode.next.next;
        }
        curnode = head;
        Node newHead = head.next;
        Node copyCurr = newHead;
        while(curnode!=null){
            curnode.next = curnode.next.next;
            if(copyCurr.next != null){
                copyCurr.next = copyCurr.next.next;
            }
            curnode = curnode.next;
            copyCurr = copyCurr.next;
        }

        return newHead;
    }
}
