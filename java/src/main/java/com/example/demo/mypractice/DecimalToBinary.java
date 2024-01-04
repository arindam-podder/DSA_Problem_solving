package com.example.demo.mypractice;

public class DecimalToBinary {
	
	public static void main(String[] args) {
		System.out.println(dToBinary(11));
	}
	
	
	public static String dToBinary(int num) {
		String ans = ""; 
		while(num > 0) {
			ans = num%2 + ans;
			num = num/2;
		}
		return ans; 
	}
	
}
