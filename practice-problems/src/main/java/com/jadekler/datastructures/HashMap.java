package com.jadekler.datastructures;

import java.util.Stack;

/**
 * This class holds items in a hash map
 * Although I will implement slightly differently, I learned a lot of good ideas from a good read 
 * that explains the principle here: http://www.techzoo.org/tutorials/how-to-create-your-own-hashmap.html
 */
public class HashMap<K, V>
{
    private int DEFAULT_BUCKETS_SIZE = 16;
    private Node<K, V>[] buckets;

    public static void main(String args[]) {
        HashMap<String, String> map = new HashMap<String, String>();
        String returnValue;

        map.put("test_key1", "test_value1");
        map.put("test_key2", "test_value2");
        map.put("test_key3", "test_value3");
        map.put("test_key4", "test_value4");

        returnValue = map.get("test_key1");
        System.out.println(returnValue);
        returnValue = map.get("test_key2");
        System.out.println(returnValue);
        returnValue = map.get("test_key3");
        System.out.println(returnValue);
        returnValue = map.get("test_key4");
        System.out.println(returnValue);
    }

    public class Node<K, V> {
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
        buckets = new Node[DEFAULT_BUCKETS_SIZE];
    }

    public V get(K key) {
        Node<K, V> node = buckets[bucketIndexForKey(key)];

        return node == null ? null : node.getValue();
    }

    public void put(K key, V value) {
        buckets[bucketIndexForKey(key)] = new Node<K, V>(key, value);
    }

    public int bucketIndexForKey(K key) {
        return key.hashCode() > 0 ? key.hashCode() % buckets.length : (key.hashCode() * -1) % buckets.length;
    }
}