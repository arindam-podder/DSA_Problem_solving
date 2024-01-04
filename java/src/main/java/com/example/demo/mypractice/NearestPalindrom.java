package com.example.demo.mypractice;


//1<= n <=1000   999


public class NearestPalindrom {

	public static void main(String[] args) {
		
		System.out.println( nearestPalindrome(112) );
		
	}
	
	
	public static int nearestPalindrome(int number) {
		int higherPlaindrome = 0;
		for(int i=number+1; i<=Integer.MAX_VALUE; i++) {
			if(checkPlaindrome(i)) {
				higherPlaindrome = i;
				break ; 
			}
		}
		int lowerPalindrome =0 ; 
		for(int i=number-1; i>=1; i--) {
			if(checkPlaindrome(i)) {
				lowerPalindrome = i;
				break ; 
			}
		}
		
		if((higherPlaindrome-number) > (number-lowerPalindrome)) {
			return lowerPalindrome;
		}else {
			return higherPlaindrome;
		}
	}
	
	public static boolean checkPlaindrome(int n) {	 
		int temp = n ;
		int reverse = 0;
		int rem = 0; 
		while(n>0) {
			rem = n%10; 
			reverse = (reverse*10) + rem; 	
			n = n/10;		
		}
		if(reverse == temp) {
			return true; 
		}else { return false; } 
	}

}




