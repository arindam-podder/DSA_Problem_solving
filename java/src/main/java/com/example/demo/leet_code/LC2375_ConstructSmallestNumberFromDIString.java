/**
 * 2375. Construct Smallest Number From DI String

You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 
'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

num consists of the digits '1' to '9', where each digit is used at most once.
If pattern[i] == 'I', then num[i] < num[i + 1].
If pattern[i] == 'D', then num[i] > num[i + 1].
Return the lexicographically smallest possible string num that meets the conditions.

Example 1:
Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.

Example 2:
Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.
 
 
Constraints:
1 <= pattern.length <= 8
pattern consists of only the letters 'I' and 'D'.

 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC2375_ConstructSmallestNumberFromDIString {
	public static void main(String[] args) {
		String s = "IIIDIDDD";
		//String s = "DDD";
		
		System.out.println( smallestNumberStr(s) );
	
		System.out.println( optimized(s) );
	}
	
	
	public static String smallestNumberStr(String pattern) {
        List<Integer> nums = new ArrayList<>(); 
        for(int i=1; i<=9; i++) nums.add(i);
		List<Integer> cur = new ArrayList<>();
		backtrack(0, pattern, cur, nums); 
		StringBuilder sb = new StringBuilder(); 
		for(int n : cur) sb.append(n);
		
		return new String(sb);
    }
	
	
	
	//find all possibilities
	public static boolean backtrack(int idx, String di, List<Integer> cur, List<Integer> nums) {
		if(idx == di.length()+1) return true; 
		
		//loop 1-9 and try to place in the cur 
		for(int i=1; i<=9; i++) {
			if(nums.contains(i)) {
				if(idx == 0) {
					cur.add(i); 
					nums.remove(Integer.valueOf(i));
					 if( backtrack(idx+1, di, cur, nums) ) return true; 
					//backtrack 
					cur.remove(cur.size()-1); 
					nums.add(i);
				}else {
					if(di.charAt(idx-1) == 'I') {
						if(i> cur.get(cur.size()-1)) {
							cur.add(i); 
							nums.remove(Integer.valueOf(i));
							if( backtrack(idx+1, di, cur, nums) ) return true; 
							//backtrack 
							cur.remove(cur.size()-1); 
							nums.add(i);
						}
					}else {
						if(i< cur.get(cur.size()-1)) {
							cur.add(i); 
							nums.remove(Integer.valueOf(i));
							if( backtrack(idx+1, di, cur, nums) ) return true; 
							//backtrack 
							cur.remove(cur.size()-1); 
							nums.add(i);
						}
					}
				}
			}
		}//loop end
		return false;
	}
	
	
	//optimized using stack 
	public static String optimized(String s) {
		String ans = "";
		Stack<Integer> st = new Stack<>(); 
		for(int i=0; i<=s.length(); i++) {
			st.push(i+1);
			if(i>=s.length() || s.charAt(i) == 'I') {
				while(!st.isEmpty()) ans += st.pop();
			}
		}
		return ans;
	}
	
	
}













