/** 
 * NOTE: Some of the solutions I've completed on Leetcode have implemented various algorithms. For instance, rather 
 * than just calling foo.sort(), I'll implement some sorting algorithm to work throughout the whole solution. This might be 
 * based on, say, a certain sorting algorithm that I know at that time and I view that as practice. I understand I'll take 
 * hits in areas on Leetcode that are evaluated, like time complexity, but I'm okay with that for now as long as I'm improving
 * while also asking myself questions like, "What sort method would be best here and why is this one so slow" and "why is this
 * solution so terrible!" All jokes aside, I understand that it would be easier, quicker, and arguably more productive to just
 * call an operation but my goal with leetcode boils down to improving my problem solving skills, algorithm and data 
 * structure implementation, as well as understanding when and where to use the right algorithms and data structures. Most 
 * importantly, my goal is to see improvement as I complete solutions. So, solutions completed 3 months from today should be 
 * better than solutions completed today and I should gradually work my way through different levels of coding problems. 
 * 
 * @author Wali Morris<walimmorris@gmail.com>
 */

/**
 * Given a non-empty, singly linked list with head node "head", 
 * return a middle node of linked list
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 * Definition for singly-linked list
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * NOTE: This solution works okay in Java because of garbage collection. 
 * When middleNode() function points to next node, deleting the preceding 
 * node, Java recognizes these deleted nodes are no longer in use and 
 * this memory will be freed up. This works fine in Java but may need 
 * better implementation in languages like C or C++
 *
 * @author Wali Morris
 */

import java.util.*;

class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        int listSize = getSize(head); // get the size of LinkedList 
        if ( listSize == 1 ) {
            return head; // lists of size 1 should be returned as is, no middle node
        }
        ListNode current = head;
        int i = 1;
        while ( i < listSize / 2 + 1 ) { // delete front of node until reach middle of list 
            current = current.next; // points to next node, deleting the preceding node 
            i++;
        }
        return current;
    }

    /* iterates through LinkedList and counts number of nodes */
    public static int getSize(ListNode list) {
        int count = 0;
        ListNode current = list;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}

/**
 * Given an array of Integers arr, write a function that returns true if
 * and only if the num of occurrences of each value in array is unique
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class UniqueNumOfOccurrences {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 2, 1, 1, 3};
        int[] input2 = {1, 2};
        int[] input3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        int[] input4 = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,
                        20, 16,17,16,2,16,20,26,16};
        boolean output1 = uniqueOccurrences(input1);
        boolean output2 = uniqueOccurrences(input2);
        boolean output3 = uniqueOccurrences(input3);
        boolean output4 = uniqueOccurrences(input4);
        System.out.println(Arrays.toString(input1) + ": " + output1);
        System.out.println(Arrays.toString(input2) + ": " + output2);
        System.out.println(Arrays.toString(input3) + ": " + output3);
        System.out.println(Arrays.toString(input4) + ": " + output4);
    }
    
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        /* count number of occurrences for a each num in a and store in Map */
        for ( int i = 0; i < arr.length; i++) {
            if ( numberMap.containsKey(arr[i]) ) {
                int val = numberMap.get(arr[i]);
                numberMap.put(arr[i], val+1);
            } else {
                numberMap.put(arr[i], 1);
            }
        }
        /* get collection of values, dump into set and compare size */
        Collection<Integer> valuesList = numberMap.values();
        Set<Integer> valuesSet = new HashSet<>(valuesList);
        if (valuesSet.size() == valuesList.size() ) {
            return true;
        }
        return false;
    }
}

/* In a array A of size 2N, there are N+1 unique elements, and exactly one of 
 * these elements is repeated N times. Return the element repeated N times. 
 *
 * Author : Wali Morris 
 * File   : RepeatedN.java
 * Date   : 4/01/2020
 *
 * NOTES  : This algorithm initializes a HashMap data structure to hold key value pairs. 
 *          To implement this data structure and find the repeated number we must iterate
 *          through the given array. In this case the key in the map is the integer value 
 *          from the array and the key-value is the number of times the key is seen within
 *          the array, this is initialized as count. If the key already exists within the 
 *          map, this means this is the repeated key, so return this key. If there are no 
 *          repeated keys, this repeatedN() will return 0. The time complexity of this 
 *          algorithm is O(N) because we are iterating through each value N of the array 
 *          only once. The worse case is O(N) because we may have to iterate through every 
 *          value before we find a repeated value N.
 */

import java.util.*;

public class RepeatedN {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3};
        int output = repeatedN(input);
        System.out.println("The repeated element is: " + output);
    }
    
    public static int repeatedN(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num : array ) { // iterate values in array    
            int key = num; // every number in array, call it key
            int count = 1;  // give this key a count equal to 1
            if ( map.containsKey(key) ) { // check the map, does it already contain this key?
                return key; // yes? This key is repeated, return this key
            } else {
                map.put(key, count); // no, put this key in map, with value of count
            }
        }
        return 0; // there are no repeated numbers 
    }
}

/* Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1. 
 * The linked list holds the binary representation of a number. 
 * Return the decimal value of the number in the linked list. 
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 *
 * Author : Wali Morris 
 * File   : ConvertBinary.java
 * Date   : 03/10/2020
 */

import java.util.*;

public class ConvertBinary {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        int output = getDecimalValue(head);
        System.out.println("result: " + output);
    }

    public static int getDecimalValue(ListNode head) {
        ListNode current = head; // current refers to ListNode head 
        Stack<Integer> keys = new Stack<>(); // create stack to use LIFO convention
        while ( current != null ) {
            keys.add(current.val); // populate stack
            current = current.next;
        }

        /* Binary sequences are read from left to right start at 2^0 to 2^lengthi-1 of sequence.
         * Reading the sequence in reverse due to stack we can subtract 1 from count, accounting
         * for 0 indexing. Ignore all zeros in binary sequence and only account for the 1's. 
         * Adding this gives the decimal value of the sequence. 
         */
        int count = keys.size() - 1;
        int decimal = 0;        
        for ( Integer key: keys ) {
            if ( key == 0 ) { 
                count--;  
                continue;  
            } else { 
                decimal += Math.pow(2, count); 
            } 
            count--; 
        }
        return decimal; 
    } 
} 

/* Given a sorted(in ascending order) integer array nums of n elements 
 * and a target value, write a function to search target in nums. If 
 * target exists, then return its index, otherwise return -1
 *
 * Author : Wali Morris 
 * File   : BinarySearch.java
 * Date   : 03/04/2020
 */

public class BinarySearch {
    public static void main(String[] args) {
        // test 1
        int[] input1 = {-1, 0, 3, 5, 9, 12};
        int key1 = 9;
        int output1 = search(input1, key1);
        System.out.println("Key is at index: " + output1);

        // test 2
        int[] input2 = {-1, 0, 3, 5, 9, 12};
        int key2 = 2;
        int output2 = search(input2, key2);
        System.out.println("Key is at index: " + output2);

        // test 3
        int[] input3 = {1, 4, 7, 9, 11, 13, 15, 16, 21, 55, 66, 68, 99, 123, 156, 202};
        int key3 = 21;
        int output3 = search(input3, key3);
        System.out.println("Key is at index: " + output3);
    }

    public static int search(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (high + low) / 2;
            if( nums[mid] == key) {
                return mid;
            } else if(key < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

/* We are given a list nums of integers representing a list compressed with 
 * run-length encoding. Consider each adjacent pair of elements. For each such
 * pair, there are freq elements with value concatenated in sublist. Concatenate
 * all the sublists from left to right to generate the decompressed list. 
 * Return the decompressed list. 
 *
 * Author : Wali Morris 
 * File   : Decompress.java
 * Date   : 03/07/2020
 */

import java.util.*;

import java.util.*;

// A client program to test Decompress method
public class Decompress {
    public static void main(String[] args) {
        // test 1
        int[] input1 = {1, 2, 3, 4};
        int[] output1 = decompressList(input1);
        System.out.println(Arrays.toString(output1));
        // test2 
        int[] input2 = {1, 1, 2, 3};
        int[] output2 = decompressList(input2);
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] decompressList(int[] compressedList) {
        if ( compressedList.length % 2 != 0 ) {
            throw new IllegalArgumentException("List is unbalanced");
        }
        ArrayList<Integer> valueList = new ArrayList<>();
        for ( int i = 0; i < compressedList.length-1; i+=2) {
            int freq = compressedList[i];
            int value = compressedList[i+1];
            for (int j = 0; j < freq; j++) {
                valueList.add(value);
            }
        }
        int[] decompressedList = new int[valueList.size()];
        int k = 0;
        for ( int val: valueList ) {
            decompressedList[k] = val;
            k++;
        }
        return decompressedList;
    }
}

/* Given a binary matrix A, we want to flip the image horizontally, then 
 * invert it, and return the resulting image. 
 * A very awkward solution.
 *
 * Author : Wali Morris 
 * File   : FlipBinaryMatrix.java
 * Date   : 03/09/2020
 */

/* Given a m * n matrix grid which is sorted in non-decresing order both row-
 * wise and column-wise. return the number of negative numbers in grid. 
 *
 * Author : Wali Morris 
 * File   : NegativeMatrixNums.java
 * Date   : 03/11/2020
 */

import java.util.*;

public class NegativeMatrixNums {
    public static void main(String[] args) {
        int[][] input = new int[4][4];
        input[0][0] = 4;
        input[0][1] = 3;
        input[0][2] = 2;
        input[0][3] = -1;
        input[1][0] = 3;
        input[1][1] = 2;
        input[1][2] = 1;
        input[1][3] = -1;
        input[2][0] = 1;
        input[2][1] = 1;
        input[2][2] = -1;
        input[2][3] = -2;
        input[3][0] = -1;
        input[3][1] = -1;
        input[3][2] = -2;
        input[3][3] = -3;
        System.out.println("The array: " + Arrays.deepToString(input));
        int output = countNegatives(input);
        System.out.println("Negative Count: " + output );
    }
    
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[i].length; j++ ) {
                if (grid[i][j] < 0 ) {
                    count++;
                }
            }
        }
        return count;
    }
}

import java.util.*;

public class FlipBinaryMatrix {
    // test case: pass  
    public static void main(String[] args) {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 1;
        input[0][2] = 0;
        input[1][0] = 1;
        input[1][1] = 0;
        input[1][2] = 1;
        input[2][0] = 0;
        input[2][1] = 0;
        input[2][2] = 0;
        System.out.println("Original Matrix: " + Arrays.deepToString(input));
        int[][] myMatrix = flipAndInvert(input);
        System.out.println("Final Matrix: " + Arrays.deepToString(myMatrix));
    }

