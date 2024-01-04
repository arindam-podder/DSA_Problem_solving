/**
 * Q2. Pair Sum divisible by M
 * 
Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).
Note: Ensure to handle integer overflow when performing the calculations.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2
Input 2:
 A = [5, 17, 100, 11]
 B = 28
s
Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
Explanation 2:
 There is only one pair which is divisible by 28 is (17, 11)
 */


package com.example.demo.sclr_code;

import java.util.HashMap;

public class PairSumDivisibleByM {

	public static void main(String[] args) {
	
		System.out.println( optimizedSolution(new int[]{5,17,100,11, 23}, 28));

	}
	
	public static int optimizedSolution(int[] A, int B){ 		// more accurate is in scaler online ide 
        //make remainder freequecy map
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<A.length; i++){
            hm.put(A[i]%B ,  hm.getOrDefault(A[i]%B , 0)+1);
        }      
        long result = 0; 
        for(Integer key: hm.keySet()){
            if(key==0){
                int freequecy = hm.get(key);            
                result = result + ((freequecy * (freequecy-1)) / 2) ;   //nCr formula = n*(n-1) / r
            }
            else if(B%2==0 && key==B/2 ){        //if B is even , then for mid value apply nCr 
                int freequecy = hm.get(key);            
                result = result + ((freequecy * (freequecy-1)) / 2) ;
            }else{
            	if(hm.get(key)<B) { 		//checking already use in pairing or not 
            		result = result + (hm.get(key) * hm.getOrDefault(B-key , 0) );
                	if(hm.containsKey(B-key)) {
                		//hm.remove(B-key);
                		hm.put(B-key, B);		//one one key paired , we are making value B
                	}
            	}
            }
        }
        
        return (int) result%1000000007;
        
        

    }

}











