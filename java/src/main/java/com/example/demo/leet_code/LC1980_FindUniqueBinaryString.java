/**
 * 1980. Find Unique Binary String

Given an array of strings nums containing n unique binary strings each of length n, return a binary string 
of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 
Example 1:
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:
Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:
Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

Constraints:
n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.
 */



package com.example.demo.leet_code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC1980_FindUniqueBinaryString {

	public static void main(String[] args) {
		String[] s = {"0000", "0001", "0010"};
		
		//System.out.println( binaryString(s) );
		System.out.println( getUniqueBinary(s) );
		
	}
	
	
	//BFS - queue["o", "1"] then poll & keep adding "0" and "1" 
    public static String binaryString(String[] nums) {
    	Set<String> unique = new HashSet<>();
    	for(String s: nums) unique.add(s);
    	int lengthToChcek = nums[0].length(); 
        Queue<String> que = new LinkedList<String>();
        que.add("0");
        que.add("1"); 
        while(!que.isEmpty()) {
        	String cur = que.poll();
        	if(cur.length() == lengthToChcek) {
        		if(!unique.contains(cur)) {
        			return cur;
        		}
        	}else {
        		que.add(cur+"0"); 
        		que.add(cur+"1");         		
        	}
        }
        
        return "";
    }

    
    //using java inbuild method 
    public static String getUniqueBinary(String[] arr){
    	Set<String> unique = new HashSet<>();
    	for(String s: arr) unique.add(s);
    	int lengthToChcek = arr[0].length();
    	for (int i = 0; i < Math.pow(2, lengthToChcek); i++) {  // 2^lengthToChcek = 8 combinations
            String cur = String.format("%0"+lengthToChcek+"d", Integer.parseInt(Integer.toBinaryString(i)));
            if(!unique.contains(cur)) {
            	return cur;
            }
        }
    	return "";
    }
    
}

