    public static int[][] flipAndInvert(int[][] a) {
        int[][] flippedMatrix = invert(a); // invert  
        int[][] finalMatrix = flip(flippedMatrix); // flip
        return finalMatrix;
    }
    
    public static int[][] flip(int[][] a) {
        // push reversed values onto stack 
        Stack<Integer> matrixKeys = new Stack<>();
        for ( int i = 0; i < a.length; i++) {
            for ( int j = a[i].length-1; j >= 0; j--) {
                matrixKeys.push(a[i][j]);
            }
        }
        // create new array and pop matrix keys to this array 
        int k = 0;
        int[][] flippedMatrix = new int[a.length][a[k].length];
        for ( k = 0; k < a.length; k++) {
            for( int n = 0; n < a[k].length; n++) {
                flippedMatrix[k][n] = matrixKeys.pop();
            }
        }
        return flippedMatrix;
    }
    
    public static int[][] invert(int[][] a) {
        // push inverted values onto stack 
        Stack<Integer> matrixKeys = new Stack<>();
        for ( int i = 0; i < a.length; i++) {
            for ( int j = 0; j < a[i].length; j++) {
                if ( a[i][j] == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = 0;
                }
                matrixKeys.push(a[i][j]);
            }
        }
        // pop inverted values into new array 
        int i = 0;
        int[][] invertedMatrix = new int[a.length][a[i].length];
        for ( i = 0; i < a.length; i++) {
            for ( int j = 0; j < a[i].length; j++) {
                invertedMatrix[i][j] = matrixKeys.pop();
            }
        }
        return invertedMatrix;
    }
}

/* Given a non-negative integer num, return the number of steps 
 * to reduce it to zero. If the current number is even, you have 
 * to divide it by 2, otherwise, you have to subtract 1 from it.
 *
 * Author : Wali Morris
 * Date   : 02/28/2020
 * File   : ReduceZero.java
 */

class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num > 0) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }
}

/* Given an array of integers, return indices of the two 
 * numbers such that they add up to a specific target.
 *
 * Author : Wali Morris 
 * File   : TwoSum.java
 * Date   : 02/28/2020
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int[] finalArr;
                if(nums[i] + nums[j] == target) {
                    return finalArr = new int[]{i, j};
                }
            }
        }
        return null;
    }
}

/* Given a valid (IPv4) IP address, return a defanged version of that IP 
 * address. A defanged IP address replaces every "." with "[.]"
 *
 * Author : Wali Morris
 * File   : Defang.java
 * Date   : 02/27/2020 
 */

public class Defang {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String returnAddr = defangIPaddr(address);
        System.out.println(returnAddr);
    }

    public static String defangIPaddr(String address) {
        String newAddr = "";
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                newAddr += "[.]";
                continue;
            }
            newAddr += address.charAt(i);
        }
        return newAddr;
    }
}

/* Given an array nums of integers, return how many of them contain 
 * an even number of digits. 
 *
 * Author : Wali Morris 
 * File   : EvenNumOfDigits.java 
 * Date   : 01/28/2020 
 */

public class EvenNumOfDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        int result = findNumbers(nums);
        System.out.println("Result: " + result);
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        String numStr = "";
        for(int i = 0; i < nums.length; i++) {
            numStr = Integer.toString(nums[i]);
            if(numStr.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}

/* You're given strings J representing the types of stones that
 * are jewels, and S representing the stones you have. Each 
 * character in S is a type of stone you have. You want to know 
 * how many of the stones you have are also jewels. 
 *
 * Author : Wali Morris
 * File   : JewelsAndStones.java
 * Date   : 02/28/2020
 */

public class JewelsAndStones {
    public static void main(String[] args) {
        // test 1
        String j = "aA";
        String s = "aAAbbbb";
        int jewels = jewelsInStones(j, s);
        System.out.println("Number of Jewels in Stone collection: " + jewels);

        // test 2
        String a  = "z";
        String b = "ZZ";
        int jewels1 = jewelsInStones(a, b);
        System.out.println("Number of Jewels in Stone collection: " + jewels1);
    }

    public static int jewelsInStones(String j, String s) {
        int jewels = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int k = 0; k < j.length(); k++) {
                if(s.charAt(i) == j.charAt(k)) {
                    jewels++;
                }
            }
        }
        return jewels;
    }
}

/* Given an integer number n, return the difference between the
 * product of its digits and the sum of its digits. 
 *
 * Author : Wali Morris 
 * File   : ProductAndSumi.java
 * Date   : 02/27/2020 
 */

class ProductAndSum {
    public static void main(String[] args) {
        // test 1
        int n = 234;
        int result1 = subtractProductAndSum(n);
        System.out.println("The Product - the sum of " + n + " is: " + result1);

        // test 2
        int m = 4421;
        int result2 = subtractProductAndSum(m);
        System.out.println("The Product - the sum of " + n + " is: " + result2);
    }

    public static int subtractProductAndSum(int n) {
        String numStr = Integer.toString(n);
        int product = 1;
        int sum = 0;
        int result;
        for(int i = 0; i < numStr.length(); i++) {
            product *= Character.getNumericValue(numStr.charAt(i));
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return result = product - sum;
    }
}

/* Implement function ToLowerCase() that has a string parameter str, and 
 * returns the same string in lowercase. 
 *
 * Author: Wali Morris
 * File  : ToLowerCase.java
 * Date  : 02/29/2020 
 */

public class ToLowerCase {
    public static void main(String[] args) {
        String input = "LOVELY";
        String output = toLowerCase(input);
        System.out.println("Output: " + output);
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}

/* Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decresing order. 
 *
 * Author : Wali Morris
 * File   : SortedSquares.java
 * Date   : 02/29/2020 
 */

import java.util.*;

public class SortedSquares {
    public static void main(String[] args) {
        // test1
        int[] input1 = {-4, -1, 0, 3, 10};
        int[] output1 = sortedSquares(input1);
        System.out.println(Arrays.toString(output1));

        // test2
        int[] input2 = {-7, -3, 2, 3, 11};
        int[] output2 = sortedSquares(input2);
        System.out.println(Arrays.toString(output2));

    }
    
    public static int[] sortedSquares(int[] a) {
        int[] arr = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            arr[i] = a[i] * a[i]; // get the squares 
        }
        // compare each value for the length of array
        for(int j = 0; j < arr.length; j++) {
            for(int k = 0; k < arr.length; k++) {
                if(arr[k] > arr[j]) { // is value greater?
                    int temp = arr[j]; // yes? 
                    arr[j] = arr[k]; // move greater value to right
                    arr[k] = temp; // lesser value to left
                }
            }
        }
        return arr;
    }
}

/* Given an array A of non-negative integers, return an array consisting of all 
 * the even elements of A, followed by all the odd elements of A.
 *
 * Explain: This solution impliments a bubble sort algorithm. A given array can be 
 * unsorted, so we'll have to view every value in it. If the value being examined 
 * is not even sink it to the bottom of the list and move it right.   
 *
 * Author : Wali Morris 
 * File   : SortedParity.java
 * Date   : 02/29/2020 
 */

import java.util.*;

public class SortedParity {
    public static void main(String[] args) {
        // test 1
        int[] input1 = {3, 1, 2, 4};
        int[] output1 = sortArrayByParity(input1);
        System.out.println("Result: " + Arrays.toString(output1));

        // test 2
        int[] input2 = {11, 12, 10, 8, 22, 33, 44, 2, 1, 5, 6};
        int[] output2 = sortArrayByParity(input2);
        System.out.println("Result: " + Arrays.toString(output2));

    }

    public static int[] sortArrayByParity(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-1-i; j++) {
                if(a[j] % 2 != 0) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}

/* Given the array nums, for each nums[i] find out how many numbers in the 
 * array are smaller than it. 
 *
 * Author : Wali Morris 
 * File   : SmallerThanCurrent.java
 * Date   : 03/01/2020
 */

import java.util.*;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] input1 = {8, 1, 2, 2, 3};
        int[] output1 = smallerThanCurrent(input1);
        System.out.println("Result: " + Arrays.toString(output1));
    }

    public static int[] smallerThanCurrent(int[] a) {
        int[] newArr = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            int count = 0;
            for(int j = 0; j < a.length; j++) {
                if(a[i] > a[j]) {
                    count++;
                }
            }
            newArr[i] = count;
        }
        return newArr;
    }
}

/* Write a function that reverses a string. The input string is given as an 
 * array of characters char[]
 *
 * Do not allocate extra space for another array, you must do this by modifying 
 * the input array in-place with O(1) extra memory. 
 *
 * Author : Wali Morris 
 * File   : ReverseString.java
 * Date   : 03/02/2020
 */

import java.util.*;

class ReverseString {
    public static void main(String[] args) {
        char[] input1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(input1);
        char[] input2 = {'z', 'e', 'b', 'r', 'a'};
        reverseString(input2);
        char[] input3 = {'w', 'a', 't', 'e', 'r', 'b', 'o', 't', 't', 'l', 'e'};
        reverseString(input3);
    }
    /* eventually ints i and j will meet in the middle of string[int], at this point
     * all letters will have been replaced. Except for the middle letter. */
    public static void reverseString(char[] s) {
        int j = 0;
        for(int i = s.length - 1; i >= j; i--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j++;
        }
        System.out.println(Arrays.toString(s));
    }
}

* Given an array arr, replace every element in that array with the 
 * greatest element among the elements to its right, and replace the 
 * last element with -1
 *
 * Author : Wali Morris 
 * File   : ToTheRight.java
 * Date   : 03/03/2020
 */

import java.util.*;

public class ToTheRight {
    public static void main(String[] args) {
        // test 1 
        int[] input1 = {17, 18, 5, 4, 6, 1};
        int[] output1 = replaceElements(input1);
        System.out.println(Arrays.toString(output1));

        // test 2
        int[] input2 = {3, 4, 5, 1, 3, 1};
        int[] output2 = replaceElements(input2);
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] replaceElements(int[] a) {
        for(int i = 0; i < a.length-1; i++) {
            int key = a[i];
            for(int j = i+1; j < a.length; j++) {
                if(a[j] > key) {
                    key = a[j];
                }
            }
            a[i] = key;
            a[i+1] = 0;
        }
        a[a.length-1] = -1;
        return a;
    }
}

/* We are given two strings A and B. A shift on A consists of taking
 * string A and moving the leftmost character to the rightmost position.
 * Return true if and only if A can become B after some number of shifts
 * on A. 
 *
 * Author : Wali Morris 
 * File   : RotateString.java
 * Date   : 03/04/2020
 */

import java.util.*;

public class RotateString {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "cdeab";
        boolean output = rotateString(a, b);
        System.out.println("Output: " + output);

