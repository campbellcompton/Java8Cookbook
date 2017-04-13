package stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class UsingStreams {

    /**
     * Filtering a stream by supplying a Predicate (Function that returns a Boolean).
     * Only elements that pass your Predicate will be returned.
     */
    Stream<String> filteringExample() {
        return Stream.of("apples", "bananas", "oranges", "plantains", "grapes", "papayas")
                .filter(string -> string.length() < 6);
        // yields only "apples" and "grapes"
    }


    /**
     * Map applies a Function (String->String) to each element of the stream. In this case, pig latin!
     * Use this to manipulate elements of your Stream.
     */
    Stream<String> mapExample() {
        return Stream.of("north", "bamboozle", "jump")
                .map(string -> string.substring(1) + string.substring(0, 1).toUpperCase() + "ay");
        // yields "orthNay", "amboozleBay", "umpJay"
    }


    /**
     * ForEach applies a Consumer function (String -> void).
     * Use this to write side-affecting code if needed.
     */
    void forEachExample() {
        Stream.of("important", "documents", "to", "print")
                .forEach(System.out::println);
        // yields nothing. forEach() returns void.
    }


    /**
     * distinct() returns only unique elements of the Stream, preserving the order in which they were encountered.
     */
    void distinctExample() {
        Stream.of(1, 2, 5, 3, 2, 1, 2, 1, 2, 2, 1)
                .distinct();
        // yields only 1, 2, 5, 3
    }


    /**
     * limit(int x) returns only the first x elements of the Stream.
     * This can be useful to pick the "top" result(s), maybe after a sort or filter?
     */
    Stream<String> limitExample() {
        return Stream.of("first", "second", "third", "fourth")
                .limit(2);
        // yields only "first" and "second".
    }


    /**
     * sorted() will sort your Stream<T> by using T's comparator.
     * Note that if T is not comparable, a ClassCastException may be thrown.
     */
    Stream<String> sortingExample() {
        return Stream.of("zapp", "yorp", "xoph")
                .sorted();
        // yields "xoph", "yorp", "zapp", as String's comparator is lexicographic.
    }


    /**
     * sorted(Comparator comparator) allows you to supply your own Comparator to sort your Stream.
     * In this case, we're sorting by ascending String length.
     */
    Stream<String> sortingWithCustomComparatorExample() {
        return Stream.of("blooper", "blips", "blap")
                .sorted((str1, str2) -> str1.length() - str2.length());
        // yields "blap", "blips", "blooper".
    }


    /**
     * Collapsing multi-dimensional Streams via flatMap().
     */
    Stream<String> flatMapExample() {
        return Stream.of(Stream.of("a1", "a2", "a3"), Stream.of("b1", "b2", "b3"), Stream.of("c1", "c2", "c3"))
                .flatMap(Function.identity());
        // yields "a1", "a2", "a3", "b1", "b2", ...
    }


    /**
     * skip(long n) will skip the first n elements.
     */
    Stream<String> skipExample() {
        return Stream.of("bad", "good", "also good")
                .skip(1);
        // yields "good", "also good"
    }

}
