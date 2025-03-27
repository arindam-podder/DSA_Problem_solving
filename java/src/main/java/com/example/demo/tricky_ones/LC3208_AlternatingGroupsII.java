/**
 * 3208. Alternating Groups II

There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. 
The color of tile i is represented by colors[i]:
colors[i] == 0 means that tile i is red.
colors[i] == 1 means that tile i is blue.
An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group 
except the first and last one has a different color from its left and right tiles).

Return the number of alternating groups.
Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

 

Example 1:
Input: colors = [0,1,0,1,0], k = 3
Output: 3

Explanation:
Alternating groups:

Example 2:
Input: colors = [0,1,0,0,1,0,1], k = 6
Output: 2
Explanation:
Alternating groups:

Example 3:
Input: colors = [1,1,0,1], k = 4
Output: 0
Explanation:


Constraints:
3 <= colors.length <= 10^5
0 <= colors[i] <= 1
3 <= k <= colors.length

 */



package com.example.demo.tricky_ones;

public class LC3208_AlternatingGroupsII {

	public static void main(String[] args) {

	}
	
	
	/*
	 * use two pointer , keep moving right pointer till alternating 
	 * see : https://www.youtube.com/watch?v=h_N7TOQMrJk
	 */
    public static int numberOfAlternatingGroups1(int[] arr, int k) {
        int n = arr.length; 
        int count = 0 ; 
        int l = 0; 
        int limit = n + k-1;
        while(l<n) {
        	int r = l+1; 
        	while(r<limit && arr[(r-1)%n] != arr[r%n]) {
        		r++;
        	}
        	
        	//add valid to count 
        	if(r-l >= k) {
        		count += r-l-k+1;
        	}
        	l = r;
        }
        return count;
    }
 
}
















