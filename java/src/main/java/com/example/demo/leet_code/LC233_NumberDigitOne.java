/**
 * 233. Number of Digit One

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example 1:
Input: n = 13
Output: 6

Example 2:
Input: n = 0
Output: 0
 
Constraints:
0 <= n <= 109
 */


package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC233_NumberDigitOne {

	public static void main(String[] args) {
		int n = 13;
		
		System.out.println( countDigitOne1(n) );
		System.out.println( countDigitOne2(n) );
	}
	
	
	//Time Limit Exceeded
	//  35 / 38 testcases passed
    public static int countDigitOne1(int n) {
        int res = 0; 
        for(int i=1; i<=n; i++) {
        	res += oneCount(i);
        }
        return res;
    }
    public static int oneCount(int n) {
    	int cnt = 0; 
    	while(n!= 0) {
    		if(n%10 == 1) cnt += 1;
    		
    		n = n/10;
    	}
    	return cnt;
    }
    
    
    
    public static int countDigitOne2(int n) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int res = 0; 
        for(int i=1; i<=n; i++) {
        	res += recur(i, map);
        }
        return res;
    }
    
    // dp
    public static int recur(int n, Map<Integer, Integer> map) {
    	if(n<=1) return n;
    	
    	if(map.containsKey(n)) return map.get(n);
    	
    	int cnt = n%10==1?1:0;
    	cnt += recur(n/10, map);
    	map.put(n, cnt);
    	return map.get(n);
    }

}






















