//Split the binary string into substrings with equal number of 0s and 1s

package com.example.demo.sclr_code;

public class SplitBinaryStringIntoSubstringOf0sAnd1s {

	public static void main(String[] args) {
		System.out.println(maxNumSubstring("0111001010"));
	}
	
	
	static int maxNumSubstring(String s) {
		int zeros = 0; 
		int ones = 0;
		int substringCount = 0;
		
		for(int i=0; i< s.length(); i++) {
			if(s.charAt(i) == '0') {
				zeros = zeros + 1;
			}else {
				ones = ones + 1;
			}
		
			if(zeros == ones) {
				substringCount = substringCount + 1;
			}
		}
		
		if(zeros != ones) {
			return 0;
		}
		
		return substringCount;
	}
}


