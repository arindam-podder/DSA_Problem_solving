/*
 * Q1. Russian Doll Envelopes

Problem Description
Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope
and A[i][1] denotes the width of the ith envelope.
One envelope can fit into another if and only if both the width and height of one envelope is greater 
than the width and height of the other envelope.
Find the maximum number of envelopes you can put one inside other.

Problem Constraints
1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109

Input Format
The only argument given is the integer matrix A.

Output Format
Return an integer denoting the maximum number of envelopes you can put one inside other.

Example Input
Input 1:
 A = [ 
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]  
     ]
Input 2:
 A = [     '
         [8, 9]
         [8, 18]    
     ]

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Step 1: put [2, 3] inside [5, 4]
 Step 2: put [5, 4] inside [6, 7]
 3 envelopes can be put one inside other.
Explanation 2:
 No envelopes can be put inside any other so answer is 1.
 */


package com.example.demo.sclr_code.dynamic_programing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RussianDollEnvelopes implements Comparator<PairHW>{

	public static void main(String[] args) {
		//int[][] arr = {{5,4}, {6,4}, {6,7}, {2,3}};
		int[][] arr = {{5,4} };
		
		System.out.println(  maxEnvelopCanBePut(arr) );
	}
	
	public static int maxEnvelopCanBePut(int[][] arr) {
		ArrayList<PairHW> envelopPair = new ArrayList<>();
		//put height=arr[i][0] and weight=arr[i][1] in pair envelopPair
		for(int i=0; i<arr.length; i++) {
			envelopPair.add( new PairHW(arr[i][0], arr[i][1]) );
		}		
		Collections.sort(envelopPair, new RussianDollEnvelopes());
		
		//now perform longest increasing order on weight
		int ans= 1; 
		int[] dp = new int[envelopPair.size()];
		dp[0] = 1; 
		for(int i=1; i<envelopPair.size(); i++) {
			int tempAns = 0; 
			for(int j=0; j<i; j++) {
				if(envelopPair.get(j).weight < envelopPair.get(i).weight && envelopPair.get(j).height < envelopPair.get(i).height ) {
					tempAns = Math.max(tempAns, dp[j]);
				}
			}
			dp[i] = tempAns+1; 
			ans = Math.max(ans, dp[i]); 
		}
		return ans;
	}
	
	@Override
	public int compare(PairHW o1, PairHW o2) {
		if(o1.height < o2.height) return -1; 
		else if(o1.height > o2.height) return 1;
		else {
			return o1.weight - o2.weight;
		}
	}
	
}



/**
 * class Pair of heigth and Width , required for the above problem 
 * @author hp
 */
class PairHW{
	int height;
	int weight; 
	PairHW(){
	}
	
	PairHW(int h, int w){
		this.height = h;
		this.weight = w; 
	}
	
	@Override
	public String toString() {
		return "PariHW("+this.height +","+this.weight +")";
	}
}










