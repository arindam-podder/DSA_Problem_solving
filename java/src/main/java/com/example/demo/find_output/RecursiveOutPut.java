package com.example.demo.find_output;

public class RecursiveOutPut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("output : "+ foo(3,5));
		
		//char arr[] = {'a','r','i','n'};
		//System.out.println(arr);
	}

	
	static int bar(int x, int y) {
		if(y==0) return 0;
		return (x + bar(x,y-1));
	}
	
	static int foo(int x, int y) {
		if(y == 0) return 1;
		return bar(x, foo(x,y-1));
	}
	
	
	
	
}
