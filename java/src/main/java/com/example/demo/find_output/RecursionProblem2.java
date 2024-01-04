package com.example.demo.find_output;

public class RecursionProblem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Func(0, 0, 1, 3);
		System.out.println(count);
	}
	
	static int count = 0; 
	
	static void Func(int sr, int sc, int dr, int dc) {
		if(sr>dr || sc>dc) {
			return;
		}
		if(sr==dr && sc==dc) {
			count++;
			return;
		}
		Func(sr, sc+1, dr, dc);
		Func(sr+1, sc, dr, dc);
	}

}
