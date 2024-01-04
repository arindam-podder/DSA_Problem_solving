/*
 * given a number N , find total number of factors. 
 * also print the factors (optional)
 */

package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.Collections;

public class TotalFactorsOfANumber {

	public static void main(String[] args) {
		
		System.out.println("-------------------------");
		bestApproach(1000000432);
		System.out.println("-------------------------");
		approach1(1000000432);
		System.out.println("-------------------------");
	}
	
	
	public static void approach1(Integer n) {
		int totalFactorsCount=0;
		ArrayList<Integer> factorsList = new ArrayList<>();
		for(int i=1; i<=n; i++) {		// or i<=n/2 , but need to add 1 at last to get total factors 
			if(n%i == 0 ) {
				totalFactorsCount += 1;
				factorsList.add(i);
			}
		}
		System.out.println("(approach1) total factors count of number ["+n+"] is : " + totalFactorsCount );
		System.out.println("Factors are : "+ factorsList);
	}

	public static void bestApproach(Integer n) {
		int totalFactorsCount = 0;
		ArrayList<Integer> factorsList = new ArrayList<>();
		for(int i=1; i<= n/i; i++) {	//sqrt(n) , i*i <=n  	
			if(n%i == 0) {
				if(i != n/i) {
					totalFactorsCount += 2;
					factorsList.add(i);
					factorsList.add(n/i);
				}else {
					totalFactorsCount +=1;
					factorsList.add(i);
				}
			}
		}
		Collections.sort(factorsList);		
		System.out.println("(bestApproach) total factors count of number ["+n+"] is : " + totalFactorsCount);
		System.out.println("Factors are : "+ factorsList);
	}
	
}















