package com.example.demo;
import java.util.Stack;

public class RemoveAdja {

	public static void main(String[] args) {
		String s = "ABDAADBDAABB";
		
		System.out.println( removeAdja(s) );
		
	}
	
	//DBAAABDAB  
	public static String removeAdja(String s) {
		Stack<Character> st = new Stack<>(); 
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(st.empty()) st.add(c); 
			else{
				if(c != st.peek()) st.add(c);
				else{
					while(i<s.length()) {
						if(s.charAt(i) != st.peek()) {
							break;
						}
						i++;
					} 
					st.pop();
					i--;
				}
			}
		}
		String result = ""; 
		for(Character c : st) {
			result =  result + c;
		}
		return result; 
	}
	 
}
