/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author Yew Zi Yu
 * @param <T>
 */
public class PriorityQueue<T extends Comparable<T>> implements QueueInterface<T>{

    private T[] array; //the array to store elements
    private int itemCount;
    private static final int DEFAULT_CAPACITY = 25;

    public PriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public PriorityQueue(int size) {
        array = (T[]) new Comparable[size];
        itemCount = 0;
    }

    //insert an element into priority queue
    @Override
    public void enqueue(T newEntry) {
        if (!isFull()) {
            int i = itemCount;
            while (i > 0 && newEntry.compareTo((T) array[i - 1]) < 0) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = newEntry;
            itemCount++;
        }
    }

    //remove an element 
    @Override
    public T dequeue() {
        T highestPriority = null;
        if (!isEmpty()) {
            highestPriority = array[0];//the highest priority element is at index 0
            //move last element to the root
            array[0] = array[itemCount - 1];
            array[itemCount - 1] = null;
            itemCount--;
            heapify(0);
        }
        return highestPriority;
    }

    private void heapify(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        if (leftChildIndex < itemCount && rightChildIndex < itemCount) {
            if (array[leftChildIndex].compareTo(array[rightChildIndex]) > 0) {
                largest = leftChildIndex;
            } else {
                largest = rightChildIndex;
            }
        } else if (leftChildIndex < itemCount) {
            largest = leftChildIndex;
        }

        if (largest != index) {
            T temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(largest);
        }
    }

    @Override
    public boolean isEmpty() {
        return itemCount == 0;
    }

    @Override
    public boolean isFull() {
        return itemCount == array.length;
    }

    @Override
    public int size() {
        return itemCount;
    }

    @Override
    public T peek() {
        return array[itemCount - 1];
    }

    @Override
    public T get(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= itemCount)) {
            result = array[givenPosition - 1];
        }

        return result;
    }

    @Override
    public void clear() {
        itemCount = 0;
        array = (T[]) new Comparable[array.length];
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < itemCount); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }
}