        String c = "abcde";
        String d = "abced";
        boolean output2 = rotateString(c, d);
        System.out.println("Output: " + output2);

        String e = "";
        String f = "";
        boolean output3 = rotateString(e, f);
        System.out.println("Output: " + output3);
    }
    
    public static boolean rotateString(String a, String b) {
        if(a.length() != b.length()) { // if string are equal continue, else they'll never match 
            return false;
        } else if(a.equals(b)) { // your lucky, strings already match, return true 
            return true;
        } else {
            // since strings are equal create char arrays for both strings
            char[] strA = new char[a.length()];
            char[] strB = new char[b.length()];
            for(int i = 0; i < a.length(); i++) {
                strA[i] = a.charAt(i);
                strB[i] = b.charAt(i);
            }
            char temp;
            int count = 0;
            while(count < strA.length) { // roatate all chars in the array
                temp = strA[0]; // hold first character in array
                for(int i = 0; i < strA.length - 1; i++) {
                    strA[i] = strA[i+1];  // rotate characters left
                }
                strA[strA.length-1] = temp; // append held character to end
                if(Arrays.equals(strA, strB)) { // do the arrays match?
                    return true;
                }
                count++;
            }
        }
        return false;
    }
}

/* Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings. 
 *
 * Author : Wali Morris 
 * File   : BalancedStrings.java
 * Date   : 02/5/2020 
 */

import java.util.*;

public class BalancedStrings {
    public static void main(String[] args) {
        // test 1
        String a = "RLRRLLRLRL";
        int resultSequence1 = balancedStringSplit(a);
        System.out.println("How many balanced RL sequences are there: " + resultSequence1);

        // test 2
        String b = "RLLLLRRRLR";
        int resultSequence2 = balancedStringSplit(b);
        System.out.println("How many balanced RL sequences are there: " + resultSequence2);

        // test 3
        String c = "LLLLRRRR";
        int resultSequence3 = balancedStringSplit(c);
        System.out.println("How many balanced RL sequences are there: " + resultSequence3);

        // test 4
        String d = "RLRRRLLRLL";
        int resultSequence4 = balancedStringSplit(d);
        System.out.println("How many balanced RL sequences are there: " + resultSequence4);
    }
    
    public static int balancedStringSplit(String s) {
        StringBuffer str = new StringBuffer(s); // create new string buffer for insertion of comma
        int count = str.length(); // length will change, for equal sequences
        int rCount = 0;
        int lCount = 0;
        for(int i = 0; i < count-1; i++) {
            if(str.charAt(i) == 'L') {
                lCount++;
            } else if(str.charAt(i) == 'R') {
                 rCount++;
            }
            if(rCount == lCount) {
                str.insert(i+1, ","); // insert comma after RL sequence 
                i++; // increment i to account for "," insertion 
                count++; // increment count or length of str to account for "," insertion
                
                // restart 'R' and 'L' char counts      
                rCount = 0;
                lCount = 0;
            }
        }
        // use toString() method of String buffer object
        int numCommas = 0, j = 0;
        String newStr = str.toString() + ','; // comma signifies end of sequence
        System.out.print("Split: " + newStr + " ");
        while(j < newStr.length()) {
            if(newStr.charAt(j) == ',') { // every comma means there's a equal sequence 
                numCommas++;
            }
            j++;
        }
        return numCommas; // number of commas equals number of even RL sequences        
    }
}

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all 
 * elements in arr2 are also in arr1
 *
 * Sort the elements of arr1 such that the 
 * relative ordering of itmes in arr1 are the same as in arr2
 *
 * Elements that 
 * don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] input1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] input2 = {2, 1, 4, 3, 9, 6};
        int[] input3 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] input4 = {2, 42, 38, 0, 43, 21};
        int[] output = relativeSortArray(input1, input2);
        int[] output2 = relativeSortArray(input3, input4);
        System.out.println("Final Array: " + Arrays.toString(output));
        System.out.println("Final Array: " + Arrays.toString(output2));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> numbers = new HashMap<>(); // map to count occurances of each number in arrays
        ArrayList<Integer> list = new ArrayList<>(); // list to hold the numbers in arr1 that are in arr2
        ArrayList<Integer> list2 = new ArrayList<>(); // list to hold numbers in arr1 that are not in arr2
        for ( int num : arr1 ) { // count keys in arr1 and give a value for every occurance
            if ( numbers.containsKey(num) ) {
                int count = numbers.get(num);
                numbers.put(num, count + 1);
            } else {
                numbers.put(num, 1);
            }
        }
        /* Tree map sorts the keys so now we are in sorted order. At this 
         * point we will compare arr2, and our values in the TreeMap. If the 
         * value appears in arr2 we will store that value in a set for the 
         * number of times indicated by that keys value. The remaining keys 
         * are in sorted order and we will apend them to the end of the array.
         */

        for ( int n : arr2 ) {
            if ( numbers.containsKey(n) ) {
                for (int i = 0; i < numbers.get(n); i++ ) {
                    list.add(n);
                }
            }
        }
        // send numbers not in arr2 to list 2
        for ( int j : arr1 ) {
            if ( !list.contains(j) && !list2.contains(j) ) {
                for (int k = 0; k < numbers.get(j); k++ ) {
                    list2.add(j);
                }
            }
        }
        // sort list 2 before appending to list 1
        Collections.sort(list2);
        for ( int n : list2 ) {
            list.add(n);
        }
        // add the numbers in the set to final array
        Iterator<Integer> iter = list.iterator();
        int arrSize = list.size();
        int[] outputArr = new int[arrSize];
        int i = 0;
        while ( iter.hasNext() ) {
            int value = iter.next();
            outputArr[i] = value;
            i++;
        }
        return outputArr;
    }
}

/**
 * Given an array of intergers arr, a lucky integer is an integer which has a 
 * frequency in the array equal to its value 
 *
 * Return a lucky integer in the array
 *
 * If there are multiple lucky integers return the largest of them
 * If there is no lucky integer return -1
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] input1 = {2, 2, 3, 4};
        int[] input2 = {1, 2, 2, 3, 3, 3};
        int[] input3 = {2, 2, 2, 3, 3};
        int[] input4 = {5};
        int[] input5 = {7, 7, 7, 7, 7, 7, 7};
        int output1 = findLucky(input1);
        int output2 = findLucky(input2);
        int output3 = findLucky(input3);
        int output4 = findLucky(input4);
        int output5 = findLucky(input5);
        System.out.println(Arrays.toString(input1) + ": " + output1);
        System.out.println(Arrays.toString(input2) + ": " + output2);
        System.out.println(Arrays.toString(input3) + ": " + output3);
        System.out.println(Arrays.toString(input4) + ": " + output4);
        System.out.println(Arrays.toString(input5) + ": " + output5);
    }
    public static int findLucky(int[] array) {
        ArrayList<Integer> luckyList = new ArrayList<>(); // holds lucky numbers
        Map<Integer, Integer> luckyMap = new HashMap<>(); // count of numbers
        for ( int n : array ) { // iterate array to store key: value pairs in hashmap
            if ( luckyMap.containsKey(n) ) { // map contains n?
                int count = luckyMap.get(n); // yes. increase key's value count by 1
                luckyMap.put(n, count+1); // store key:value back into map
            } else {
                luckyMap.put(n, 1); // no. store new key(n) and value 1
            }
        }
        // find lucky numbers to store in lucky list
        for ( int key : luckyMap.keySet() ) { // iterate luckyMap's keys
            int value = luckyMap.get(key); // get each keys value
            if ( value == key ) { // are value and key equal?
                luckyList.add(key); // yes, add key to luckyList
            }
        }
        if ( luckyList.size() == 1 ) {
            return luckyList.get(0); // return only value in lucky list 
        } else {
            if (luckyList.size() > 1 ) {  // get the greatest value in lucky list 
                int greatestNum = luckyList.get(0);
                for ( int num : luckyList ) {
                    if ( num > greatestNum ) {
                        greatestNum = num;
                    }
                }
                return greatestNum;
            }
        }
        return -1; // no value, return -1 
    }
}

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order. 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class ReverseWord3 {
    public static void main(String[] args) {
        String input = "Let's take Leetcode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }

    public static String reverseWords(String s) {
        String[] split = s.split("\\s");
        List<String> words = new ArrayList<>();
        for (int i = 0; i < split.length; i++ ) {
            words.add(split[i]); // add each split word into an ArrayLIst
        }
        String reverse = "";
        for ( int i = 0; i < words.size(); i++ ) { // get each split word from list and concatenate it's reverse
            String str = words.get(i);
            String reversedStr = reverseSingleWord(str);
            if ( i < words.size() - 1 ) {
                 reverse += reversedStr + " ";
            } else { // don't add space at the end of reverse String
                 reverse += reversedStr;
            }
        }
        return reverse;
    }
    
    /* helper function to reverse individual words from String */
    public static String reverseSingleWord(String word) {
        String finishedWord = "";
        Stack<Character> str = new Stack<>();
        for(int i = 0; i < word.length(); i++ ) {
            char n = word.charAt(i);
            str.push(n); // push onto stack 
        }
        while (!str.isEmpty()) { // reverse order of String
            char p = str.pop();
            finishedWord += p;
        }
        return finishedWord;
    }
}

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the 
 * matrix in any order
 *
 * A lucky number is an element of the matrix such that it is the minimum 
 * element in its row and maximum in its column 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class LuckyMatrixNumber {
    public static void main(String[] args) {
        int[][] input = new int[3][4];
        input[0][0] = 1;
        input[0][1] = 10;
        input[0][2] = 4;
        input[0][3] = 2;
        input[1][0] = 9;
        input[1][1] = 3;
        input[1][2] = 8;
        input[1][3] = 7;
        input[2][0] = 15;
        input[2][1] = 16;
        input[2][2] = 17;
        input[2][3] = 12;
        List<Integer> output = luckyNumbers(input);
        System.out.println(output);
    }
    
    public static List<Integer> luckyNumbers(int[][] matrix) {
        /* rowLow : stores lowest numbers in each row
         * columnHigh : stores highest numbers each column 
         */
        List<Integer> rowLow = new ArrayList<>();
        List<Integer> columnHigh = new ArrayList<>();
        // find the lowest number in each row
        for (int i = 0; i < matrix.length; i++) {
            int least = matrix[i][0]; // least begins as first nnumber in each row
            for (int j = 0; j < matrix[i].length; j++) {  // iterate each number in row
                int rowNum = matrix[i][j];
                if (rowNum < least) {
                    least = rowNum;// lowest number in row becomes least
                }
            }
            rowLow.add(least); // add lowest number of each row to rowLow list          
        }
        // find the highest numbers in each column
        int k = 0;
        /* case: this while loop assumes all rows in any matrix is the same length */
        while (k < matrix[0].length) { // while k is less than length of each row in matrix
            int highCol = matrix[0][k];// highest number in column begins as the first number in each column    
            for (int i = 0; i < matrix.length; i++) { // iterate for the length of column 
                int colNum = matrix[i][k];
                if (colNum > highCol) {
                    highCol = colNum; // highest number in column becomes highCol
                }
            }
            columnHigh.add(highCol); // add highest number of each column 
            k++;
        }
        /* take rowLow list and dump into a new set, create a new array to store lucky numbers,
         * compare numbers in columnHigh array list to the numbers in row Set. If the columnHigh
         * number is found in row Set, store as a lucky number
         */
        Set<Integer> row = new HashSet<>(rowLow);
        List<Integer> luckies = new ArrayList<>();
        for (Integer num : columnHigh) {
            if (row.contains(num) ) {
                luckies.add(num);
            }
        }
        return luckies;
    }
}

