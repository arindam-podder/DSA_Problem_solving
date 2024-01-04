package com.example.demo.mypractice;

public class ModularOperator {

	public static void main(String[] args) {
		//(11^91 + 10^91 - 9^2) big numbers it fails 
		int real = 5934;
		int val = real;
		int temp=0;
		while(val>0) {
			temp = temp * 10 + val%10;		// '%' modular gives remainder
			val = val/10;
		}
		
		System.out.println(temp);		
	
		
		ModularOperator.execute();
	}
	
	static void execute() {
		// checking double to int  
		double val = 44.66;
		System.out.println( (int)val );
	}
	
	
}
