package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ColorfulNumber{
	public static void main(String[] args) {
		
	}
	
	public static int colorful(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        while(A!=0){
            int rem = A%10; 
            list.add(rem);
            A = A/10;
        }
        Collections.reverse(list);
        HashSet<Integer> hs = new HashSet();
        for(int i=0; i<list.size(); i++){
            int prod = 1; 
            for(int j =i;j<list.size();j++){
               prod = prod*list.get(j);
               //if hashset contains product number is not colorful
               if(hs.contains(prod)){
                   return 0;
               }
               //if set doenot contain product, add in it
               hs.add(prod);
            }
        }
        return 1;
    }
}