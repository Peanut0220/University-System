
package adt;

import java.io.Serializable;
import java.util.Iterator;


/**
 *
 * @author Lim Yi Jie, Ng Chong Jian
 */
public class SortedDoublyLinkedList<T extends Comparable<T>> implements 
        SortedListInterface<T>, Serializable {

    private Node firstNode;
    private int numberOfEntries;

    public SortedDoublyLinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= numberOfEntries) {
            return null;
        }
        Node currentNode = firstNode;
        for (int i = 0; i < givenPosition; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node currentNode = null;

        public LinkedListIterator() {
            if (!isEmpty()) {
                currentNode = firstNode;
            }
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T currElement = null;
            if (hasNext()) {
                currElement = currentNode.data;

                currentNode = currentNode.next;

            }
            return currElement;
        }

        public boolean isLast() {
            return currentNode == firstNode;
        }

    }

    @Override
    public Iterator<T> getIterator() {
        return new LinkedListIterator();
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (firstNode == null || newEntry.compareTo(firstNode.data) <= 0) {
            newNode.next = firstNode;
            if (firstNode != null) {
                firstNode.previous = newNode;
            }
            firstNode = newNode;
        } else {
            Node current = firstNode;
            while (current.next != null && 
                    newEntry.compareTo(current.next.data) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            if (current.next != null) {
                current.next.previous = newNode;
            }
            current.next = newNode;
            newNode.previous = current;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean replace(T oldEntry, T newEntry) {
        Node current = firstNode;
        while (current != null && !current.data.equals(oldEntry)) {
            current = current.next;
        }
        if (current != null) {
            current.data = newEntry;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T anEntry) {
        Node current = firstNode;
        while (current != null && !current.data.equals(anEntry)) {
            current = current.next;
        }
        if (current != null) {
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                firstNode = current.next;
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            }
            numberOfEntries--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T anEntry) {
        Node current = firstNode;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

    @Override
    public String display() {
        String str = "";
        Node current = firstNode;
        while (current != null) {
            str += current.data + "";
            current = current.next;
        }

        return str;
    }

    private class Node implements Serializable {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
            next = null;
            previous = null;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

    }

}
