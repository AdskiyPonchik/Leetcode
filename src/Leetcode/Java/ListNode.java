package Leetcode;

import java.util.ArrayList;

// Difficulty: Medium

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
}

