/**
 * 1524. Number of Sub-arrays With Odd Sum

Given an array of integers arr, return the number of subarrays with an odd sum.
Since the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

Example 2:
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

Example 3:
Input: arr = [1,2,3,4,5,6,7]
Output: 16
 
Constraints:
1 <= arr.length <= 105
1 <= arr[i] <= 100

 */


package com.example.demo.leet_code;

public class LC1524_NumberOfSubArraysWithOddSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,5,6,7};
		
		System.out.println( numOfSubarrays1(arr) );
		System.out.println( numOfSubarrays2(arr) );
		
	}
	
	
	// brute force - find all sub array , get sum and check  //TLE
    public static int numOfSubarrays1(int[] arr) {
        int res = 0; 
        for(int start=0; start<arr.length; start++) {
        	for(int end=start; end<arr.length; end++) {
        		int curSum = 0, l=start, r=end; 
        		while(l<=r) {
        			curSum += arr[l];
        			l++;
        		}
        		
        		if(curSum%2 == 1) res += 1;
        	}
        }
        return res; 
    }
    
    
    // prefix sum logic  //TLE
    public static int numOfSubarrays2(int[] arr) {
    	int mod = 1000000007;
    	int[] prefixSum = prefixSum(arr);
    	int res = 0; 
    	for(int i=0; i<arr.length; i++) {
    		for(int j=i; j<arr.length; j++) {
    			int sum = 0;
    			if(i==0) {
    				sum = prefixSum[j]; 
    			}else {
    				sum = prefixSum[j] - prefixSum[i-1];
    			}
    			
    			if(sum%2 == 1) {
    				res += 1;
    			}
    		}
    	}
    	return res;
    }
    
    public static int[] prefixSum(int[] arr) {
    	int[] result = new int[arr.length];
    	result[0] = arr[0];
    	for(int i=1; i<arr.length; i++) {
    		result[i] = result[i-1] + arr[i]; 
    	}
    	return result;
    }
    
    
    /*
     * 	Maintain a prefixSum and update its parity (odd/even).
	 *	If prefixSum is odd, it means:
	 *	 	even_count + 1 subarrays with odd sum.
	 *	If prefixSum is even, it means:
	 *		odd_count subarrays with odd sum
     */
    public static int numOfSubarrays3(int[] arr) {
    	int mod = 1000000007; 
    	int oddCount = 0; int evenCount = 0; 
    	int prefix = 0; 
    	int res = 0; 
    	for(int n: arr) {
    		prefix += n; 
    		if(prefix%2 == 0) {
    			res = (res + oddCount) % mod;
    			evenCount++;
    		}else {
    			res = (res + evenCount + 1)%mod;
    			oddCount++;
    		}
    	}
    	return res;
    }

}








