package com.devdutt;

public class RainWaterTrappingProblem {

    public static int rainWater(int[] arr) {
        int result = 0;
        if (arr == null || arr.length <= 2) {
            return result;
        }

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        //Scan from left to right
        int max = arr[0];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                left[i] = max;
            } else {
                left[i] = arr[i];
                max = arr[i];
            }//else
        }//for

        //Scan from right to left
        max = arr[arr.length - 1];
        right[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < max) {
                right[i] = max;
            } else {
                right[i] = arr[i];
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            result += (Math.min(left[i], right[i]) - arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {3, 0, 1, 2, 4, 0, 1, 3, 2};
        int result = rainWater(arr);
        System.out.println("Result :- " + result);
    }
}
