/*
 * Q3. Median of Array

Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:
The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

Problem Constraints
1 <= N + M <= 2*106

Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.

Output Format
Return a decimal value denoting the median of two sorted arrays.

Example Input
Input 1:
 A = [1, 4, 5]
 B = [2, 3]
Input 2:
 A = [1, 2, 3]
 B = [4]

Example Output
Output 1:
 3.0
Output 2:
 2.5

Example Explanation
Explanation 1:
 The median of both the sorted arrays will be 3.0.
Explanation 2:
 The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */


package com.example.demo.sclr_code.searching;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoArray {

	public static void main(String[] args) {
		//A : [ -43, -25, -18, -15, -10, 9, 39, 40 ]
		//B : [ -2 ]
		ArrayList<Integer> a = new ArrayList<>();
		a.add(-43);
		a.add(-25);
		a.add(-18);
		a.add(-15);
		a.add(-10);
		a.add(9);
		a.add(39);
		a.add(40);
		ArrayList<Integer> b = new ArrayList<>(); 
		b.add(-2); 
		
		System.out.println(median(b, a));
	}
	
	
	public static double median(List<Integer> A, List<Integer> B){			//here A should be <= B , means less size shold pass as 1st arguments 
		//edge case , if B size 0
		if(B.size() == 0) {
			if(A.size()%2 == 0 ) {
				return A.get(A.size()/2) + A.get( (A.size()/2)-1);
			}
		}
		
        int aLen = A.size(); 
        int bLen = B.size();
        int L = 0; int R = Math.min((aLen+bLen)/2 , aLen);
        while(L<=R){
            int pick_A = (L+R)/2; 
            int pick_B = ((aLen+bLen+1)/2) - pick_A;
            int l1 = (pick_A==0) ? Integer.MIN_VALUE : A.get(pick_A-1);
            int l2 = (pick_B==0) ? Integer.MIN_VALUE : B.get(pick_B-1);
            int r1 = (pick_A==aLen) ? Integer.MAX_VALUE : A.get(pick_A); 
            int r2 = (pick_B==bLen) ? Integer.MAX_VALUE : B.get(pick_B);
            if(l1<=r2 && l2<=r1){
                if( (aLen+bLen)%2 ==0 ) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0 ; 
                }else{
                    return Math.max(l1,l2);
                }
            }else if (l1>r2){
                R = pick_A-1;
            }else{
                L = pick_A+1;
            }
        }
        return -1;
    }

}


//A : [ -43, -25, -18, -15, -10, 9, 39, 40 ]
//B : [ -2 ]
//ans : -10.0












