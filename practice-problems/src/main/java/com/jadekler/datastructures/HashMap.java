package com.jadekler.datastructures;

import java.util.Stack;

/**
 * This class holds items in a hash map
 * Although I will implement slightly differently, I learned a lot of good ideas from a good read 
 * that explains the principle here: http://www.techzoo.org/tutorials/how-to-create-your-own-hashmap.html
 */
public class HashMap<K, V>
{
    private Node<K, V>[] buckets;

    public static void main(String args[]) {
               
    }

    public class Node<K, V> {
        private Node<K, V> next;
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return this.value;
        }
    }

    public HashMap() {

    }

    public V get(K key) {
        return null;
    }

    public void put(K key, V value) {
        
    }
}