/** 
 * Given a string S of lowercase letters, a duplicate removal consists
 * of choosing two adjacent and equal letters, and removing them
 *
 * We repeatedly make duplicate removals on S until we no longer can 
 *
 * @return the final string after all such duplication removals have 
 * been made
 *
 * It's guaranteed the answer is unique 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class AdjacentDuplicates {
    public static void main(String[] args) {
        String input1 = "abbaca";
        String input2 = "cxxaacy";
        String output1 = removeDuplicates(input1);
        String output2 = removeDuplicates(input2);
        System.out.println(output1);
        System.out.println(output2);
    }

    public static String removeDuplicates(String s) {
        if ( s.length() == 0 )
            return " "; // empty string, return empty string 
        boolean containsDuplicates = true;
        int count = 0;
        while ( containsDuplicates == true ) {
            /* iterate the string, find duplicates and remove as sub 
             * string, iterate count if this occurs */
            for ( int i = 0; i < s.length() - 1; i++ ) { 
                if ( s.charAt(i) == s.charAt(i+1) ) { 
                    String sub = String.valueOf(s.charAt(i)); 
                    sub += sub;
                    s = s.replaceFirst(sub, "");
                    count++;
                }
            }
            if ( count == 0 ) { // initiates flag and if true exits loop
                containsDuplicates = false;
            } else { // continues loop until no duplicates exist
                count = 0;
            }
        }
        return s;
    }
}

/**
 * Given two arrays of integers nums and index, create a target array 
 * 
 * Initially target array is empty
 * From left to right read nums[i] and index[i], insert at index index[i]
 * the value nums[i] in target array 
 *
 * @return The target array
 * 
 * @author Wali Morris 
 */

import java.util.*;

public class TargetArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] output = createTargetArray(nums, index);
        System.out.println(Arrays.toString(output));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        /* even in duplicate index[i], the List will be shifted right to 
         * compensate for new insertion */
        for(int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        // populate the final target array with items int items in list
        int[] target2 = new int[nums.length];
        for(int j = 0; j < nums.length; j++ ) {
            target2[j] = target.get(j);
        }
        return target2;
    }
}

/**
 * International Morse Code defines a standard encoding where each letter is 
 * mapped to a series of dots and dashes
 *
 * Given a list of words, each word can be written as a concatenation of the 
 * Morse code of each letter, this will be called a transformation of a word
 *
 * Return the number of different transformations among all words we have 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class MorseCode {
    public static void main(String[] args) {
        String[] input = {"gin", "zen", "gig", "msg"};
        int output = uniqueMorseRepresentations(input);
        System.out.println(output);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        /* Stores decoded map, this would preferrably come from an outside 
         * class rather than building in this method */
        Map<Character, String> codes = new HashMap<>(); 
        List<String> decodedList = new ArrayList<>();   
        String[] values = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", 
                          "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
                          "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                          "-.--", "--.."};      
        
        Character[] keys = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 
                              'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
                              'w', 'x', 'y', 'z'}; 

        int count = 0; 
        // Create code map 
        while( count < 0x1A ) { 
            codes.put(keys[count], values[count]); 
            count++; 
        }
        /* Views every String at words[index], iterates every character in that word, 
         * fetches the value mapped to this character and stores this decoded value
         * into a string */
        int wordsCounted = 0; 
        while( wordsCounted < words.length ) { 
            String decodedString = ""; 
            for ( int i = 0; i < words[wordsCounted].length(); i++ ) {  
                String decodedValue = codes.get(words[wordsCounted].charAt(i)); 
                decodedString += decodedValue;
            }
            decodedList.add(decodedString);  
            wordsCounted++; 
        } 
        /* Every decoded string is pushed to a set and if there are duplicates the 
         * string will be removed, revealing only unique decoded strings */
        Set<String> uniqueList = new HashSet<>(decodedList);
        System.out.println("Your decoded List: " + decodedList);
        System.out.println("Unique decoded List: " + uniqueList);
        return uniqueList.size();
    }
}

/** 
 * Given a string s you should reorder the string
 * 
 * @author Wali Morris 
 */

import java.util.*;

public class IncreasingDecreasingString {
    public static void main(String[] args) {
        String input1 = "aaaabbbbcccc";
        String input2 = "rat";
        String input3 = "leetcode";
        String output1 = sortString(input1);
        String output2 = sortString(input2);
        String output3 = sortString(input3);
        System.out.println("Result 1: " + output1);
        System.out.println("Result 2: " + output2);
        System.out.println("Result 3: " + output3);
    }

    public static String sortString(String s) {
        /* splits String s into an array of its individual letters. Counts 
         * the occurrance of each letter and appends letter and its count to 
         * letters Map in order of key */
        String[] str = s.split("");
        Map<String, Integer> letters = new TreeMap<>();
        for (String letter : str) {
            if ( letters.containsKey(letter) ) {
                int count = letters.get(letter);
                letters.put(letter, count+1);
            } else {
                letters.put(letter, 1);
            }
        }
        /* Rotates through key set and appends each letter to String str until 
         * every letter has a value of zero returning this version of a sorted
         * string */
        String sortedStr = ""; // here to append letters 
        Set<String> letterSet = letters.keySet();
        List<String> letterList = new ArrayList<>(letterSet);
        int appends = 0; // counts if there were any letters appended to str 
        boolean loop = true; // flag to release while loop 
        while ( loop ) {
            for ( int i = 0; i < letterList.size(); i++ ) {
                // grabs integer value of letter from letters Map
                String key = letterList.get(i);
                int value = letters.get(key);
                if ( value == 0 ) { // letter should not be appended to str
                    continue; // go to next 
                } else {
                    sortedStr += key;
                    letters.put(key, value-1); // decrease the value of letter
                    appends++;
                }
            }
            // this does everything from first for-loop, but in reverse 
            for (int j = letterList.size()-1; j >= 0; j--) {
                String keyReverse = letterList.get(j);
                int valueReverse = letters.get(keyReverse);
                if ( valueReverse == 0 ) {
                    continue;
                } else {
                    sortedStr += keyReverse;
                    letters.put(keyReverse, valueReverse-1);
                    appends++;
                }
            }
            if ( appends == 0 ) {
                loop = false; // there were no appends, release loop 
            } else {
                appends = 0; // there were still letters to append, loop again
            }
        }
        return sortedStr;
    }
}

/**
 *  Given a positive integer num consisting only of digits 6 and 9
 *
 *  Return the maximum number you can get by changing at most one digit 
 *  ( 6 becomes 9, and 9 becomes 6)
 *
 *  Note: Changing any digit to 6 will not create any number greater than it 
 *  was before flipping a 9 to a 6, therefore we will only flip 6's to 9's 
 *  and test for the greatest value after these flips
 *
 *  @author Wali Morris 
 *  @since 04/29/2020
 */


import java.util.*;

public class MaxNumber69 {
    public static void main(String[] args) {
        int input = 6996;
        int output = maximum69Number(input);
        System.out.println(output);
    }
    public static int maximum69Number(int num) {
        List<Character> numList = new ArrayList<>();
        if ( num == 9999 ) {
            return num;
        }
        int max = num; // the max number seen  
        String numStr = Integer.toString(num);
        /* Create an ArrayList containing the string digits of num */
        for ( int i = 0; i < numStr.length(); i++ ) {
            numList.add(numStr.charAt(i));
        }
        String potentialMaxStr = ""; // string to test greatest number 
        for ( int j = numList.size() - 1; j >= 0; j-- ) {
            /* iterate list, if a element is 6 then change it to 9 and build the
             * potentialMaxStr */
            if ( numList.get(j) == '6' ) {
                numList.set(j, '9');
                for ( Character n : numList ) {
                    potentialMaxStr += n;
                }
                /* if a 6 is flipped to 9 and is greater than the original 
                 * number, it becomes the max number. From here the 9 is 
                 * flipped back to 6 and comtinues iterating the list for 
                 * any other elements of 6*/
                if ( Integer.valueOf(potentialMaxStr) > max ) {
                    max = Integer.valueOf(potentialMaxStr);
                }
                numList.set(j, '6');
            }
            potentialMaxStr = ""; // restart test String
        }
        return max;
    }
}

/**
 * Kids With the Greatest Number of Candies 
 *
 * Given the array candies and the integer extraCandies, where candies[i] represents
 * the number of candies that the ith kid has 
 *
 * For each kid check if there is a way to distribute extraCandies among the kids 
 * such that he or she can have the greatest number of candies among them
 *
 * Notice: multiple kids can have the greatest number of candies 
 *
 * @author Wali Morris 
 * @since 05/07/2020
 */

import java.util.*;

public class Candies {
    public static void main(String[] args) {
        int[] candies1 = {2, 3, 5, 1, 3};
        List<Boolean> output1 = kidsWithCandies(candies1, 3);
        System.out.println(output1);
        int[] candies2 = {4, 2, 1, 1, 2};
        List<Boolean> output2 = kidsWithCandies(candies2, 1);
        System.out.println(output2);
        int[] candies3 = {12, 1, 12};
        List<Boolean> output3 = kidsWithCandies(candies3, 10);
        System.out.println(output3);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // holds true or false depending if ith kid will have most candies by adding extracandies to their count
        List<Boolean> truths = new LinkedList<>(); 
        int max = candies[0];
        for ( int candyCollection : candies ) { // find max pieces of candy 
            if ( candyCollection > max ) {
                max = candyCollection;
            }
        }
        /* add extra candy to each kids owed collection of candues, if adding extra sums to greater than the max 
         * owed candies the add true to truths list else add false */ 
        for ( int owedCandies : candies) {
            if ( owedCandies + extraCandies >= max ) {
                truths.add(true);
            } else {
                truths.add(false);
            }
        }
        return truths;
    }
}

