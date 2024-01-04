package com.example.demo.mypractice;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("forLoopApproach : "+ forLoopApproach(5));
		System.out.println("whileLoopApproach : "+ whileLoopApproach(5));
		System.out.println("recursiveApproach : "+ recursiveApproach(5));
	}
	
	public static long forLoopApproach(int n) {
		if(n ==0 ) { return 1; };
		long result = 1;
		for(int i=n; i>=1; i--) {
			result = result * i;
		}
		return result;
	}
	
	public static long whileLoopApproach(int n) {
		if(n == 0) { return 1; }
		long result=1;
		while(n>0) {
			result = result * n;
			n-=1;
		}
		return result;
	}
	
	public static long recursiveApproach(int n) {
		if(n == 0) { return 1; }
		return n * recursiveApproach(n-1);
	}
}


