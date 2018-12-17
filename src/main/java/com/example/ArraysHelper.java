package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Helper class for array manipulation
 *
 * Created by nara on 12/16/2018.
 */
public class ArraysHelper {
    /*
     * Flattens a nested array of integers
     *
     * @param arr Nested array of integers
     *
     * @return Flattened integer array
     *
     * @throws IllegalArgumentException when the input argument is invalid
     */
    private static Integer[] flatten(Object[] arr) {
        List<Integer> result = new ArrayList<Integer>();

        for (Object item : arr) {
            if (item instanceof Integer) {
                result.add((Integer) item);
            } else if (item instanceof Object[]) {
                result.addAll(Arrays.asList(flatten((Object[]) item)));
            } else {
                throw new IllegalArgumentException("Invalid input arument: Only the integer elements or arrays supported!");
            }
        }

        return result.toArray(new Integer[result.size()]);
    }

    public static void main(String[] args) {
        /*
         * Java does not support nested arrays as Integer data types. As a work around, using
         * Object array.
         */
        Integer[] arr = ArraysHelper.flatten(new Object[] { new Object[] {1,2, new Object[] {3}},4});

        //Prints the result
        Arrays.stream(arr).forEach(System.out::println);
    }
}
