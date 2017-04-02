package domain;

/**
 * Simple class that wraps around a key and a value. Maybe from a database?
 * @param <K> the "Key"
 * @param <V> the "Value"
 */
public class KeyVal<K, V> {
    private K k;
    private V v;

    public KeyVal(final K k, final V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }
}
