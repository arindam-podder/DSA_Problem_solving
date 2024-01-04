package com.example.demo.mypractice;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStrig {

	public static void main(String[] args) {
		
		
		randomStringGeneration("p");

	}
	
	public static void randomStringGeneration(String s) {
		int len = s.length();
		int count = 0; 
		while(true) {
			String random = RandomStringUtils.random(len, true, true);
			if(random.equals(s)) {
				break;
			}
			count++; 
			System.out.println(random);
		}
		System.out.println(count);
	}

}
