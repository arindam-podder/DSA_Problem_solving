/*
 * Q3. MAX and MIN

Problem Description
Given an array of integers A.
The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.


Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000

Input Format
The first and only argument given is the integer array A.

Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.

Example Input
Input 1:
 A = [1]
Input 2:
 A = [4, 7, 3, 8]

Example Output
Output 1:
 0
Output 2:
 26


Example Explanation
Explanation 1:
Only 1 subarray exists. Its value is 0.
Explanation 2:
value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
 */

package com.example.demo.sclr_code;

import java.util.Stack;

public class MaxAndMin {

	public static void main(String[] args) {
		int[] arr = {4,7,3,8};
		//leftMin(arr);
		//rightMin(arr);
		//leftMax(arr);
		//rightMax(arr);
		System.out.println(subarraySum(arr));
	}
	
	public static int subarraySum(int[] arr) {
		int[] leftMax = leftMax(arr);
		int[] leftMin = leftMin(arr);
		int[] rightMax = rightMax(arr);
		int[] rightMin = rightMin(arr);
		int mod = 1000000007;
		long ans = 0; 
		for(int i=0; i<arr.length; i++) {
			ans = (ans%mod)+ (( arr[i] * ( (i-leftMax[i])*(rightMax[i]-i) - (i-leftMin[i])*(rightMin[i]-i) ) )%mod )%mod;
		}
		return (int)ans;
	}
	
	public static int[] leftMin(int[] arr) {			//saving index value
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			while(!st.isEmpty() &&  arr[st.peek()] > arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i] = st.peek();
			}
			st.push(i);
		}
		return ans;
	}
	public static int[] rightMin(int[] arr) {
		Stack<Integer> st = new Stack<>(); 
		int[] ans = new int[arr.length]; 
		for(int i=arr.length-1; i>=0; i--) {
			while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i] = arr.length;
			}else {
				ans[i] = st.peek();
			}
			st.push(i);
		}
		return ans;
	}
	public static int[] leftMax(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length]; 
		for(int i=0; i<arr.length; i++) {
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i] = st.peek();
			}
			st.push(i);
		}
		return ans;
	}
	public static int[] rightMax(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length]; 
		for(int i=arr.length-1; i>=0; i--) {
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i] = arr.length;
			}else {
				ans[i] = st.peek();
			}
			st.push(i);
		}
		return ans;
	}

}

class NewSolution{				//correct 

