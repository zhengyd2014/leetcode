import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (27.76%)
 * Likes:    4889
 * Dislikes: 217
 * Total Accepted:    460.7K
 * Total Submissions: 1.5M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 )
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

// @lc code=start
class LRUCache {

    int capacity;
    DoubleLinkedList list;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new DoubleLinkedList();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            this.put(key, node.value);
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            list.remove(map.get(key));
            map.remove(key);
        }

        if (map.size() == capacity) {
            Node last = list.removeLast();
            map.remove(last.key);
        }

        list.addFirst(node);
        map.put(node.key, node);
    }
}

class Node {
    int key;
    int value;
    Node next, prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    
    public DoubleLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public Node removeLast() {
        return remove(tail.prev);
    }

    public Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

