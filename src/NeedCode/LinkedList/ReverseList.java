package NeedCode.LinkedList;

import java.util.List;

public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Вспомогательный метод для создания списка из массива
    public static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Вспомогательный метод для вывода списка в консоль
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : " -> NULL\n"));
            current = current.next;
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

    public static void main(String[] args) {
        ReverseList sol = new ReverseList();
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = fromArray(input);

        System.out.println("Original list:");
        printList(head);

        ListNode reversed = sol.reverseList(head);

        System.out.println("Reversed list:");
        printList(reversed);
    }
}
