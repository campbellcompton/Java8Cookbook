package stream;

import domain.KeyVal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsToCollections {

    /**
     * Converting a Stream to a List.
     */
    public <T> List<T> streamToList(final Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }


    /**
     * Converting a Stream to an Array.
     * I would have liked to have made this function generic, but calling T[]::new would cause warnings.
     */
    public String[] streamToArray(final Stream<String> stream) {
        return stream.toArray(String[]::new);
    }


    /**
     * Converting a Stream of KeyVal (wrapper around two values) into a Map.
     * Note that if there are duplicate keys, an IllegalStateException is thrown. If you want to merge duplicate keys,
     * see the next example.
     */
    public <K, V> Map<K, V> streamToMap(final Stream<KeyVal<K, V>> keyVals) {
        return keyVals.collect(Collectors.toMap(KeyVal::getK, KeyVal::getV));
    }

    /**
     * Converting a Stream of KeyVal<K, Integer> to a Map from K to Integer.
     * In the event of duplicate keys, they are merged together by the BinaryOperator supplied to toMap().
     * I chose Integer as the value for clarity.
     */
    public <K> Map<K, Integer> streamToMapMerging(final Stream<KeyVal<K, Integer>> keyVals) {
        return keyVals.collect(Collectors.toMap(KeyVal::getK, KeyVal::getV, Integer::sum));
    }
}
