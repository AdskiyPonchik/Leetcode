package NeedCode.LinkedList;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers();

        // Тест 1: 342 + 465 = 807
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        System.out.print("Test 1 Result: ");
        printList(sol.addTwoNumbers(l1, l2)); // Ожидаем 7 -> 0 -> 8

        // Тест 2: 99 + 1 = 100
        ListNode l3 = createList(new int[]{9, 9});
        ListNode l4 = createList(new int[]{1});
        System.out.print("Test 2 Result: ");
        printList(sol.addTwoNumbers(l3, l4)); // Ожидаем 0 -> 0 -> 1
    }

    // Хелпер для создания списка из массива
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : arr) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Хелпер для красивого вывода
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
