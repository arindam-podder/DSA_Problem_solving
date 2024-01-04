package com.example.demo.sclr_code;

public class SumOfNNaturalNumber {

	public static void main(String[] args) {
		
		System.out.println("--------------------------");
		simpleSolution(100000);
		System.out.println("--------------------------");
		gaussRule(100000);
		System.out.println("--------------------------");

	}

	
	public static void simpleSolution(int n) {
		long sum = 0;
		for(int i=1; i<=n; i++) {
			sum = sum + i;
		}
		System.out.println("sum is : "+sum);
	}
	
	public static void gaussRule(int n) {	//int param giving wrong result,know why(n *n exceeding int range ) , if casting long then correct
		long sum = (long)  n* (n + 1) / 2 ;				// sum = n(n + 1) / 2
		System.out.println("sum is : "+sum);
	}
	
	
}
