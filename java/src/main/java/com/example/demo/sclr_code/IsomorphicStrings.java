/*
 *Q2. Isomorphic Strings

Problem Description
Given two strings A and B, determine if they are isomorphic.

A and B are called isomorphic strings if all occurrences of each character in A can be replaced with another character to get B and vice-versa.

Problem Constraints
1 <= |A| <= 100000
1 <= |B| <= 100000
A and B contain only lowercase characters.

Input Format
The first Argument is string A.

The second Argument is string B.

Output Format
Return 1 if strings are isomorphic, 0 otherwise.


Example Input
Input 1:
A = "aba"
B = "xyx"
Input 2:
A = "cvv"
B = "xyx"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Replace 'a' with 'x', 'b' with 'y'.
Explanation 2:
 A cannot be converted to B. 
 */

package com.example.demo.sclr_code;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int isConvertionPossible(String A, String B){
        if(A.length() != B.length()){
            return 0;
        }
        HashMap<Character, Character> hm = new HashMap();
        HashSet<Character> hs = new HashSet();
        for(int i=0; i<A.length(); i++){
            Character ch = A.charAt(i); 
            if(hm.containsKey(ch)){
                if(hm.get(ch) != B.charAt(i)){
                    return 0;
                }
            }else{
                if(hs.contains(B.charAt(i))){
                    return 0;
                }
                hm.put(ch, B.charAt(i));
                hs.add(B.charAt(i));
            }
        }
        return 1;
    }

}
