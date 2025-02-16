/**
 * 2866. Beautiful Towers II

You are given a 0-indexed array maxHeights of n integers.
You are tasked with building n towers in the coordinate line. The ith tower is built at coordinate i 
and has a height of heights[i].

A configuration of towers is beautiful if the following conditions hold:

1 <= heights[i] <= maxHeights[i]
heights is a mountain array.
Array heights is a mountain if there exists an index i such that:

For all 0 < j <= i, heights[j - 1] <= heights[j]
For all i <= k < n - 1, heights[k + 1] <= heights[k]
Return the maximum possible sum of heights of a beautiful configuration of towers.

 

Example 1:
Input: maxHeights = [5,3,4,1,1]
Output: 13
Explanation: One beautiful configuration with a maximum sum is heights = [5,3,3,1,1]. This configuration is beautiful since:
- 1 <= heights[i] <= maxHeights[i]  
- heights is a mountain of peak i = 0.
It can be shown that there exists no other beautiful configuration with a sum of heights greater than 13.
Example 2:

Input: maxHeights = [6,5,3,9,2,7]
Output: 22
Explanation: One beautiful configuration with a maximum sum is heights = [3,3,3,9,2,2]. This configuration is beautiful since:
- 1 <= heights[i] <= maxHeights[i]
- heights is a mountain of peak i = 3.
It can be shown that there exists no other beautiful configuration with a sum of heights greater than 22.
Example 3:
Input: maxHeights = [3,2,5,5,2,3]
Output: 18
Explanation: One beautiful configuration with a maximum sum is heights = [2,2,5,5,2,2]. This configuration is beautiful since:
- 1 <= heights[i] <= maxHeights[i]
- heights is a mountain of peak i = 2. 
Note that, for this configuration, i = 3 can also be considered a peak.
It can be shown that there exists no other beautiful configuration with a sum of heights greater than 18.
 
Constraints:
1 <= n == maxHeights.length <= 105
1 <= maxHeights[i] <= 109
 */

/**
 * note : LC2865 there we have use BF, for each index we get left sum  and right sum and the found max , TC(N^2)
 * but in this question constraint is huge so will not work prev approach,some how have precompute leftSum and rightSum
 */


package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC2866_BeautifulTowersII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {5, 9, 9, 8, 1, 7, 8, 3, 4, 3, 1};
		int[] arr = {6,5,3,9,2,7};
		System.out.println( getMaximumSumOfHeights(arr) );
	}
	
	/*
	 * Wrong Answer
			735 / 785 testcases passed
			Input
			maxHeights =
			[314324228,526196638,971780775,141382951,44825730,92939243,869702460,692214717,396184442,271863091,452818943,124554145,
			194393992,813279621,476977123,291285997,195696382,80619001,296691434,24194433,834306546,337273583,612960339,252148987,
			498162770,641751698,580675254,66186200,192009966,590634046,590252844,510204257,235020771,606202644,338253570,224352005,
			183647397,867961176,521468453,365745792,508222499,360685429,851354307,177768509,955097078,227459453,644376561,467834249,
			594236609,319781404,648225233,524439197,532203513,463002246,498592686,691351312,208635346,155682966,294639403,341617283,
			604365123,79112831,22440031,809193898,675993946,99928197,644324211,170555722,218906830,782039120,686747235,356537885]
	 */
	public static long getMaximumSumOfHeights(int[] maxHeights) {	
        double[] leftBeautifulSum = getLeftBeautifulSum(maxHeights);
        double[] rightBeautifulSum = getRightBeautifulSum(maxHeights);
        System.out.println( Arrays.toString(leftBeautifulSum) );
        System.out.println( Arrays.toString(rightBeautifulSum) );
        
        double max = 0; 
        for(int i=0; i<maxHeights.length; i++) {
        	double cur = leftBeautifulSum[i] + rightBeautifulSum[i] - maxHeights[i]; 	//left and right both include arr[i], so -arr[i] 
        	max = Math.max(max, cur);
        }
        return (long)max;
        
    }

	
	public static double[] getLeftBeautifulSum(int[] arr) {
		double[] result = new double[arr.length]; 
		Stack<Integer> st = new Stack<>();		//will contain the indexes
		st.add(0); 
		result[0] = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] >= arr[i-1]) {
				//beautiful continues 
				result[i] = result[i-1] + arr[i]; 
				st.add(i);
			}else {
				//remove indexes whose arr value is greater than curent arr[i]
				while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
					st.pop();
				}
				
				int lastBeatufulIndex = -1;
				if(!st.isEmpty()) {
					lastBeatufulIndex = st.peek();
				}
				
				result[i] = lastBeatufulIndex==-1 ? 
									(i-lastBeatufulIndex)*arr[i] : result[lastBeatufulIndex] + (i-lastBeatufulIndex)*arr[i];
	
				st.add(i);
			}
		}
		return result;
	}
	
	public static double[] getRightBeautifulSum(int[] arr) {
		double[] result = new double[arr.length]; 
		Stack<Integer> st = new Stack<>(); 
		result[arr.length-1] = arr[arr.length-1]; 
		st.add(arr.length-1); 
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] >= arr[i+1]) {
				//beautiful continues 
				result[i] = result[i+1] + arr[i]; 
				st.add(i);
			}else {
				//remove indexes whose arr value is greater than curent arr[i]
				while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
					st.pop();
				}
				
				int lastBeatufulIndex = arr.length;
				if(!st.isEmpty()) {
					lastBeatufulIndex = st.peek();
				}
				
				result[i] = lastBeatufulIndex==arr.length ? 
									(lastBeatufulIndex-i)*arr[i] : result[lastBeatufulIndex] + (lastBeatufulIndex-i)*arr[i];
	
				st.add(i);	
			}
		}
		return result;
	}
	
}


















