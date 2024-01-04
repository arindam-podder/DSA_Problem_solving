package com.example.demo.mypractice;

public class GCD {

	public static void main(String[] args) {
		System.out.println(commonLogic(1024, 1644));
		System.out.println(euclideanAlgorithm(40, 40));
	}

	
	
	//gcd of two number 
	static int commonLogic(int num1, int num2) {
		int lowestNumber = num1<num2 ? num1 : num2;
		if(num1%num2 == 0 ) {
			return num2;
		}
		if(num2%num1 == 0) {
			return num1;
		}
		int gcd = 0;
		//run for upto lowestNumber/2 
		for(int i=1; i<=lowestNumber/2; i++) {
			if(num1%i == 0 && num2%i==0) {
				gcd = i;
			}
		}
		return gcd;
	}//commonLogic end
	
	
	public static int euclideanAlgorithm(int num1, int num2) {	
		if(num1%num2 == 0 ) {
			return num2;
		}
		if(num2%num1 == 0) {
			return num1;
		}
		if(num1<num2) {
			while(true) {
				int rem = num2%num1;
				if(rem ==0 ) {
					return num1;
				}
				num2 = num1;
				num1 = rem;
			}
		}else {
			while(true) {
				int rem = num1%num2;
				if(rem == 0 ) {
					return num2;
				}
				num1 = num2;
				num2 = rem;
			}
		}
	}
	
	
}
