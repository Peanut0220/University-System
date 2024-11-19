/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author Yew Zi Yu
 * @param <T>
 */
public interface QueueInterface<T extends Comparable<T>> {

    /**
     * Inserts an element into the priority queue.
     *
     * @param element The element to insert.
     */
    public void enqueue(T element);

    /**
     * Removes and returns the element with the highest priority from the
     * priority queue.
     *
     * @return The highest priority element.
     */
    public T dequeue();

    /**
     * Returns the element with the highest priority without removing it.
     *
     * @return The highest priority element.
     */
    public T peek();

    /**
     * Checks if the priority queue is empty.
     *
     * @return True if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Checks if the priority queue is full (reached its maximum capacity).
     *
     * @return True if the priority queue is full, false otherwise.
     */
    public boolean isFull();

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return The number of elements in the priority queue.
     */
    public int size();

    public T get(int givenPosition);

    public void clear();

    public boolean contains(T anEntry);
}
