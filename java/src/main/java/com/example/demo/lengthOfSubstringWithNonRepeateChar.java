/*
 * 
 * 
 *  techmojos
 *  -----------
 * 
String s = "abcdefdghjklopi";    int len = 11    string  str =  "efdghjklopi"
 
abcdef
efdghjklopi
 
 
 Employee : Id, firstname , dept
 
 
 select firstname , count(firstName) as cnt from employee group by firstName having cnt>1; 
 

*/
package com.example.demo;

public class lengthOfSubstringWithNonRepeateChar {
	public static void main(String[] args) {
		String s = "abcdefdghjklopiyq";
		
		System.out.println( getSubStringLength(s) );
	}
	
	
	public static int getSubStringLength(String s) {		//abcdefdghjklopiyq     str = efd  len = 6
		int len = 0; 
		String str = ""; 
		for(int i=0; i<s.length(); i++) {
			if(str.indexOf(s.charAt(i)) == -1 ) {
				str = str + s.charAt(i);
			}
			else{
				len  = Math.max(len, str.length()); 
				str = str.substring( str.indexOf(s.charAt(i))+1) + s.charAt(i);
			}
		}
		len  = Math.max(len, str.length());
		return len; 
	}
	
	
}
