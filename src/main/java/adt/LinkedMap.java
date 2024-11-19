//LimShiLei
package adt;

public class LinkedMap<K, V> implements MapInterface<K, V> {

    private Entry<K, V> firstEntry;
    private Entry<K, V> lastEntry;
    private int numberOfEntries;

    public LinkedMap() {
        firstEntry = null;
        lastEntry = null;
        numberOfEntries = 0;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        } else if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }

        Entry<K, V> newEntry = new Entry<>(key, value);

        if (isEmpty()) {
            firstEntry = newEntry;
            lastEntry = newEntry;
        } else {
            lastEntry.next = newEntry;
            newEntry.prev = lastEntry;
            lastEntry = newEntry;
        }

        numberOfEntries++;
        return value;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }

        V removedValue = null;
        Entry<K, V> currentNode = firstEntry;

        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                removedValue = currentNode.value;

                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    firstEntry = currentNode.next;
                }

                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                } else {
                    lastEntry = currentNode.prev;
                }

                numberOfEntries--;
                break;
            }
            currentNode = currentNode.next;
        }

        return removedValue;
    }

    @Override
    public V get(K key) {
        Entry<K, V> currentNode = firstEntry;
        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    public Entry<K, V>[] entrySet() {
        Entry<K, V>[] entries = (Entry<K, V>[]) new Entry[size()];
        Entry<K, V> currentNode = firstEntry;
        int index = 0;

        while (currentNode != null) {
            entries[index] = currentNode;
            currentNode = currentNode.next;
            index++;
        }

        return entries;
    }

    public static class Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> prev;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
