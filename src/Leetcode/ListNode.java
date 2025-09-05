package Leetcode;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;

    // Конструктор по умолчанию
    public ListNode() {
    }

    // Конструктор с одним значением
    public ListNode(int val) {
        this.val = val;
    }

    // Конструктор с значением и ссылкой на следующий узел
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // TODO: Solved!
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode current = result;
            int carry = 0;
            while(l1!=null || l2 !=null || carry>0){
                int val1 = l1!=null ? l1.val : 0;
                int val2 = l2!=null ? l2.val: 0;
                int sum = val1+val2 + carry;
                carry = sum/10;
                current.next  = new ListNode(sum%10);
                current = current.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            return result.next;
        }
    }
}

