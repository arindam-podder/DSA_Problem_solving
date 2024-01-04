package com.example.demo.mypractice;

import java.util.Scanner;

public class DecreaseIncrease {

	public static void main(String[] args) {
		
		System.out.println( check() );
		
	}
	
	
	public static boolean check() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("how many number u wnat as input: ");
		int total = sc.nextInt(); 
		System.out.println("enter each number in new line.");
		int p1 = sc.nextInt(); 
		boolean isDecreasing = true;
		//int statusCount = 0; 
		for(int i=2; i<=total; i++) {
			int p2 = sc.nextInt();
			
			if(p2 == p1) {
				return false; 
			}
			if(p2 > p1) {
				if(isDecreasing) {
					isDecreasing = false;
				}
			}
			else {
				if(isDecreasing == false) {
					return false;
				}
			}
		}
		return true;
		
	}

}
