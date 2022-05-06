package com.company;


public class MyHashTable<K,V> {
    private class HashNode<K, V> {
        private HashNode next;
        private K key;
        private V val;

        private HashNode(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setVal(V val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "{" +
                    key +
                    val +
                    '}';
        }
    }

    private int size;
    private int M = 11;
    private HashNode<K, V> table[];

    public MyHashTable() {
        table = new HashNode[M];
    }

    public void put(K key, V val) {
        HashNode<K, V> e = table[hash(key)];
        if (e == null) {
            table[hash(key)] = new HashNode<K, V>(key, val);
        } else {
            while (e.next != null) {
                if (e.getKey() == key) {
                    e.setVal(val);
                    return;
                }
                e = e.next;
            }
            if (e.getKey() == key) {
                e.setVal(val);
                return;
            }
            e.next = new HashNode<K, V>(key, val);
        }

    }


    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    public V get(K key) {
        HashNode<K, V> e = table[hash(key)];
        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.getKey() == key) {
                return e.getVal();
            }
            e = e.next;
        }
        return null;
    }
    public HashNode<K, V> remove(K key) {
        HashNode<K, V> e = table[hash(key)];
        if (e == null) {
            return null;
        }
        if (e.getKey() == key) {
            table[hash(key)] = e.next;
            e.next = null;
            return e;
        }
        HashNode<K, V> prev = e;
        e = e.next;
        while (e != null) {
            if (e.getKey() == key) {
                prev = e;
                e = e.next;
                return e;
            }
        }
        return null;
    }









}

