package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectiveUnbannedWord {

	public static void main(String[] args) {
		
		ArrayList<String> al1 = new ArrayList<>();
		al1.add("bb"); 
		al1.add("cc"); 
		al1.add("c"); 
		al1.add("b"); 
		al1.add("ab");
		al1.add("b");
		al1.add("cc");
		al1.add("a");
		al1.add("a");
		
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("c");
		al2.add("b");
		
		System.out.println(solve(al1, al2));

	}
	
	 public static String solve(ArrayList<String> A, ArrayList<String> B) {
	       //Collections.sort(A);
	        HashMap<String, Integer> hm = new HashMap();
	        String result = "";
	        int freequecy = 0;
	        for(String s : A){
	            if(!B.contains(s)){
	                if(hm.containsKey(s)){
	                    hm.put(s, hm.get(s)+1 );
	                }else{
	                    hm.put(s, 1);
	                }       
	                 if(hm.get(s)>freequecy ){
	                     result = s;
	                     freequecy = hm.get(s);
	                 }else if(hm.get(s)==freequecy){
	                     if(s.compareTo(result) < 0) {
	                         result = s;
	                         freequecy = hm.get(s);
	                     }
	                 }              
	            }
	        }
	        
	        return result;
	 }

}
