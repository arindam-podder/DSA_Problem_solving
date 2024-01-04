package com.example.demo.mypractice;

public class StringCharOccurance {

	public static void main(String[] args) {
		System.out.println(charOccurrence("aaabbccaeeed"));
	}
	
	
	public static String charOccurrence(String s) {
		int cnt = -1; 
		String current = ""; 
		String ans = ""; 
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i); 
			if(current.indexOf(ch) != -1) {
				cnt++;
			}else {
				if(current.length() > 0) {
					ans = ans+current+cnt;
				}
				current = ch+"";
				cnt = 1; 
			}
		}
		ans = ans+current+cnt;
		return ans; 
	}

}
