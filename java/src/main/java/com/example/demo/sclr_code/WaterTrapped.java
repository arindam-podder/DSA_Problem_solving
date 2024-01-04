package com.example.demo.sclr_code;

public class WaterTrapped {

	public static void main(String[] args) {
		
		System.out.println(trap(new int[]{2,0,4}));

	}
	
	
	 public static int trap(final int[] A) {

	        //to know water trapped , first find lmax and rmax in each index 
	        int[] lmax = new int[A.length];
	        int curLmax = 0 ; 
	        int[] rmax = new int[A.length];
	        int curRmax = 0;
	        for(int i=0; i<A.length; i++){
	            curLmax = A[i] > curLmax ? A[i] : curLmax;
	            lmax[i] = curLmax; 
	            curRmax = A[A.length-(i+1)] > curRmax ? A[A.length-(i+1)] : curRmax; 
	             rmax[A.length - (i+1)] = curRmax;
	        }

	        int result = 0 ; 
	        for(int i=0; i<A.length; i++){
	            result = result + (Math.min(lmax[i], rmax[i]) - A[i] );
	        }
	        return result;
	 }

}
