package com.example.demo.mypractice;

public class LCM {

	public static void main(String[] args) {
		System.out.println(commonLogic(40, 41));
		System.out.println(lcmMathRule(40, 41));

	}

	
	static int commonLogic(int n1, int n2) {
		if(n1%n2 == 0 ) {
			return n1;
		}
		if(n2%n1 == 0) {
			return n2;
		}
		if(n1<n2) {
			for(int i=2; i<=n2; i++){
				if(n1*i % n2 == 0 ) {
					return n1*i;
				}
			}
		}else {
			for(int i=2; i<=n1; i++) {
				if(n2*i % n1 == 0) {
					return n2*i;
				}
			}
		}
		
		//common return - for satisfying return value  
		return 0;
	}
	

	//another math rule lcm(n1,n2) = n1*n2 / gcd(n1,n2)
	static int lcmMathRule(int n1, int n2) {
		return (n1*n2) / GCD.euclideanAlgorithm(n1, n2);
	}
	
}
