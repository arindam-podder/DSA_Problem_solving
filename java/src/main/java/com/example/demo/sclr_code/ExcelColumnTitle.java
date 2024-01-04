package com.example.demo.sclr_code;

import java.util.Arrays;

public class ExcelColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(title(26));

	}
	
	public static String title(int A){
        char[] character = alphabet();
        String title = "";
        while(A>0){
            int temp = (A-1) % 26; 
            title =  character[temp] + title;
            A = (A-1)/26;
        }
        return title;
    }
	
	public static char[] alphabet(){
        char[] arr = new char[26];
        for(int i='A'; i<='Z'; i++){
            arr[i-'A'] = (char)i;
        }
        return arr;
    }

}