/** 
 * Self Dividing Numbers
 *
 * A self-dividing number is a number that is divisible by every digit it contains
 * 
 * A self-dividing number is not allowed to contain any zeros 
 *
 * Given a lower bound and upper number bound, output a list of every possible self 
 * dividing number, including the bounds if possible
 *
 * @author Wali Morris 
 * @since 05/07/2020
 */

import java.util.*;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        List<Integer> output = selfDividingNumbers(1, 22);
        System.out.println(output);
    }
    /* This method iterates from left bound to right bound taking each number, converting it 
     * to its string version than isolating each digit and dividing it by the original number.
     * If at any point the number has a 0 digit or any digit is not self dividing, the loop 
     * breaks and goes to the next number. If all digits are self-dividing then the number is 
     * added to the self-dividing list. */
    public static List<Integer> selfDividingNumbers(int left, int right) { 
        List<Integer> selfDividingList = new ArrayList<>();
        for (int i = left; i <= right; i++ ) {
            String num = Integer.toString(i);   
            int counter = 0;
            boolean selfDividing = true;  
            while( counter < num.length() ) { 
                int digit = Integer.parseInt(Character.toString(num.charAt(counter))); 
                if ( digit == 0 ) {
                    selfDividing = false; 
                    break; 
                } else if ( !(i % digit == 0))  {
                    selfDividing = false;
                    break;
                } else {
                    counter++;
                }
            }
            if (selfDividing == true) {
                selfDividingList.add(i);
            }
        }
        return selfDividingList;
    }
}

/**
 * Unique Email Addresses
 *
 * Every email consists of a local name and a domain name, seperated by the "@" sign 
 * For example, in alice@leetcode.com, alice is the local name and leetcode.com is 
 * the domain name
 *
 * Beside lowercase letters, these emails may contain '.' s or '+' s
 *
 * If ou add periods ('.') between some characters in the local name part of the email 
 * address, mail sent there will be forwarded to the same address without dots in the 
 * local name: for example, "alicez@leetcide.com" forward to the same address. (This 
 * rule doesn't actually apply for domain names)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will
 * be ignored. This allows certain emails to be filtered, for example: m.y+name@email.com
 * will be forwarded to my@email.com (Again, this does not actaully apply to domain names)
 *
 * It is possible to use both of these rules at the same time
 *
 * Given a list of emails, we need one email to each address in the list; figure out how many
 * different addresses actually receive mails
 *
 * @author Wali Morris
 * @since 05/07/2020
 */


import java.util.*; 

public class UniqueEmail { 
    public static void main(String[] args) { 
        String[] input = {"test.email+alex@leetcode.com", 
                          "test.e.mail+bob.cathy@leetcode.com", 
                          "testemail+david@lee.tcode.com"}; 
        int output = numUniqueEmails(input); 
        System.out.println(output); 
    } 
    
    /* In this method we initialize an empty String for every string in the array passed to this method. There 
     * are some rules to follow (read in the description and added as code to this method). If there are duplicate 
     * email address the Set will take care of this and eliminate any duplicates. We then return the number of emails 
     * left in the Set */
    public static int numUniqueEmails(String[] emails) { 
        // A set is used so we do not add duplicates email addresses to our final list 
        Set<String> emailList = new HashSet<>(); 
        for ( int i = 0; i < emails.length; i++ ) { // iterate each email address in the array 
            String emptyEmail = "";
            /* If the '@' sign is passed this will become true and we will no longer delete periods('.')
             * because we only delete periods in the local name. */
            boolean passedAt = false;    
            /* If we pass a '+' sign this will become true and will not add the characters between the + 
             * sign and the '@' sign */
            boolean plusSign = false; 
            for ( int j = 0; j < emails[i].length(); j++ ) { // iterate the characters in each email 
                if (emails[i].charAt(j) == '+' ) {
                    plusSign = true;
                    emptyEmail += "";
                } else if ( emails[i].charAt(j) == '@' ) {
                    passedAt = true;
                    emptyEmail += "@";
                } else if (emails[i].charAt(j) == '.' && passedAt == false ) {
                    emptyEmail += "";
                } else if ( passedAt == false && plusSign == true ) { // do not add characters between the + and @ sign 
                    emptyEmail += "";
                } else {
                    emptyEmail += emails[i].charAt(j);
                }
            }
            emailList.add(emptyEmail);
        }
        System.out.println(emailList);
        return emailList.size();
    }
} 

/** 
 * Robot Return to Origin
 *
 * There is a robot starting at (0, 0), the origin, on a 2D plane
 * 
 * Given a sequence of its moves, judge if this robot ends up at 
 * (0,0) after it completes its moves
 *
 * @author Wali Morris
 * @Since 05/11/2020
 */

import java.util.*;

public class RobotReturn {
    public static void main(String[] args) {
        String input1 = "UD";
        boolean output1 = judgeCircle(input1);
        System.out.println("Robot with UD returns to origin: " + output1);
        String input2 = "LL";
        boolean output2 = judgeCircle(input2);
        System.out.println("Robot with LL returns to origin: " + output2);
        String input3 = "RRDDLUUL";
        boolean output3 = judgeCircle(input3);
        System.out.println("Robot with RRDDLUUL returns to origin: " + output3);
        String input4 = "RRDD";
        boolean output4 = judgeCircle(input4);
        System.out.println("Robot with RRDD returns to origin: " + output4);
    }
    
    /* This method takes x and y, initialized to 0 acting as x, y horizontal and vertical
     * axis on 2D plane. For every positive or negative move (Left, right, up, down) the 
     * corresponsing x or y axis is affected. At the end of all moves, if x and y are both 
     * 0, then the moves end at (0, 0) origin. */
    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for ( int i = 0; i < moves.length(); i++ ) {
            if (moves.charAt(i) == 'D' ) {
                y--;
            } else if (moves.charAt(i) == 'U' ) {
                y++;
            } else if (moves.charAt(i) == 'L' ) {
                x--;
            } else if (moves.charAt(i) == 'R' ) {
                x++;
            } else {
                throw new IllegalArgumentException("Illegal character move.");
            }
        }
        if ( x == 0 && y == 0 ) {
            return true;
        }
        return false;
    }
}

/** 
 * Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one
 *
 * Find that one
 *
 * @author Wali Morris 
 * @since 05/12/2020
 */

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        int[] input1 = {2, 2, 1};
        int output1 = singleNumber(input1);
        System.out.println(input1 + " single number: " + output1);
        int[] input2 = {4, 1, 2, 1, 2};
        int output2 = singleNumber(input2);
        System.out.println(input2 + " single number: " + output2);
    }

    /* This method stores each integer from the passed array into a map and counts the number 
     * of times that same integer has been seen within the array, this number is that integers
     * value. Next, the keySet is iterated and returns the integer from the array that is only 
     * seen once. If no such number exists, this method returns -1 */
    public static int singleNumber(int[] nums) { 
        Map<Integer, Integer> numMap = new HashMap<>(); 
        for ( int i = 0; i < nums.length; i++ ) { 
            if ( numMap.containsKey(nums[i]) ) { 
                int count = numMap.get(nums[i]);
                numMap.put(nums[i], count+1); 
            } else { 
                numMap.put(nums[i], 1); 
            } 
        }
        for (Integer key : numMap.keySet() ) {
            int value = numMap.get(key);
            if (value == 1) {
                return key;
            }
        }
        return -1;
    }
}

/**
 * Minimum Absolute Difference 
 *
 * Given an array of distinct integers arr, find all pairs of elements with the 
 * minimum absolute difference of any two elements 
 *
 * Return a list of pairs in ascending order(with respect to pairs)
 *
 * @author Wali Morris 
 * @since 05/13/2020
 */

import java.util.*;

public class AbsoluteDifference {
    public static void main(String[] args) {
        int[] input1 = {4, 2, 1, 3};
        List<List<Integer>> output1 = minimumAbsDifference(input1);
        System.out.println(output1);
        int[] input2 = {1, 3, 6, 10, 15};
        List<List<Integer>> output2 = minimumAbsDifference(input2);
        System.out.println(output2);
        int[] input3 = {3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> output3 = minimumAbsDifference(input3);
        System.out.println(output3);
        int[] input4 = {-17, 46, 63, 81, -101, -91, 121, -2, 112, -15,
                        -65, -96, 6, -139};
        List<List<Integer>> output4 = minimumAbsDifference(input4);
        System.out.println(output4);
    }
    
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        /* holds all lists that meets requirements */
        List<List<Integer>> masterList = new ArrayList<>(); 
        /* Creates a list of the first two elements in the sorted array, these
         * elements correspond to the most likely minimum absolute values when 
         * subtracted, this list is then added to the master list */
        List<Integer> list = new ArrayList<>(
                        List.of(arr[0], arr[1]));
        masterList.add(list);
        int i = 1,  min = Math.abs(arr[0] - arr[1]);
        while ( i <= arr.length - 2) {
            List<Integer> softList = new ArrayList<>();
            int next = Math.abs(arr[i] - arr[i+1]);
            if ( next < min ) {
                masterList.clear(); // clears to store new minimum
                min = next;
                softList.add(arr[i]);
                softList.add(arr[i+1]);
                masterList.add(softList);
            } else {
                /* next equals minimum so we keep current softLists within masterList 
                 * and add the new softList to the masterList */
                if ( next == min ) {
                    softList.add(arr[i]);
                    softList.add(arr[i+1]);
                    masterList.add(softList);
                }
            }
            i++;
        }
        return masterList;
    }
}

/* Sort the Array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is 
 * even 
 *
 * You may return any answer array that satisfies this condition 
 *
 * @author Wali Morris 
 * @since 05/15/2020
 */

import java.util.*;

public class SortArrayParity2 {
    public static void main(String[] args) {
        int[] input1 = {4, 2, 5, 7};
        int[] output1 = sortArrayByParityII(input1);
        System.out.println(Arrays.toString(output1));
    }
    
    public static int[] sortArrayByParityII(int[] A) {
        /* two arrayLists: 1 holds positives and one holds negatives from Array A */
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        /* can hold same amount as array A */
        int[] B = new int[A.length];
        /* sends odds from A to oddList and evens to evenlist */
        for ( int num : A ) {
            if ( num % 2 == 0 ) { // num is even, send to even list
                evenList.add(num);
            } else {
                oddList.add(num); // num is odd, send to odd list
            }
        }
        /* Add first even number to B[0], remove even number from evenlist and begin adding
         * even and odd numbers to the corresponding even or odd index in array B until B is 
         * the same length as A */
        B[0] = evenList.get(0);
        evenList.remove(0);
        int count = 1;
        while ( count < A.length ) {
            /* if index at B is odd, add odd integer to index then remove the first
             * even number from oddList */
            if ( count % 2 == 0 ) {
                B[count] = evenList.get(0);
                evenList.remove(0);
            /* if index at B is even, add even integer to index then remove the first 
             * even number from evenList */
            } else {
                B[count] = oddList.get(0);
                oddList.remove(0);
            }
            count++; // go to next index  
        }
        return B; // return new array B
    }
}   

