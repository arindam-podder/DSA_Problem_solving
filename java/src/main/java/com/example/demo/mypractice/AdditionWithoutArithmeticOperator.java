package com.example.demo.mypractice;

public class AdditionWithoutArithmeticOperator {

	public static void main(String[] args) {
	
		System.out.println(withOutArithmetic(12,12));
		
	}
	
	public static int withOutArithmetic(int a, int b) {
		while(b != 0) {
			int carray = a & b;				
			
			a = a ^ b;			
			
			b = carray<<1; 
		}
		return a;
	}

}
