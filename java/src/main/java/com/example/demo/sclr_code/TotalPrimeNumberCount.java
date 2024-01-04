/*
 * find count of prime number present in b/w 1 to N.
 */


package com.example.demo.sclr_code;

import java.util.ArrayList;

public class TotalPrimeNumberCount {

	public static void main(String[] args) {
		
		optimizedBestSolution(100000);
		System.out.println("---------------------------------");
		simpleSolution(100000);
	}
	
	
	
	public static void simpleSolution(int n) {
		int countOfPrimeNumbers = 0;
		ArrayList<Integer> primeNumbersList = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			int totalFactors = 0;
			for(int j=1; j<=i; j++) {
				if(i%j == 0) {
					totalFactors += 1;
					if(totalFactors > 2) {	//will improve code 
						break;
					}
				}
			}
			if(totalFactors == 2) {
				countOfPrimeNumbers += 1 ;
				primeNumbersList.add(i);
			}	
		}
		System.out.println("count of prime number between 1 to "+n+" is : " + countOfPrimeNumbers);
		System.out.println("the Prime numbers are : "+primeNumbersList);
	}
	
	
	public static void optimizedBestSolution(int n) {
		int countOfPrimeNumbers = 0;
		ArrayList<Integer> primeNumbersList = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			int totalFactors = 0;
			for(int j=1; j<= i/j; j++) {
				if(i%j == 0 ) {
					if(j != i/j) {
						totalFactors += 2;
					}else {
						totalFactors += 1;
					}
					if(totalFactors > 2) {	//will improve code 
						break;
					}
				}
			}
			if(totalFactors == 2) {
				countOfPrimeNumbers += 1;
				primeNumbersList.add(i);
			}
		}
		System.out.println("count of prime number between 1 to "+n+" is : " + countOfPrimeNumbers);
		System.out.println("the Prime numbers are : "+primeNumbersList);	
	}
	

}
