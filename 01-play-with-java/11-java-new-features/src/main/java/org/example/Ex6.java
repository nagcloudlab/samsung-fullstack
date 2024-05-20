package org.example;

import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {

        // parallel array sorting


        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        //Arrays.sort(arr);
        Arrays.parallelSort(arr);
        System.out.printf("Sorted arr[] : %s", Arrays.toString(arr));



    }
}