/**
 * Number of Students Doing Homework at a Given Time
 * 
 * Given two integer arrays startTime and endTime and given an integer queryTime
 *
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i]
 *
 * Return the number of students doing their homework at time queryTime
 * More formally, return the number of students where queryTime lays in 
 * the interval [startTime[i], endTime[i]] inclusive
 *
 * @author Wali Morris
 * @since 05/16/2020
 */

import java.util.*; 

public class QueryTime { 
    public static void main(String[] args) { 
        int[] start = {9, 8, 7, 6, 5, 4, 3, 2, 1}; 
        int[] end = {10, 10, 10, 10, 10, 10, 10, 10, 10};
        int query = 5;
        int output = busyStudent(start, end, query); 
        System.out.println(output); 
    } 

    public static int busyStudent(int[] startTime, int[] endTime, int query) { 
        int busy = 0; 
        for (int i = 0; i < startTime.length; i++ ) { 
            if ( startTime[i] <= query && endTime[i] >= query ) { 
                busy++; 
            }
        } 
        return busy; 
    } 
}

/**
 * Rotate Array 
 *
 * Given an array, rotate the array to the right by k steps, where 
 * k is non-negative
 *
 * @author Wali Morris
 * @since 05/16/2020
 */


import java.util.*; 

public class RotateArray { 
    public static void main(String[] args) { 
        int[] input1 = {1, 2, 3, 4, 5, 6, 7}; 
        int k = 3; 
        rotate(input1, k); 
    }

    public static void rotate(int[] nums, int k) { 
        int rotations = 0;
        while ( !(rotations == k) ) {   
            int last = nums[nums.length - 1]; // record last num in array  
            for ( int i = nums.length - 1; i > 0; i-- ) { 
                nums[i] = nums[i-1]; // move each element to right 
            } 
             nums[0] = last; // first num in array equals last
            rotations++; // increment rotations(k)
        }
        System.out.println(Arrays.toString(nums)); 
    } 
}

/**
 * Length of Last Word 
 *
 * Given a String s consists of upper/lower-case alphabets and empty space characters ' ' 
 * return the length of the last word ( last word means the last appearing word if we loop
 * from left to right ) in the String
 *
 * If the last word does not exist return 0
 *
 * @author Wali Morris 
 * @since 05/20/2020
 */

import java.util.*;

public class LastWord {
    public static void main(String[] args) {
        String input1 = "Hello World";
        String input2 = " ";
        int output1 = lengthOfLastWord(input1);
        int output2 = lengthOfLastWord(input2);
        System.out.println("Length of " + input1 + " : " + output1);
        System.out.println("Length of " + input2 + " : " + output2);
    }

    public static int lengthOfLastWord(String s) {
        /* splitting string into array will split words into their own index based on were spaces 
         * are present in the string. If the string contains a space then the array will have a 
         * length of 0 */
        String[] wordArray = s.split(" ");
        if ( wordArray.length == 0 ) {
            return 0;
        } else { // return length of last string element in the array
            return wordArray[wordArray.length - 1].length();
        }
    }
}

/**
 * Destination City 
 *
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a
 * direct path going from cityAi to cityBi
 *
 * Return the destination city, that is, the city without any path outgoing to another 
 * city
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, 
 * there will be exactly one destination city
 *
 * @author Wali Morris 
 * @since 05/21/2020
 */


import java.util.*;

public class DestinationCity {
    public static void main(String[] args) {
        List<String> inputList1 = new ArrayList<>(
                List.of("London", "New York"));
        List<String> inputList2 = new ArrayList<>(
                List.of("New York", "Lima"));
        List<String> inputList3 = new ArrayList<>(
                List.of("Lima", "Sao Paulo"));
        List<List<String>> input = new ArrayList<>(
                List.of(inputList1, inputList2, inputList3));
        String destination = destCity(input);
        System.out.println(input + " Destination: " + destination);
        List<String> input2List1 = new ArrayList<>(
                List.of("B", "C"));
        List<String> input2List2 = new ArrayList<>(
                List.of("D", "B"));
        List<String> input2List3 = new ArrayList<>(
                List.of("C", "A"));
        List<List<String>> input2 = new ArrayList<>(
                List.of(input2List1, input2List2, input2List3));
        String destination2 = destCity(input2);
        System.out.println(input2 + " Destination: " + destination2);
        List<String> input3List1 = new ArrayList<>(
                List.of("A", "Z"));
        List<List<String>> input3 = new ArrayList<>();
        input3.add(input3List1);
        String destination3 = destCity(input3);
        System.out.println(input3 + " Destination: " + destination3);
    }
    
    public static String destCity(List<List<String>> paths) {
        // returns the second city in single list of two cities 
        if ( paths.size() == 1 ) {
            return paths.get(0).get(1);
        }
        /* Creates a list to record the first city to begin. Also creates a map pair 
         * of the two cities in the original paths list. This way we can track travel 
         * from city A to city B */
        Map<String, String> cityPair = new HashMap<>();
        List<String> firstCity = new ArrayList<>();
        for ( List<String> cities : paths ) {
            cityPair.put(cities.get(0), cities.get(1));
            firstCity.add(cities.get(0));
        }
        boolean last = false;
        String finalCity = "";
        int start = 0;
        String current = firstCity.get(start); // start at first city 
        while (last == false) { // while we still have cities to travel to 
            if ( cityPair.containsKey(current) ) { // if destination city is also a departure city
                current = cityPair.get(current); // get the departure cities destination 
            } else {
                finalCity = current; // if destination city is not also a departure city
                last = true; // it's true, we've reached the final city
            }
        }
        return finalCity; // return destination city(final city) 
    }
}

/**
 * Decrypt String from Alphabet to Integer Mapping 
 *
 * Given a String s formed by digits ('0' - '9') and '#', we want to map s to English 
 * lowercase characters as follows: 
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively 
 * characters ('j' to 'z') are represented by ('10#' to '26#') respectively 
 *
 * return the String formed after mapping and its guaranteed a unique mapping will 
 * always exist
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */


import java.util.*; 

public class DecryptString { 
    public static void main(String[] args) { 
        String input1 = "10#11#12"; 
        String output1 = freqAlphabets(input1);
        String input2 = "1326#"; 
        String output2 = freqAlphabets(input2);
        String input3 = "25#"; 
        String output3 = freqAlphabets(input3);
        String input4 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"; 
        String output4 = freqAlphabets(input4);         
        System.out.println(input1 + " -> " + output1);
        System.out.println(input2 + " -> " + output2);
        System.out.println(input3 + " -> " + output3);
        System.out.println(input4 + " -> " + output4);  
    } 
    
    public static String freqAlphabets(String s) {
        // Code Map holding key decryptions 
        Map<String, String> codeMap = new HashMap<>();
        codeMap.put("1", "a");
        codeMap.put("2", "b");
        codeMap.put("3", "c");
        codeMap.put("4", "d");
        codeMap.put("5", "e");
        codeMap.put("6", "f");
        codeMap.put("7", "g");
        codeMap.put("8", "h");
        codeMap.put("9", "i");
        codeMap.put("10#", "j");
        codeMap.put("11#", "k");
        codeMap.put("12#", "l");
        codeMap.put("13#", "m");
        codeMap.put("14#", "n");
        codeMap.put("15#", "o");
        codeMap.put("16#", "p");
        codeMap.put("17#", "q");
        codeMap.put("18#", "r");
        codeMap.put("19#", "s");
        codeMap.put("20#", "t");
        codeMap.put("21#", "u");
        codeMap.put("22#", "v");
        codeMap.put("23#", "w");
        codeMap.put("24#", "x");
        codeMap.put("25#", "y");
        codeMap.put("26#", "z");
        
        List<String> codes = new ArrayList<>(); // list holding single codes 
        for ( int i = s.length() - 1; i >= 0; i-- ) {
            /* collect the single digit and add to codes list */
            if ( !(s.charAt(i) == '#') ) {
                String code = "";
                code += s.charAt(i);
                codes.add(code);
            } else {
                /* A # symbol has been found and the next two digits after the # should 
                 * be collected together */
                if ( s.charAt(i) == '#' ) {
                    String code = "";
                    code += s.charAt(i-2);
                    code += s.charAt(i-1);
                    code += s.charAt(i);
                    codes.add(code);
                    i -= 2;
                }
            }
        }
        /* convert codes to String using code Map starting from last element in codes List */
        String decrytedStr = "";
        for ( int j = codes.size() - 1; j >= 0; j-- ) {
            String value = codeMap.get(codes.get(j));
            decrytedStr += value;
        }
        return decrytedStr;
    }
}       

/**
 * Majority Element 
 *
 * Given an array of size n, find the majority element, the majority element is 
 * the element that appears more than n/2 times
 *
 * You may assume that the array is non-empty and the majority element always 
 * exists in the array. 
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] input1 = {3,2,3};
        int[] input2 = {2,2,1,1,1,2,2};
        int output1 = majorityElement(input1);
        int output2 = majorityElement(input2);
        System.out.println(Arrays.toString(input1) + " Majority Element: " + output1);
        System.out.println(Arrays.toString(input2) + " Majority Element: " + output2);
    }
    
    public static int majorityElement(int[] nums) {
        // in the case there is only 1 element in nums
        if ( nums.length == 1 ) {
            return nums[0];
        }
        /* Create a Map to count the amount of each element, if a count breaks 
         * nums/2, return that element as majority element */
        Map<Integer, Integer> numsCount = new HashMap<>();
        for ( Integer n : nums ) {
            if ( numsCount.containsKey(n) ) { // map already contains element? 
                int count = numsCount.get(n) + 1; // increase element count by 1
                if ( count > nums.length / 2 ) { // is the count greater than nums/2?
                    return n; // return element
                } else {
                    numsCount.put(n, count); // count is not greater, put element back into map with new count
                }
            } else { // element does not exist
                numsCount.put(n, 1); // put element into map with starting count of 1
            }
        }
        return -1; // nums array does not meet criteria, return -1 
    }
}

/** 
 * Move Zeros 
 *
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements 
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */

