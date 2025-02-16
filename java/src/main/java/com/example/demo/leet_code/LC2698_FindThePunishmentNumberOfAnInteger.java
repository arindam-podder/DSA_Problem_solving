/**
 * 2698. Find the Punishment Number of an Integer

Given a positive integer n, return the punishment number of n.
The punishment number of n is defined as the sum of the squares of all integers i such that:
1 <= i <= n
The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer 
values of these substrings equals i.
 
Example 1:
Input: n = 10
Output: 182
Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
- 1 since 1 * 1 = 1
- 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
- 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
Hence, the punishment number of 10 is 1 + 81 + 100 = 182

Example 2:
Input: n = 37
Output: 1478
Explanation: There are exactly 4 integers i in the range [1, 37] that satisfy the conditions in the statement:
- 1 since 1 * 1 = 1. 
- 9 since 9 * 9 = 81 and 81 can be partitioned into 8 + 1. 
- 10 since 10 * 10 = 100 and 100 can be partitioned into 10 + 0. 
- 36 since 36 * 36 = 1296 and 1296 can be partitioned into 1 + 29 + 6.
Hence, the punishment number of 37 is 1 + 81 + 100 + 1296 = 1478
 
Constraints:
1 <= n <= 1000
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC2698_FindThePunishmentNumberOfAnInteger {
	public static void main(String[] args) {
		int n = 10; 
		System.out.println( getPunishmentNumber(n) );
	}
	
	//precomputed numbers  are present  whose square's partition sum is that number  
	public static int getPunishmentNumberOptimized(int n) {
        int[] num = {1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 
        		909, 918, 945, 964, 990, 991, 999, 1000}; 
        int result = 0; 
        for(int k: num) {
        	if(k<=n) result += k*k;
        }
        return result;
    }
	
	
	//BF
	public static int getPunishmentNumber(int n) {
		int res = 0; 
		for(int i=1; i<=n; i++) {
			if(isGood(i)) res += i*i;
		}
		return res;
	}
	
	public static boolean isGood(int num) {
		int square = num * num;
		//return allPertitionWithCheck(num, 0, ""+square, new ArrayList<>());
		return allPartitionWithCheck(num, 0, ""+square, 0);
	}
	
	public static boolean allPertitionWithCheck(int num, int index, String s, List<String> cur){
		if(index == s.length()) {
			System.out.println(cur);
			//check sum in mun or not 
			int sum = 0; 
			for(String str: cur) sum += Integer.valueOf(str);
			if(sum == num) return true; 
			else return false;
		}
		
		for(int i=index+1; i<s.length(); i++) {
			String subStr = s.substring(index, i);
			cur.add(subStr); 
			if(allPertitionWithCheck(num, i, s, cur)) return true; 
			cur.remove(cur.size()-1);
		}
		return false;
	}
	
	
	//recursion partition 
	public static boolean allPartitionWithCheck(int num, int index, String s, int curSum) {
		// Base case: if we reach the end of the string
		if (index == s.length()) {
			if (curSum == num) {
				return true;
			}
			return false;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			String subStr = s.substring(index, i);
			int value = Integer.parseInt(subStr);

			// Early exit: if sum already exceeds num, no need to proceed further
			if (curSum + value > num)
				continue;

			// Recurse
			if (allPartitionWithCheck(num, i, s, curSum + value))
				return true;
			
		}
		return false;
	}
	
	
}//class end




