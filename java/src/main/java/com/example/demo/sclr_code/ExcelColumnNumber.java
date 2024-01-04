package com.example.demo.sclr_code;

import java.util.HashMap;

public class ExcelColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(columnNumber("AAA")); 
		
	}
	
	
	public static int columnNumber(String s) {
		HashMap<Character,Integer> alphabet = alphabet();
		int result = 0; 
		int position = 0; 
		for(int i=s.length()-1; i>=0; i--) {
			Character ch = Character.valueOf(s.charAt(i));
			result = result + alphabet.get(ch) * (int)Math.pow(26, position);
			position ++;
		}
		return result;
	}
	
	
	public static HashMap<Character, Integer> alphabet(){
		HashMap<Character, Integer> hm = new HashMap<>();
	    for(int i='A'; i<='Z'; i++){
	    	hm.put(Character.valueOf((char)i), i-64);
	    }
	    return hm;
	}

}