import java.util.*;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] input1 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        System.out.print(Arrays.toString(input1) + " -> ");
        moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
    }
    
    public static void moveZeroes(int[] nums) {
        // creates an ArrayList of nums to check if it contains a 0
        List<Integer> numsList = new ArrayList<>();
        for ( int n : nums ) {
            numsList.add(n);
        }
        // if nums contains a 0
        if ( numsList.contains(0)) {
            /* impliments a modified selection sort algorithm to move all 0's to the end of 
             * nums array. If the pointed to element is a 0 and the next element is either 
             * less than or greater than 0, swap until 0 element is at the end */
            for ( int i = 0; i < nums.length - 1; i++ ) {
                int current = i;
                for ( int j = i + 1; j < nums.length; j++ ) {
                    if (nums[current] == 0 && nums[j] > nums[current] ||
                        nums[current] == 0 && nums[j] < nums[current]) {
                        int temp = nums[j];
                        nums[j] = nums[current];
                        nums[current] = temp;
                    }
                }
            }
        }
    }
}

/**
 * Check if a word occurs as a Prefix of any word in a sentence 
 *
 * Given a sentence that consists of some words seperated by a single space, and a search word 
 *
 * You have to check if searchWord is a prefix of any word in the sentence
 *
 * Return the index of the word in sentence where searchWord is a Prefix of this word (1-indexed)
 *
 * If a searchWord is a prefix of more than one word, return the index of the first word and if 
 * there is no such word return -1
 *
 * @author Wali Morris 
 * @since 05/25/2020
 */

import java.util.*;

public class SentencePrefix {
    public static void main(String[] args) {
        String sentence1 = "i love eating burger";
        String sentence2 = "this problem is an easy problem";
        String sentence3 = "i am tired";
        String sentence4 = "i use triple pillow";
        String searchWord1 = "burg";
        String searchWord2 = "pro";
        String searchWord3 = "you";
        String searchWord4 = "pill";
        int output1 = isPreFixOfWord(sentence1, searchWord1);
        int output2 = isPreFixOfWord(sentence2, searchWord2);
        int output3 = isPreFixOfWord(sentence3, searchWord3);
        int output4 = isPreFixOfWord(sentence4, searchWord4);
        System.out.println(searchWord1 + " is prefix of word number : " + output1);
        System.out.println(searchWord2 + " is prefix of word number : " + output2);
        System.out.println(searchWord3 + " is prefix of word number : " + output3);
        System.out.println(searchWord4 + " is prefix of word number : " + output4);
    }
    
    public static int isPreFixOfWord(String sentence, String searchWord) {
        if ( sentence.equals(" ") ) {
            return -1; // empty sentence, return -1 
        }
        /* Array of elements consisting of each word in sentence */
        String[] sentenceArr = sentence.split(" ");
        /* get first letter of word being searched */
        char searchWordFirstLetter = searchWord.charAt(0);
        /* sequential search of any element in sentence array that contains the first letter of the 
         * searched word (only continues match if substring has length greater than or equal to 
         * searched word or else a runtime error will be thrown due to substring out of index) */
        for ( int i = 0; i < sentenceArr.length; i++ ) {
            if ( sentenceArr[i].charAt(0) == searchWordFirstLetter ) { // found a word with match 
                if( sentenceArr[i].length() >= searchWord.length() &&
                    sentenceArr[i].substring(0, searchWord.length()).equals(searchWord )) {
                    /* substring of word in sentence matches searched word, return index + 1 */
                    return i + 1;
                }
            }
        }
        return -1; // no prefix was found 
    }
}

/**
 * Given a String S and a Character C, return an array of integers representing the 
 * shortest distance from the Character C in the string
 *
 * @author Wali Morris 
 * @since 05/25/2020
 */

import java.util.*;

public class ShortestDistanceToChar {
    public static void main(String[] args) {
        String input1 = "loveleetcode";
        int[] output1 = shortestToChar(input1, 'e');
        System.out.println(Arrays.toString(output1));
    }
    
    public static int[] shortestToChar(String S, char C) {
        /* creates a list to hold the index of each element C in S */
        List<Integer> characterIndex = new ArrayList<>();
        for ( int i = 0; i < S.length(); i++ ) {
            if ( S.charAt(i) == C ) {
                characterIndex.add(i);
            }
        }
        /* Creates an array to hold the distance to the closest character C. If the index is less than 
         * s.length / 2 we get the distance from the furthest character C and current index. If the index
         * is greater than s.length / 2 we get the distance from the shortest distance C and current index.
         * This is done because we use Math.abs() */
        int[] distances = new int[S.length()];
        for ( int j = 0; j < S.length(); j++ ) {
            if ( j < S.length() / 2 ) {
                int smallestDistance = Math.abs(j - characterIndex.get(characterIndex.size() - 1));
            }
            int smallestDistance = Math.abs(j - characterIndex.get(0));
            /* collect the index of each Char C and test for shortest distance. Then add this shortest 
             * distance to distances[j] */
            for ( int k = 0; k < characterIndex.size(); k++ ) {
                int nextDistance = Math.abs(j - characterIndex.get(k));
                if ( nextDistance < smallestDistance ) {
                    smallestDistance = nextDistance;
                }
            }
            distances[j] = smallestDistance;
        }
        return distances;
    }
}

/**
 * Uncommon Words
 *
 * We are given two sentences A and B ( a sentence is a string of space seperated words, 
 * each word consists only of lowercase letters)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not 
 * appear in the other sentence 
 *
 * Return a list of all uncommon words
 *
 * Note: This method uses uses the idea of functional decomposition by breaking the program
 * into smaller methods to process the information
 *
 * @author Wali Morris
 * @since 05/26/2020
 */

import java.util.*;

public class UncommonWords {
    public static void main(String[] args) {
        String input1 = "this apple is sweet", input2 = "this apple is sour";
        String input3 = "apple apple", input4 = "bananna";
        String[] output1 = uncommonFromSentences(input1, input2);
        String[] output2 = uncommonFromSentences(input3, input4);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }

    /* This method takes two seperate sentences and split them into two seperate arrays, giving
     * each element(word) its own index. The two sentences are then mapped by word and count. 
     * Both maps are then compared and populated into a their own list. If a word from map1 is 
     * not in map2 and that word is not repeated it's added to the list, and vice versa. These 
     * list are then combined and returned as an array of uncommon words */
    public static String[] uncommonFromSentences(String A, String B) {
        String[] sentenceA = A.split(" "), sentenceB = B.split(" ");
        Map<String, Integer> mapA = populateMapFromArray(sentenceA);
        Map<String, Integer> mapB = populateMapFromArray(sentenceB);
        List<String> uncommonWordsA = uncommonWordsFromStrings(mapA, mapB);
        List<String> uncommonWordsB = uncommonWordsFromStrings(mapB, mapA);
        uncommonWordsA.addAll(uncommonWordsB);
        String[] uncommonArray = new String[uncommonWordsA.size()];
        uncommonArray = uncommonWordsA.toArray(uncommonArray);
        return uncommonArray;
    }
    
    /* Takes an array of Strings as parameter and mapped by word and its count, returns the 
     * map */
    public static Map<String, Integer> populateMapFromArray(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for ( String word : arr ) {
            if ( map.containsKey(word) ) {
                int count = map.get(word) + 1;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    /* Takes two maps as parameters and compares for uncommon words, *see uncommonFromSentences()**/
    public static List<String> uncommonWordsFromStrings(Map<String, Integer> mapA,
                    Map<String, Integer> mapB) {
        List<String> s = new ArrayList<>();
        for ( String word : mapA.keySet() ) {
            if ( !(mapB.containsKey(word))) {
                if ( mapA.get(word) == 1 ) {
                    s.add(word);
                }
            }
        }
        return s;
    }
}

/** 
 * Next Greater Element I 
 *
 * You are given two arrays ( without duplicates) nums1 and nums2 where nums1's elements are 
 * subset of nums2 
 *
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in 
 * nums2
 *
 * If it does not exist, output -1 for this number
 *
 * @author Wali Morris 
 * @since 05/27/2020
 */

import java.util.*;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] input1 = {4, 1, 2}, input2 = {1, 3, 4, 2};
        int[] input3 = {2, 4}, input4 = {1, 2, 3, 4};
        int[] output1 = nextGreaterElement(input1, input2);
        int[] output2 = nextGreaterElement(input3, input4);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }
    
    int[] nextGreaterElement1 = new int[nums1.length];
        for ( int i = 0; i < nums1.length; i++ ) {
            int current = nums1[i]; // number we are looking for in nums2 array  
            boolean currentFound = false; // checks if nums1[i] is found in nums2 
            boolean nextGreatestFound = false; // checks if a number greater than nums1[i] is found  
            int nextGreatestNum = 0; // the next greatest num to the right of nums1[i] found in nums2  
            for ( int j = 0; j < nums2.length; j++ ) {
                if ( nums2[j] == current ) {
                    currentFound = true; // number has been found 
                } else {
                    /* number from nums1 has been found in nums2 and there's a number greater than it 
                     * to the right of it in nums2 */
                    if ( nums2[j] > current && currentFound == true ) {
                        nextGreatestFound = true;
                        nextGreatestNum = nums2[j]; // the greater number to the right  
                        break;
                    }
                }
            }
            if ( nextGreatestFound == true ) { // if greatest has been found 
                nextGreaterElement1[i] = nextGreatestNum; // add greatestNum to array 
            } else {
                nextGreaterElement1[i] = -1; // else add -1
            }
        }
        return nextGreaterElement1;
    }
}

/**
 * Maximum Product of Two Elements in an Array 
 *
 * Given the array of integers nums, you will choose two different indices i and j 
 * of that array 
 *
 * Return the maximum value of (nums[i] - 1 * (nums[j] - 1)
 *
 * @author Wali Morris
 * @since 06/02/2020
 */

import java.util.*;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] input1 = {3, 4, 5, 2};
        int[] input2 = {1, 5, 4, 5};
        int[] input3 = {3, 7};
        int output1 = maxProduct(input1);
        int output2 = maxProduct(input2);
        int output3 = maxProduct(input3);
        System.out.println("Max product of " + Arrays.toString(input1) + ": " + output1);
        System.out.println("Max product of " + Arrays.toString(input2) + ": " + output2);
        System.out.println("Max product of " + Arrays.toString(input3) + ": " + output3);
    }

    public static int maxProduct(int[] nums) {
        /* Creates a map to record each integer element and its count */
        Map<Integer, Integer> numsMap =  new HashMap<>();
        for ( int num : nums ) {
            if ( numsMap.containsKey(num) ) {
                int count = numsMap.get(num) + 1;
                numsMap.put(num, count);
            } else {
                numsMap.put(num, 1);
            }
        }

        /* gets the first and second greatest number, if the greatest number has a duplicate then the 
         * second greatest number has the same value */
        int firstGreatestNum = Collections.max(numsMap.keySet());
        int secondGreatestNum = 0;
        if ( numsMap.get(firstGreatestNum) > 1 ) {
            secondGreatestNum = firstGreatestNum;
        } else {
            numsMap.remove(firstGreatestNum);
            secondGreatestNum = Collections.max(numsMap.keySet());
        }
        // return the product 
        return ( (firstGreatestNum - 1) * (secondGreatestNum - 1));
    }
}

