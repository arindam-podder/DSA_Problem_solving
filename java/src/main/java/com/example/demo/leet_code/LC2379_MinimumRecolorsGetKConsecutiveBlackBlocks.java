/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks

You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', 
representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
You are also given an integer k, which is the desired number of consecutive black blocks.
In one operation, you can recolor a white block such that it becomes a black block.
Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

Example 1:
Input: blocks = "WBBWWBBWBW", k = 7
Output: 3
Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW". 
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.

Example 2:
Input: blocks = "WBWBBBW", k = 2
Output: 0
Explanation:
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.
 
Constraints:
n == blocks.length
1 <= n <= 100
blocks[i] is either 'W' or 'B'.
1 <= k <= n

 */


package com.example.demo.leet_code;

public class LC2379_MinimumRecolorsGetKConsecutiveBlackBlocks {
	public static void main(String[] args) {
		
	}
	
	
	//slide window , keep track of W count
    public static int minimumRecolors1(String s, int k) {
        int result = 0; 
        int cnt = 0; 
        //build 1st slide
        for(int i=0; i<k; i++) {
        	if(s.charAt(i) == 'W') {
        		result += 1; 
        		cnt += 1;
        	}
        }
    	
        //keep sliding the window
        int j = k; 
        while(j<s.length()) {
        	if(s.charAt(j) == 'W') cnt += 1;
        	if(s.charAt(j-k) == 'W') cnt -= 1;
        	result = Math.min(result, cnt);
        	j++;
        }
        
        
        return result;
    }
	
	
}
