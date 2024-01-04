package com.example.demo.sclr_code;

public class AddTwoBinaryStrings {

	public static void main(String[] args) {
		
		System.out.println( addBinary("110", "11") );

	}
	
	
    static String addBinary(String A, String B)
    {  
        // start from last index
        int i = A.length()-1;
        int j = B.length()-1;
        // initialize the carry
        int carry = 0;
        // initialize the sum
        int sum = 0;
        StringBuilder result =  new StringBuilder();
        
        while(i>=0 || j>=0 || carry == 1){
            sum = carry;
            if(i>=0) sum = sum+A.charAt(i)-'0';   // char - '0'  will give the bit value  0/1
            if(j>=0) sum = sum+B.charAt(j)-'0';
            result.append((char)(sum%2+'0'));
            carry = sum/2;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}








