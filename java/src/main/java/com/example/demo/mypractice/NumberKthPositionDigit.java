package com.example.demo.mypractice;

public class NumberKthPositionDigit {

	public static void main(String[] args) {
		System.out.println(kthDigit(345l, 0));

	}
	
	public static int kthDigit(Long number, int k) {
		return (int) (number/(long)Math.pow(10, k))%10;
	}

}
