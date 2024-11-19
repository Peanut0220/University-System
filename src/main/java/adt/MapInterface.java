//LimShiLei
package adt;

public interface MapInterface<K, V> {

    public V put(K key, V value);

    public V remove(K key);

    public V get(K key);

    public boolean containsKey(K key);

    public boolean isEmpty();

    public int size();
    
    public LinkedMap.Entry<K, V>[] entrySet();
}
