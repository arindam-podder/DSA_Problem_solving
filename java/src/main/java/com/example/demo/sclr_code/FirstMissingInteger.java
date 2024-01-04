/*
 * Q3. First Missing Integer

Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000
-109 <= A[i] <= 109

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the first missing positive integer.

Example Input
Input 1:
[1, 2, 0]
Input 2:
[3, 4, -1, 1]
Input 3:
[-8, -7, -6]


Example Output
Output 1:
3
Output 2:
2
Output 3:
1

Example Explanation
Explanation 1:
A = [1, 2, 0]
First positive integer missing from the array is 3.
 */

package com.example.demo.sclr_code;

public class FirstMissingInteger {

	public static void main(String[] args) {
		
		System.out.println(firstMissingPositive(new int[]{2,3,1,2}));
		
	}
	
	public static int firstMissingPositive(int[] A) {
        int i=0;
        while(i<A.length){
            int currentValueIndex = A[i]-1;
            if(A[currentValueIndex] == currentValueIndex+1) {		//duplicate case
            	i++;
            	continue;
            }
            if(A[i] >0 && A[i]<=A.length){
                if(currentValueIndex != i ){
                    int temp = A[currentValueIndex];
                    A[currentValueIndex] = A[i];
                    A[i] = temp;
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }

        for(i=0; i<A.length; i++){
            if(i+1 != A[i] ){
                return i+1;
            }
        }
        return A.length+1;
    }

}























