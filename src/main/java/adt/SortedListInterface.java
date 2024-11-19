/**
 *
 * @author Lim Yi Jie, Ng Chong Jian
 */
package adt;

import java.util.Iterator;

public interface SortedListInterface<T extends Comparable<T>> {

    Iterator<T> getIterator();

    public String display();

    public boolean add(T newEntry);

    public boolean replace(T oldEntry, T newEntry);

    public boolean remove(T anEntry);

    public boolean contains(T anEntry);
    
    public T getEntry(int givenPosition);

    public void clear();

    public int getNumberOfEntries();

    public boolean isEmpty();

}
