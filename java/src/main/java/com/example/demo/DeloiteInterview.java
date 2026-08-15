package com.example.demo;

import java.util.Arrays;

public class DeloiteInterview {
	public static void main(String[] args) {
		String s = null;

		// System.out.println( isPalin( s) );

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		System.out.println(Arrays.toString(rotateK(arr, 12)));

	}

	public static boolean isPalin(String s) {
		int p1 = 0;
		int p2 = s.length() - 1;

		while (p1 < p2) {
			if (s.charAt(p1) != s.charAt(p2)) {
				return false;
			}
			p1++;
			p2--;
		}
		return true;
	}

	/**
	 * input [1, 2, 3, 4, 5, 6, 7] k=3
	 * 
	 * 2 3 4 5 6 7 1 12 % 7 5 3 4 5 6 7 1 2 4 5 6 7 1 2 3
	 * 
	 * 1st - 7 6 5 4 3 2 1 2nd - 4 5 6 7 1 2 3
	 * 
	 */
	public static int[] rotateK(int[] arr, int k) {
		if (k >= arr.length)
			k = k % arr.length;
		if (k == 0)
			return arr;

		int p1 = 0;
		int p2 = arr.length - 1;
		while (p1 < p2) {
			int tmp = arr[p1];
			arr[p1] = arr[p2];
			arr[p2] = tmp;
			p1++;
			p2--;
		}

		p1 = 0;
		p2 = arr.length - k - 1;
		while (p1 < p2) {
			int tmp = arr[p1];
			arr[p1] = arr[p2];
			arr[p2] = tmp;
			p1++;
			p2--;
		}

		p1 = arr.length - k;
		p2 = arr.length - 1;
		while (p1 < p2) {
			int tmp = arr[p1];
			arr[p1] = arr[p2];
			arr[p2] = tmp;
			p1++;
			p2--;
		}

		return arr;
	}

}
