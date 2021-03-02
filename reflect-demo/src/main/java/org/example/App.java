package org.example;

import java.io.Console;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList linkedList = new LinkedList();
        int[] array = {1, 4, 5, 7, 7};
        int[] array1 = {2, 3, 4, 5, 3, 42};
        //int[] ints = Arrays.copyOf(array, 10);
        //System.out.println(Arrays.toString(ints));
        System.arraycopy(array, 0, array1, 3, 1);
        System.out.println(Arrays.toString(array1));
    }
}
