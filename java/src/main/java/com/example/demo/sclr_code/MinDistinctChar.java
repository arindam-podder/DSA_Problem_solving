/*
You are given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.

Problem Constraints
1 <= N <= 100000
0 <= B <= N

Input Format
The first argument is a string A.
The second argument is an integer B.

Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3

Example Output
2

Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 
*/

package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinDistinctChar {

	public static void main(String[] args) {
		
		System.out.println(solve("umeaylnlfd", 1));
		
	}
	
	public static int solve(String A, int B) {
        HashMap<Character,Integer> hm = new HashMap();
        for(int i=0; i<A.length(); i++){
            if(hm.containsKey(A.charAt(i))){
                hm.put(A.charAt(i), hm.get(A.charAt(i))+1);
            }else{
                hm.put(A.charAt(i), 1);
            }
        }

        if(hm.keySet().size() == 1){
            return 1;
        }
        if(B == 0 ){
           return hm.keySet().size();
        }

        int ans = hm.keySet().size(); 
        ArrayList<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list);
        for(Integer val : list){
            if(val<=B && ans>1){
                B = B-val;
                ans -= 1;
            }else{
                return ans;
            }
        }

        return ans;   
    }

}






















