package com.example.demo.sclr_code.heaps;

public class MyPractice {

	public static void main(String[] args) {
		CustomMinHeap heap = new CustomMinHeap();
		
		heap.insertElement(54);
		heap.insertElement(10);
		heap.insertElement(88);
		heap.insertElement(40);
		System.out.println( heap.getMinAndRemove() );
		heap.insertElement(8);
		heap.insertElement(55);
		heap.insertElement(100);
		System.out.println( heap.getMinAndRemove() );
		System.out.println( heap.getMinAndRemove() );
		
		

	}

}
