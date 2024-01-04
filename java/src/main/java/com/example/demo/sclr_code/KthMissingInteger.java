package com.example.demo.sclr_code;

import java.util.ArrayList;

public class KthMissingInteger {

	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(8);
		list.add(11);
		list.add(16);
		list.add(17);
		
		System.out.println(solve(list, 6));
	}
	
	public static int solve(ArrayList<Integer> A, int B) {		//getting TLE , use hashSet to store elements of A
        int max = A.get( A.size()-1) ; 
        //edge case 
        if(max == A.size()){
            return max+B;
        }
        
        int missing = -1; 
        int total = 0; 
        for(int i=1; i<max; i++){
            if(!A.contains(i)){
                total = total+1;
                missing = i;
            }
            if(total == B){
                return missing; 
            }
        }
        return max+B-total;
    }

	
	public static int usingHashSet(ArrayList<Integer> A, int B) {
		//do this 
		return 0;
	}
}
