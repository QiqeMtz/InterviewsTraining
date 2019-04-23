package CodingProblems;

import java.io.*;
import java.util.*;

/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element
* for an element x is the first greater element on the right side of x in array. Elements for which no * greater element exist, consider next greater element as -1
* {3,4,5, 67,1,2,4, 1, 83,  82}
   4 5 67 _  2

   <0>
   <>4
    4
    <1>

    <1>5
    <5>
    4 4

    <5>
    4 4 5


    <3>
    4 4 5 67

    <3, 1>
    4 4 5 67


    <3, 4>
    4 4 5 67 _ 2 4


    <3, 4 , 1>  83
    4 4 5 67 _ 2 4


    <83 >
    4 4 5 67 83 2 4 83,83,



    <83 82>
    4 4 5 67 83 2 4 83,83,

    -------------
    4 4 5 67 83 2 4 83,83, -1, -1

*
*
*
*
*
 */

class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printGreatest(new int[]{3,4,5, 67,1,2,4, 1, 83,  82})));
    }


    /**
     Stack<Index>
     while( trigger)  {delete()}
     add()
     */

    static int[] printGreatest(int[] numbers) {

        int[] result = new int[numbers.length];
        Stack<Integer> indexes = new Stack<>();

        indexes.add(0);

        for(int idx = 1; idx < numbers.length; idx++) {
            while(numbers[idx] > numbers[indexes.peek()]) {
                numbers[indexes.pop()] = numbers[idx];
            }
            indexes.add(idx);
        }
        for(Integer idx: indexes){
            numbers[indexes.pop()]  = -1;
        }
        return result;
    }
}
