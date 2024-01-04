/*
 * Q1. Compute nCr % m
Problem Description
Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

Problem Constraints
1 <= A * B <= 106
1 <= B <= A
1 <= C <= 106

Input Format
The first argument given is integer A ( = n).
The second argument given is integer B ( = r).
The third argument given is integer C ( = m).

Output Format
Return the value of nCr % m.

Example Input
Input 1:
 A = 5
 B = 2
 C = 13
Input 2:
 A = 6
 B = 2
 C = 13

Example Output
Output 1:
 10
Output 2:
 2

Example Explanation
Explanation 1:
 The value of 5C2 % 11 is 10.
Explanation 2:
 The value of 6C2 % 13 is 2.
 */


package com.example.demo.sclr_code;

public class NCRMod {
	
	public static void main(String[] args) {
		
		System.out.println(optimizedPascalAlgo(3,2,33));
		
	}
	
	 public static int optimizedPascalAlgo(int A, int B, int C){
	        int[][] pascal = new int[A+1][B+1];
	        for(int i=0; i<pascal.length; i++){
	            for(int j=0; j<=B; j++){
	                if(i<j){
	                    pascal[i][j] = 0;
	                }
	                else if(j==0){
	                    pascal[i][j] = 1; 
	                }
	                else{
	                    pascal[i][j] = (pascal[i-1][j-1]+pascal[i-1][j] )%C;
	                }
	            } 
	        }
	        return pascal[A][B];
	    }

	
	 public int usedInverseFermat(int A, int B, int C){ 			//nCr %m = n!%m * (n-r)!^-1 %m  * r!^-1 %m 
	        int AF = factorial(A, C);
	        int BF = factorial(B, C);
	        int ABF = factorial(A-B, C);
	        long ABFPow = fastPower(ABF, C-2, C);
	        long BFPow = fastPower(BF, C-2, C);
	        return (int) (AF%C * (BFPow%C * ABFPow%C)%C) %C;
	    }
	    public int factorial(int number , int mod){
	        long fact = 1; 
	        for(int i=1; i<=number; i++){
	            fact = (fact%mod * i%mod)%mod;
	        }
	        return (int)fact;
	    }
	    public int fastPower(int A, int power, int mod){
	        if(A==0){
	            return 0;
	        }if(power==0){
	            return 1;
	        }
	        long ans = fastPower(A, power/2, mod);
	        if(power%2==0){
	            return (int) (ans%mod * ans%mod)%mod;
	        }else{
	            return (int) ((ans%mod * ans%mod)%mod * A%mod)%mod ; 
	        }
	    }
	
	


}





















