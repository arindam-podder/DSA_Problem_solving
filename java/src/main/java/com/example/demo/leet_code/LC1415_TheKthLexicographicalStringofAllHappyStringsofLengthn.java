/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n

A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" 
are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

Example 1:
Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

Example 2:
Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.

Example 3:
Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 
Constraints:
1 <= n <= 10
1 <= k <= 100
 */



package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1415_TheKthLexicographicalStringofAllHappyStringsofLengthn {

	public static void main(String[] args) {

	}
	
	public static String getHappyString(int n, int k) {
        List<String> nLenStr = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
        //push a b c 
        queue.add("a"); 
        queue.add("b"); 
        queue.add("c"); 
        while( !queue.isEmpty() ) {
        	String cur = queue.poll();
        	if(cur.length() == n ) {
        		nLenStr.add(cur); 
        		continue;
        	}
        	
        	char lastChar = cur.charAt(cur.length() - 1);
            if (lastChar == 'a') {
                queue.offer(cur + "b");
                queue.offer(cur + "c");
            } else if (lastChar == 'b') {
                queue.offer(cur + "a");
                queue.offer(cur + "c");
            } else {
                queue.offer(cur + "a");
                queue.offer(cur + "b");
            }
        }
        
        if (nLenStr.size() < k) {
            return "";
        }
        return nLenStr.get(k - 1);
        
    }

}














