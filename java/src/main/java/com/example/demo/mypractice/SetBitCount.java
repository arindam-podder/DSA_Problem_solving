package com.example.demo.mypractice;

public class SetBitCount {

	public static void main(String[] args) {
	
		System.out.println(totalSetBit(13));
		
	}

	
	public static int totalSetBit(int n) {
		int setBitCount = 0;
		for( ; n>0; n = n>>1) {
			if( (n&1) > 0 ) {
				setBitCount = setBitCount + 1; 
			}
		}
		return setBitCount; 
	}
	
}
