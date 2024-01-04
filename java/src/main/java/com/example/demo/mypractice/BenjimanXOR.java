/*
 * find pair where xor of particular bit index is one. 
 * given array and queries containg bit index.
 */


package com.example.demo.mypractice;

import java.util.Arrays;

public class BenjimanXOR {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solve(new int[] {1,2,3,4}, new int[] {0,1,2}) ));

	}
	
	public static int[] solve(int[] A, int[] B) {
        int[] ones = new int[32]; 
        for(int i=0; i<ones.length; i++){
            for(int j=0; j<A.length; j++){
                if((A[j]&1<<i) != 0 ){
                    ones[i] = ones[i]+1;
                }
            }
        }
        
        int[] result = new int[B.length];
        for(int i=0; i<B.length; i++){
            result[i] = ones[B[i]] * (A.length-ones[B[i]]);
        }
        return result;
        
    }

}
