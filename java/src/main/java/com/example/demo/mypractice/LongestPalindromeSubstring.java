package com.example.demo.mypractice;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		
	//System.out.println( longestPalindromeSubstring("xyzabcba"));
		System.out.println( longestPalindrome("xyzabcba"));

	}
	
	
//	public static String longestPalindromeSubstring(String s) {
//		int len = s.length();
//		String result = "";
//		for(int i=0; i<len; i++) {
//			for(int j=i; j<len; j++) {
//				if( isPlindrome( s.substring(i,j+1)) ) {
//					result = result.length() >= s.substring(i,j+1).length() ? result : s.substring(i,j+1);
//				}
//			}
//		}
//		
//		return result;
//	}
//	
//	public static boolean isPlindrome(String s) {
//		String rev = "";
//		for(int i=0; i<s.length(); i++) {
//			rev = s.charAt(i) + rev;
//		}
//		return  rev.equals(s);
//		
//	}
	
	public static String longestPalindrome(String A) {
        char[] arr = A.toCharArray();
        String result = "";
        int p1=-1; int p2 = -1;
        String temp = "";
        for(int i=0; i<arr.length; i++){
            //for odd length palindrome
            p1 = i; p2 = i;
            temp = expand(arr, p1, p2);
            result = result.length() > temp.length()  ? result : temp;

            //for even length palindrome
            p1 = i; p2 = i+1;
            temp = expand(arr, p1, p2);
            result = result.length() > temp.length()  ? result : temp;
        }
        return result;
    }

    public static String expand(char[] arr, int p1, int p2){
        // checking index out of bound and letters matching or not 
        while(p1 >= 0 && p2<arr.length &&  (arr[p1] == arr[p2]) ){
            p1--;
            p2++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=p1+1; i<p2; i++){
            sb.append(arr[i]);
        }   
        return sb.toString();
    }
	

}




















