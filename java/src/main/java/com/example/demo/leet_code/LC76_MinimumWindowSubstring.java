/**
76. Minimum Window Substring  (Hard)

Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. If there is no such 
substring, return the empty string "".
The testcases will be generated such that the answer is unique.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 
Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 
Follow up: Could you find an algorithm that runs in O(m + n) time?
*/

package com.example.demo.leet_code;

import java.util.*;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // return minWindowString(s, t);
        return minWindowSub(s, t);
    }

    //TLE
    public static String minWindowString(String s, String t){
		Map<Character, Integer> map = createMapFromString(t); 
		int k = t.length(); 
		String result = null; 
		//for mathing t min length of substring would be k 
		for(int i=0; i<=s.length()-k; i++){
			int l=i, r=i+k-1; 
			while(r<s.length()){
				if(checkStringCoverMapOrNot(s, l, r, new HashMap(map)) ){
					String subStr = r==s.length()-1 ? s.substring(l) : s.substring(l, r+1);
					result = result==null? subStr : result.length()>subStr.length()? subStr:result;
				}

				//at a given poist if result length and t length same then simply resturn 
				if(result!= null && result.length() == t.length() ){
					return result; 
				}
				r++; 
			}
		}
		return result==null ? "": result;
	}

	public static Map<Character, Integer> createMapFromString(String s){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) +1 );
		}
		return map;
	}

	public static boolean checkStringCoverMapOrNot(String s, int l, int r, Map<Character, Integer> map){
		for(int i = l; i<=r; i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)-1); 
				if(map.get(c)==0){
					map.remove(c);
				}
			}

			if(map.size() == 0){
				return true;
			}
		}
		return false;
	}



    //window + tow pointer  (optimized)
	public static String minWindowSub(String s, String t){
		int[] arr = new int[256]; 
		int l=0, r=0, count=0, minLen=Integer.MAX_VALUE, startIndex=-1;

		//init arr with t chars
		for(int i=0; i<t.length(); i++){
			arr[t.charAt(i)]++; 
		}

		while(r<s.length()){
			if(arr[s.charAt(r)] > 0) count += 1;
			arr[s.charAt(r)]--;

			while(count == t.length()){
				if( (r-l+1) < minLen){
					minLen = r-l+1; 
					startIndex = l;
				}
				arr[s.charAt(l)]++; 
				if(arr[s.charAt(l)] > 0) count -= 1;
				l++; 
			}
			r += 1;
		}
		return startIndex==-1? "" :  startIndex+minLen==s.length()? s.substring(startIndex) : s.substring(startIndex, startIndex+minLen);
	}

}



