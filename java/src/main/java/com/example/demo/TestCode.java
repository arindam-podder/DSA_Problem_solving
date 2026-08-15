package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Code.subsequenceUseBit(new int[]{1,2,3});
		Code.subsequenceUseRecur(0, new int[]{1,2,3}, new ArrayList<>());
		
	}

}


class Code{
	
	//using bit 
	public static void subsequenceUseBit(int arr[]) {
		int len = arr.length;
		for(int i=0; i<Math.pow(2, len); i++) {		// Math.pow(2, len) = 1<<len
			StringBuilder sb = new StringBuilder();
			for(int idx=0; idx<arr.length; idx++) {
				//check idx bit set or not 
				if( (i & (1<<idx)) != 0 ) sb.append(arr[idx]);
			}
			System.out.println( sb.toString() );
		}
	}
	
	//using recursion 
	public static void subsequenceUseRecur(int i, int[] arr, List<Integer> cur) {
		if(i >= arr.length) {
			System.out.println( cur );
			return;
		}
		//dont pick
		subsequenceUseRecur(i+1, arr, cur);
		//pick 
		cur.add(arr[i]); 
		subsequenceUseRecur(i+1, arr, cur);
		cur.remove(cur.size()-1);
		
	}
	
}







