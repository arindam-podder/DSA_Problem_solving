// exmaple : abbcd   ,     apple     ,     acbb  
 
//      abbc d cbba  , 	   appl e lppa  ,  ac bb ca
       


package com.example.demo.mypractice;

public class MakePalindrome {

	public static void main(String[] args) {
		
		System.out.println( makePlaindrome("abbcd"));

	}
	
	
	public static String makePlaindrome(String s) {		
		char lastChar = s.charAt(s.length()-1); 
		if(lastChar == s.charAt(s.length()-2)) {
			String doRev = s.substring(0, s.length()-2);
			String rev = ""; 
			for(int i=0; i<doRev.length(); i++) {
				rev = doRev.charAt(i) + rev;
			}
			return s+rev;
			
		}else {
			String doRev = s.substring(0, s.length()-1);
			String rev = ""; 
			for(int i=0; i<doRev.length(); i++) {
				rev = doRev.charAt(i) + rev;
			}
			return s+rev;
		}
	}
	
}
