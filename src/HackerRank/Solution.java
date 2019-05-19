package HackerRank;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cases;
        String str;

        Scanner scn = new Scanner(System.in);

        cases = scn.nextInt();

        for(int i = 0; i < cases; i++) {
            str = scn.next();

            System.out.println(print(str));
        }
    }

    static String print(String str){
        StringBuilder evens = new StringBuilder();
        StringBuilder odds = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            if(i % 2 == 0){
                evens.append(String.valueOf(str.charAt(i)));
            } else {
                odds.append(String.valueOf(str.charAt(i)));
            }
        }

        return (evens.toString() + " " + odds.toString());
    }
}



