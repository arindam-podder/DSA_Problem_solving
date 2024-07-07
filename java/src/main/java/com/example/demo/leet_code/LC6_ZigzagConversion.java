/*
 * 6. Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC6_ZigzagConversion {
	public static void main(String[] args) {
		
		System.out.println( convert("PAYPALISHIRING", 3) );
		
	}
	
	public static String convert(String s, int numRows) {
		
		if(numRows == 1) return s; 
         
        List<List<Character>> charMatrix = new ArrayList<>(); 
        for(int i=0; i<numRows; i++){
            charMatrix.add(new ArrayList<>());
        }

        int rowTrvel = 0;
        Direction direction = Direction.FORWARD;
        for(int i=0; i<s.length(); i++) {
        	charMatrix.get(rowTrvel).add(s.charAt(i));
        	
        	if(direction == Direction.FORWARD ) {
        		rowTrvel += 1;
        	}else {
        		rowTrvel -= 1;
        	}
        	
        	if(rowTrvel == numRows) {
        		direction = Direction.BACKWARD;
        		rowTrvel = numRows-2;
        	}
        	
        	if(rowTrvel == -1) {
        		direction = Direction.FORWARD; 
        		rowTrvel = 1;
        	}
 
        }
        	
        //converts matrix into string and return that 
        String result  = "";
        for(int i=0; i<numRows; i++) {
        	List<Character> list = charMatrix.get(i);
        	for(Character ch : list) {
        		result = result + ch; 
        	}
        }

        return result;
    }
	
	
	enum Direction{
		FORWARD,
		BACKWARD
	}
	
	
	
}//class LC6_ZigzagConversion end