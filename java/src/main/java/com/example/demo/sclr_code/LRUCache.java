/*
 * Q1. LRU Cache
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
 */


package com.example.demo.sclr_code;

import java.util.HashMap;

public class LRUCache {

	public static void main(String[] args) {
		
	}

}

class Solution {
	   
    int capacity;
    DoublyListNode head = new DoublyListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
    DoublyListNode tail = new DoublyListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
    HashMap<Integer, DoublyListNode> listHash = new HashMap<>();

    public Solution(int capacity) {
        this.capacity = capacity;
    }
   
    public int get(int key) {
        DoublyListNode node = listHash.get(key);
        if (null!=node) {
            remove(node);
            addToTail(node);
            return node.value;
        }
        return -1;
    }
   
    public void set(int key, int value) {
        DoublyListNode node = listHash.get(key);
        if (null!=node) {
            remove(node);
            node.value = value;
            addToTail(node);
        } else {
            node = new DoublyListNode(value, key);
            if (listHash.size()==0) {
                head.next = tail;
                tail.prev = head;
            } else if (listHash.size()>=capacity) {
                removeFromHead();
            }
            addToTail(node);
        }
        listHash.put(key, node);
    }

    private void removeFromHead() {
        DoublyListNode node = head.next;
        listHash.remove(node.key);
        remove(node);
    }

    private void remove(DoublyListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(DoublyListNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
    }
}

class DoublyListNode {
    int value;
    int key;
    DoublyListNode next, prev;
    DoublyListNode(int x, int key) {
        this.value = x;
        this.key = key;
    }
}



// public class Solution {

//     private LinkedHashMap<Integer, Integer> hm = new LinkedHashMap();
//     private int capacity;  
    
//     public Solution(int capacity) {
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         if(hm.containsKey(key)){
//             return hm.get(key);
//         }else{
//             return -1;
//         }
//     }
    
//     public void set(int key, int value) {
//         if(hm.size()==capacity){
//             hm.remove(getFirst(hm));
//         }
//         if(hm.containsKey(key)){
//             hm.remove(key);
//         }
//         hm.put(key, value);
//     }

//     public int getFirst(LinkedHashMap<Integer, Integer> lhm)
//     {
//         int key = Integer.MAX_VALUE;
//         int count=1;
//         for (Map.Entry<Integer, Integer> it : lhm.entrySet()) {
//             if(count==1){
//                 key = it.getKey();
//                 return key;
//             }
//         }
//         return -1;
//     }
// }






