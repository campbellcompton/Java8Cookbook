package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class conversions {

    /**
     * The "Java 8 way" of converting between collections is to use the Stream class.
     * Given that, this file will provide examples of converting from specific implementations of Collection to Stream,
     * and vice-versa.
     */


    /**
     * Converting an Array of a generic non-primitive type into a Stream.
     */
    public <T> Stream<T> arrayToStream(final T[] arr) {
        return Arrays.stream(arr);
    }

    /**
     * Converting an Array of primitive integers to an IntStream, a specialized Stream implementation.
     * This can also be done with "double" (DoubleStream) and "long" (LongStream). For other primitives, you will need
     * to box them into their respective Wrapper class, as shown in the next example.
     */
    public IntStream intArrayToIntStream(final int[] arr) {
        return Arrays.stream(arr);
    }

    /**
     * An example of converting an Array of a primitive into a Stream of its Wrapper class via boxing.
     * Primitive types that need to be boxed into their wrapper class for Stream purposes include: "boolean", "byte",
     * "char", "float", and "short".
     */
    public Stream<Boolean> streamBoxingExample(final boolean[] arr) {
        return IntStream.range(0, arr.length)
                .mapToObj(index -> arr[index]);
    }

    /**
     * Converting from a Collection (List, Set, Queue, Vector, Map.Entry, etc.) into a Stream.
     */
    public <T> Stream<T> collectionToStream(final Collection<T> collection) {
        return collection.stream();
    }

    /**
     * Converting a Map<K, V> into a Stream of Map.Entry.
     * The Stream class can only have one type, so we have two choices: Use Map.Entry or a custom class like our KeyVal.
     */
    public <K, V> Stream<Map.Entry<K, V>> mapToStream(final Map<K, V> myMap) {
        return myMap.entrySet().stream();
    }
}