	public int solve(int[] A) {
	    // approach : contribution technique
	    /*
	    step1: generate next smaller element index array on left NSLI
	    similarly NSRI, NGLI and NGRI
	
	    Note: to handle duplicate entries that is when ther are two or more 
	    entries of same value in A, will lead to wrong calculation,it will unnecessarily 
	    count extra number of times so it can be handled in below way 
	    
	    1. while generating NSLI and NSRI arrays: 
	       => while generating NSLI consider the index up to the index which has 
	          a value strictly less than A[i] on the left of i 
	       => while generating NSRI consider the index up to the index which has 
	          a value <= A[i] on the right of i 
	
	    2. similarly while generating NGLI and NGRI arrays: (handle it as above)
	       => while generating NGLI consider the indx up to the index which has 
	          a value strictly greater than A[i] on the left of in
	       => while generating NGRI consider the index up to the index which has 
	          a value >= A[i] on the right of i 
	
	    
	    step 2: as we know ans = sum(maxs of all subarrays) - sum (mins of all subarrays)
	
	    we can find out the sum(maxs of all subarrays) by iterating through all the values 
	    in A and we can find the no of times the value A[i] will remain max in all subarrays 
	    using the 4 generated arrays aka NSLI NSRI, NGLI and NGRI
	
	    for every A[i]: fomula for calculating the no of times it would remain max in subarrys is: 
	    (i - NSLI[i]) * (NSRI[i] - i)
	
	    similarly for calculating the no of times A[i] would remain min in 
	    all subarrays is: 
	    (i - NGLI[i]) * (NGRI[i] - i)
	
	    */
	
	    long mod = 1000000007;
	    int len = A.length;
	   
	    // step 1: 
	    int[] NSLI = generateNSLI(A);
	    int[] NSRI = generateNSRI(A);
	    int[] NGLI = generateNGLI(A);
	    int[] NGRI = generateNGRI(A);
	
	    long min = 0;
	    long max = 0;
	    long ans = 0;
	    for(int i = 0; i < len; i++) {
	        /*
	        before taking mod expressions for min ans max looks like 
	        min = A[i] * (i - NSLI[i]) * (NSRI[i] - i)
	        max = A[i] * (i - NGLI[i]) * (NGRI[i] - i)
	        */
	
	        // var to store i - NSLI[i]
	        long x1 = (((long)i % mod) - ((long)NSLI[i] % mod) + mod) % mod;
	        long x2 = (((long)NSRI[i] % mod) - ((long)i % mod) + mod) % mod;
	        long x3 = (((long)i % mod) - ((long)NGLI[i] % mod) + mod) % mod;
	        long x4 = (((long)NGRI[i] % mod) - ((long)i % mod) + mod) % mod;
	
	        min = (((long)A[i] % mod) * (x1 % mod)) % mod;
	        min = ((min % mod) * (x2 % mod)) % mod;
	        
	        max = (((long)A[i] % mod) * (x3 % mod)) % mod;
	        max = ((max % mod) * (x4 % mod)) % mod;
	        //min = ((((A[i] % mod) * ((i - NSLI[i]) % mod) % mod) * ((NSRI[i] - i) % mod)) % mod);
	        //max = ((((A[i] % mod) * ((i - NGLI[i]) % mod) % mod) * ((NGRI[i] - i) % mod)) % mod);
	        
	        ans = ((ans % mod) + (max % mod)) % mod;
	        ans = ((ans % mod) - (min % mod) + mod) % mod;
	    }
	
	    ans = ans % mod;
	    int res = (int)ans;
	    return res;
	
	}
	
	public static int[] generateNSLI(int[] A) {
	    int len = A.length;
	    int[] NSLI = new int[len];
	    Stack<Integer> s = new Stack<>();
	
	    for(int i = 0; i < len; i++) {
	        while((!s.isEmpty()) && A[s.peek()] >= A[i]) {
	            s.pop();
	        }
	
	        if(!s.isEmpty()) {
	            NSLI[i] = s.peek();
	        }
	        else {
	            NSLI[i] = -1;
	        }
	        
	        s.push(i);
	    }
	
	    return NSLI;
	}
	
	public static int[] generateNSRI(int[] A) {
	    int len = A.length;
	    int[] NSRI = new int[len];
	
	    Stack<Integer> s = new Stack<>();
	
	    for(int i = len - 1; i >= 0; i--) {
	        while((!s.isEmpty()) && A[s.peek()] > A[i]) {
	            s.pop();
	        }
	
	        if(!s.isEmpty()) {
	            NSRI[i] = s.peek();
	        }
	        else {
	            NSRI[i] = len;
	        }
	
	        s.push(i);
	    }
	    
	    return NSRI;
	}
	
	public static int[] generateNGLI(int[] A) {
	    int len = A.length;
	    int[] NGLI = new int[len];
	    Stack<Integer> s = new Stack<>();
	
	    for(int i = 0; i < len; i++) {
	        while((!s.isEmpty()) && A[s.peek()] <= A[i]) {
	            s.pop();
	        }
	
	        if(!s.isEmpty()) {
	            NGLI[i] = s.peek();
	        }
	        else {
	            NGLI[i] = -1;
	        }
	        
	        s.push(i);
	    }
	
	    return NGLI;
	}
	
	public static int[] generateNGRI(int[] A) {
	    int len = A.length;
	    int[] NGRI = new int[len];
	
	    Stack<Integer> s = new Stack<>();
	
	    for(int i = len - 1; i >= 0; i--) {
	        while((!s.isEmpty()) && A[s.peek()] < A[i]) {
	            s.pop();
	        }
	
	        if(!s.isEmpty()) {
	            NGRI[i] = s.peek();
	        }
	        else {
	            NGRI[i] = len;
	        }
	
	        s.push(i);
	    }
	    
	    return NGRI;
	}


}






