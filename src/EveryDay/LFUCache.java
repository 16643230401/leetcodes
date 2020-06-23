package EveryDay;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 *
 * defeat
 *
 *
 *
 *
 *
 *
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-05 20:16
 */
public class LFUCache {

    public class Node {
        int key;
        int value;
        int count;
        Node next;
        Node last;
        Node(int key, int value, int count) {this.key = key; this.value = value; this.count = count;}
    }

    Map<Integer, Node> cache;
    Map<Integer, Node[]> pointer;
    Node head;
    Node tail;
    int capacity;
    int minCount = 0;


    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        head = new Node(-1, -1, 0);
        tail = head;
        pointer = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            //***
            Node temp = cache.get(key);
            temp.last.next = temp.next;
            temp.next.last = temp.last;
            temp.last = null;
            temp.next = null;
            if(pointer.get(temp.count)[0] == temp && pointer.get(temp.count)[1] == temp) {
                pointer.remove(temp.count);
            }else if(pointer.get(temp.count)[0] == temp) {
                pointer.get(temp.count)[0] = pointer.get(temp.count)[0].next;
            } else if(pointer.get(temp.count)[1] == temp){
                pointer.get(temp.count)[1] = pointer.get(temp.count)[0].last;
            }
            temp.count++;
            if(pointer.containsKey(temp.count)) {
                addNode(temp);
            } else {
                addNewNodeCount(temp);
            }
            return temp.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == cache.size()) {
            delNode();
        }
    }

    public void addNewNodeCount(Node node) {
        Node start;
        Node end = node;
        end.next = null;
        end.last = tail;
        start = end;
        Node[] arr = new Node[2];
        arr[0] = start;
        arr[1] = end;
        pointer.put(node.count, arr);
    }

    public void addNode(Node node) {
        Node start ;
        Node[] arr =  pointer.get(node.count);
        start = arr[0];
        start.last.next = node;
        node.last = start.last;
        start.last = node;
        node.next = start;
        start = node;
    }

    public void delNode() {

    }
}
