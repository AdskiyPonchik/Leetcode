package NeedCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Node head = new Node();
    private final Node tail = new Node();
    private int capacity;
    private Map<Integer, Node> map;

    private class Node {
        int key, value;
        Node prev, next;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node result = map.get(key);
        if (result != null) {
            removeNode(result);
            addNode(result);
            return result.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node searchResult = map.get(key);
        if (searchResult != null) {
            searchResult.value = value;
            removeNode(searchResult);
            addNode(searchResult);
        } else {
            if (map.size() == capacity) {
                Node last = tail.prev;
                removeNode(last);
                map.remove(last.key);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            map.put(key, newNode);
        }
    }
}
