package com.example.demo.mypractice;

public class ApowerBmodeM {

	public static void main(String[] args) {
		System.out.println("loop : "+ aPowerBModeM(6, 7, 15) );
		
		System.out.println("fastPowerRecursive : "+ fastPowerRecursive(2, 31, 33) );
		
		System.out.println("fastPowerIterativeForLoop : "+ fastPowerIterativeForLoop(6, 7, 15));;
	}
	
	
	public static int aPowerBModeM(int a,int b, int mod) {		// give a^b % mod
		//int a = 3;
		//int b = 5;
		//int mod = 7;
		int result = 1 ;
		for(int i=1; i<=b; i++) {
			result = (result * a) % mod; 
		}
		return result;
	}
	
	
	public static int fastPowerRecursive(int a,int b, int mod) {
		if(b==0) {
			return 1; 
		}
		if(b%2 == 0) {
			return fastPowerRecursive((a*a)%mod, b/2, mod);
		}else {
			return (a * fastPowerRecursive((a*a)%mod, b/2, mod)) % mod ;
		}
	}
	
	
	public static int fastPowerIterativeForLoop(int a, int b, int mod) {
		if(b==0) {
			return 1 % mod; 
		}
		
		int result = 1;
		for( ; b>0; ) {
			if(b%2 == 0) {
				a = (a*a) % mod;
			}
			else {
				result = (result * a) % mod ;
			}
			b = b/2;
		}
		return result;
	}

}





