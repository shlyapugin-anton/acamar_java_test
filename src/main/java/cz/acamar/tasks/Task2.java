package cz.acamar.tasks;

import java.util.Arrays;

public class Task2 {

    /**
     * Task 2. Squares of a sorted array.
     * <p>
     * Given an integer array sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * <p>
     * Example input: [-4,-1,0,3,10]
     * Expected output: [0,1,9,16,100]
     * <p>
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * @param input - an integer array sorted in non-decreasing order
     * @return - an array of the squares of each number sorted in non-decreasing order
     */

    /*
    Algorithm:
    1. split input arr in 2 subarrays: first one with negative numbers, second with nonnegative (0 and positive)
    since we have sorted array, we can do it with O(log(n)) time, n = arr.length
    2. iterate over both arrays simultaneously: on first from the begin, on second from the end (we will fill result arr from the end). Each time
    choose the absolute maximum between 2 current elements in both arrays. Took the maximum value, square it and push to our final array (from the end!)
    3. go to next element in choosen array

    This algorithm will took O(n) time, instead of O(n * log(n)) for trivial algorithm: where we first square all elements and then sort them
    This algorithm a little bit messy, thats the price for more effective calculation. If you prefer more production code, probably less effective,
    in the end I comment the second algorithm. The commented one easier to read/maintain, but more slow: O(log(n)*n) instead of O(n)
     */
    public int[] squaresOfSortedArray(int[] input) {
        int[] result = new int[input.length];
        int currIndex = input.length - 1;          // current index in result

        int leastNonNegativeValueInd = Arrays.binarySearch(input, 0);

        /*
         If we didnt have zero in our array, we'll have here negative number, equals -wantedIndex - 1, so we need to
         make a little reverse
         */
        leastNonNegativeValueInd = leastNonNegativeValueInd > 0 ? leastNonNegativeValueInd : (-1) * leastNonNegativeValueInd - 1;

        if (leastNonNegativeValueInd == 0) {                        // all elem >= 0
            for (int i = 0; i < input.length; i++)
                result[i] = input[i] * input[i];
        } else if (leastNonNegativeValueInd == input.length) {      // all elem < 0
            for (int i = 0; i < input.length; i++)
                result[i] = input[input.length - i - 1] * input[input.length - i - 1];
        } else {
            for (int i = 0; currIndex >= 0; ) {
                for (int j = input.length - 1; currIndex >= 0; ) {
                    int negNumberInArr = -1;
                    int posNumberInArr = -1;
                    /**
                     * Here we process second step: update current values in both arrays to their absolute value
                     */
                    if (i <= leastNonNegativeValueInd - 1)
                        negNumberInArr = (-1) * input[i];
                    if (j >= leastNonNegativeValueInd)
                        posNumberInArr = input[j];

                    if (negNumberInArr >= posNumberInArr) {
                        result[currIndex] = negNumberInArr * negNumberInArr;
                        i++;
                    } else {
                        result[currIndex] = posNumberInArr * posNumberInArr;
                        j--;
                    }
                    currIndex--;
                }
            }
        }

        // Less effective, but more readable code
        /*
        int[] result2 = new int[input.length];
        for (int i = 0; i < input.length; i++)
            result2[i] = input[i] * input[i];
        Arrays.sort(result2);
        return result2;
         */

        return result;
    }
}