/**
 * Valid Palidrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters 
 * and ignoring cases
 *
 * For the purpose of this problem, we determine empty string as valid palindrome
 *
 * @author Wali Morris
 * @since 06/03/2020
 */

import java.util.*; 

public class ValidPalindrome { 
    public static void main(String[] args) { 
        String input1 = "A man, a plan, a canal: Panama"; 
        String input2 = "race a car";
        String input3 = "0P";   
        boolean output1 = isPalindrome(input1); 
        boolean output2 = isPalindrome(input2);
        boolean output3 = isPalindrome(input3);         
        System.out.println(output1); 
        System.out.println(output2); 
        System.out.println(output3); 
    } 
    
    public static boolean isPalindrome(String s) {
        boolean palindrome = true; 
        if ( s.length() == 0 ) { 
            return palindrome; 
        }  
        String s2 = s.toLowerCase();  
        Queue<Character> queue = new LinkedList<>(); 
        Stack<Character> stack = new Stack<>();
        
        /* iterates String s and pushes and adds only characters a - z or integers 0 - 9
         * to queue and stack */ 
        for ( int i = 0; i < s.length(); i++ ) {
            if ( s2.charAt(i) > 96 && s2.charAt(i) < 123 ||
                 s2.charAt(i) > 47 && s2.charAt(i) < 58 ) {
                queue.add(s2.charAt(i));
                stack.push(s2.charAt(i));
            }
        }
        /* Empties both stack and queue, comparing each element using FIFO/LIFO conventions. 
         * If any two elements do not match, return false else return true */
        while ( !queue.isEmpty() ) {
            char queueElement = queue.remove();
            char stackElement = stack.pop();
            if ( !(queueElement == stackElement) ) {
                return false;
            }
        }
        return palindrome;
    }
}

/* Given a string, you need to reverse the order of characters in each word 
 * within a sentence while still preserving whitespace and initial word 
 * order. 
 *
 * Note: This problem is similar, if not the same question, to Reverse String II
 * In this solution I use a nested loop to build the new sentence in reverse order
 * which seems to be much better solution. This solution can still be written in 
 * a much more proficient way
 *
 * Author : Wali Morris 
 * File   : ReverseStringIII.java
 * Date   : 06/05/2020
 */

import java.util.*;

public class ReverseStringIII {
    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }
    
    public static String reverseWords(String s) {
        StringBuilder finalStr = new StringBuilder("");                 
        /* An array to split the sentence by each individual word */    
        String[] sentenceArray = s.split(" "); 
        /* This nested loop reads each element in sentence array and reverse that word then 
         * appends it to finalStr */
        for ( int i = 0; i < sentenceArray.length; i++ ) {
            String word = sentenceArray[i];     
            for ( int j = word.length() - 1; j >= 0; j-- ) { 
                finalStr.append(word.charAt(j)); 
            }           
            /* if the last word is being read do not append a space */
            if ( !(i == sentenceArray.length - 1) ) { 
                finalStr.append(" "); 
            }
        }
        return finalStr.toString();
    }
}

/**
 * Last Stone Weight
 *
 * We have a collection of stones, each stone has a positive integer weight
 *
 * Each turn, we choose the two heaviest stones and smash them together; suppose
 * the stones have weights x and y with x greater than or equal to y
 *
 * The result of this smash is: 
 *
 *  - if x == y, both stones are totally destroyed
 *  - if x != y, the stone of weight x is totally destroyed and the stone of 
 *    weight y has new weight y-x
 *
 * At the end, there is at most 1 stone left
 *
 * Return the weight of this stone ( or 0 if there are no stones left)
 *
 * @author Wali Morris 
 * @since 06/05/2020
 */

import java.util.stream.Collectors;
import java.util.*;

public class LastStone {
    public static void main(String[] args) {
        int[] input1 = {};
        int output = lastStoneWeight(input1);
        System.out.println("Last stone weight: " + output);
    }
    
    public static int lastStoneWeight(int[] stones) {
        /* Creates an ArrayList of the array stones */
        List<Integer> stonesList = Arrays.stream(stones)
                                         .boxed()
                                         .collect(Collectors.toList());
        /* empty list, return 0 */
        if ( stonesList.size() == 0 ) {
            return 0;
        }
        /* Its guarenteed the there will be 1 element, unless there are none. In this case
         * get the maximum number and in case of duplicates give x the value of the first 
         * seen max num. Remove this from the list and do the same for the next maximum and 
         * give y this value */
        while ( !(stonesList.size() == 1) ) {
            int x = Collections.max(stonesList);
            stonesList.remove(stonesList.indexOf(x));
            int y = Collections.max(stonesList);
            stonesList.remove(stonesList.indexOf(y));
            /* if x equals y, do nothing , the elements have already been deleted from the list. 
             * If x does not equal y get the absolute value of y - x */
            if ( !(x == y) ) {
                /* new value becomes the new stone and add it to the front of the list */
                int newStone = Math.abs(y - x);
                stonesList.add(0, newStone);
            } else {
                /* at any step, if the list is empty, return 0 */
                if ( stonesList.size() == 0 ) {
                    return 0;
                }
            }
        }
        /* List is not empty, return the only element */
        return stonesList.get(0);
    }
}

/**
 * Third Maximum Number 
 *
 * Given a non-empty array of integers, return the third maximum number in this array
 * If it does not exist, return the maximum number
 *
 * @author Wali Morris
 * @since 06/06/2020
 */

import java.util.*; 

public class ThirdMax { 
    public static void main(String[] args) { 
        int[] input1 = {1, 2}; 
        int[] input2 = {2, 2, 3, 1}; 
        int[] input3 = {1, 1, 2}; 
        int output1 = thirdMax(input1); 
        int output2 = thirdMax(input2); 
        int output3 = thirdMax(input3);
        System.out.println(output1); 
        System.out.println(output2);
        System.out.println(output3);
    }
    
    public static int thirdMax(int[] nums) { 
        switch ( nums.length ) { 
            case 0: 
                return 0; 
            case 1: 
                return nums[0];
            case 2:  
                /* nums array length is 2, create an arraylist and return the max */
                List<Integer> numbers = new ArrayList<>();
                for ( Integer n : nums ) {
                    numbers.add(n);
                }
                return Collections.max(numbers);
        }
        List<Integer> numbersList = new ArrayList<>();
        for ( Integer num : nums ) {
            numbersList.add(num);
        }
        /* This is the original max value in nums array before any elements are removed. 
         * If the size of nums array is 3 or greater, but after removing elements has a 
         * size of 0 then the original max element will be returned */
        final int orgMax = Collections.max(numbersList);
        int max = 0, count = 0;
        while ( count < 2) {
            /* deletes the first two max elements from the list */
            max = Collections.max(numbersList);
            numbersList.removeAll(Collections.singleton(max));
            count++;
            if ( numbersList.size() == 0 ) {
                return orgMax;
            }
        }
        /* returns the third max element from the list */
        return Collections.max(numbersList);

    }
}

/**
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palidrome
 * @see ListNode.java: for definition of ListNode
 *
 * Note: I know there should be a reference to the back of the LinkedList
 * At this point I'm not sure how to implement this feature, so I'm using
 * another method I can think of which is much slower; I will continue 
 * studying LinkedList and hopefully implement a much faster solution 
 * utilizing the reference to the back of the linkedList
 *
 * @author Wali Morris 
 * @since 06/09/2020
 */

import java.util.*;

public class PalindromeLinkedList2 {
    public static void main(String[] args) {
        ListNode input0 = new ListNode(1);
        ListNode input1 = new ListNode(-129, new ListNode(-128));
        ListNode input2 = new ListNode(1, new ListNode(2,
                          new ListNode(2, new ListNode(1))));
        boolean output0 = isPalindrome(input0);
        boolean output1 = isPalindrome(input1);
        boolean output2 = isPalindrome(input2);
        System.out.println(output0);
        System.out.println(output1);
        System.out.println(output2);
    }

    /* To test if LinkedList is a palidrome, use an ArrayList to store elements 
     * of the LinkedList. Next, create two pointers, one at the front of the 
     * arrayList and one at the back. Compare elements until the pointers meet in 
     * the middle of the arrayList. */
    public static boolean isPalindrome(ListNode head) {
        // empty linkedlist and linkedlist with one element returns true
        if ( head == null || head.next == null ) {
            return true;
        }
        List<Integer> valList = new ArrayList<>();
        ListNode current = head;
        while ( !(current == null) ) {
            valList.add(current.val);
            current = current.next;
        }
        int count = 0;
        // pointers to the first and last elements in arrayList 
        int front = 0, back = valList.size() - 1;
        while ( !(count == valList.size() / 2) ) {
            if ( !(valList.get(front).equals(valList.get(back))) ) {
                return false;
            }
            count++; // increment count
            front++; // move front pointer to right 
            back--; // move back pointer to left 
        }
        return true;
    }
}

/**
 * Shuffle the Array
 *
 * Given the array nums consisting of 2n elements in the form [x1, x2,..., y1, y2...]
 * Return the array in the form [x1, y1, x2,y2...., xn, yn]
 *
 * @author Wali Morris 
 * @since 06/11/2020
 */

import java.util.*;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] input1 = {2, 5, 1, 3, 4, 7};
        int[] input2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] input3 = {1, 1, 2, 2};
        int[] output1 = shuffle(input1, 3);
        int[] output2 = shuffle(input2, 4);
        int[] output3 = shuffle(input3, 2);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
        System.out.println(Arrays.toString(output3));
    }

    public static int[] shuffle(int[] nums, int n) {
        /* A new array to store the elements of nums array */
        int[] nums2 = new int[nums.length];
        /* x points to first x element, y points to first y element */
        int ptrX = 0, ptrY = n;
        /* every iteration x and y pointer skips to next x and y elements in nums 
         * and inserts those elements in place in nums2 */
        for (int i = 0; i < nums.length-1; i+=2 ) {
            nums2[i] = nums[ptrX];
            nums2[i+1] = nums[ptrY];
            ptrX++; // go to next x index
            ptrY++; // go to next y index
        }
        return nums2;
    }
}
