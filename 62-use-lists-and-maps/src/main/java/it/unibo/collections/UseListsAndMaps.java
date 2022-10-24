package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int LOWER_LIMIT = 1000;
    private static final int UPPER_LIMIT = 2000;
    private static final int AMOUNT = 100_000;
    private static final int TOTAL_READS = 1000;

    private UseListsAndMaps() {
    }

    static void filler(List<Integer> input) {
        long time = System.nanoTime();
        long millis;
        for(int i = 0; i <= UseListsAndMaps.AMOUNT; i++) {
            input.add(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println ("Time elapsed for " 
        + input.getClass() 
        + ": " 
        + time
        + "ns ("
        + millis
        + "ms)");
    }

    static void reader (List<Integer> input) {
        long time = System.nanoTime();
        long millis;
        for (int i = 0; i <= TOTAL_READS; i++) {
            input.get(input.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println ("Time elapsed for " 
        + input.getClass() 
        + ": " 
        + time
        + "ns ("
        + millis
        + "ms)");
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = UseListsAndMaps.LOWER_LIMIT; i <= UseListsAndMaps.UPPER_LIMIT; i++) {
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> list2 = new LinkedList<>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer temp = list.get(list.size() - 1); //uso l'autoboxing
        list.set(list.size() - 1, list.get(0));
        list.set(list.get(0), temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer elem : list) {
            System.out.print("|" + elem);
        }
        System.out.println("");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        UseListsAndMaps.filler(list);
        UseListsAndMaps.filler(list2);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        UseListsAndMaps.reader(list);
        UseListsAndMaps.reader(list2);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}
