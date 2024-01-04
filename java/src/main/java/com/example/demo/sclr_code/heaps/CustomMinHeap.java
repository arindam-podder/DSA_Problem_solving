package com.example.demo.sclr_code.heaps;

import java.util.ArrayList;


/**
 * MinHeap for int values 
 * @author hp
 *
 */
public class CustomMinHeap {
	
	public ArrayList<Integer> list;

	public CustomMinHeap() {
		list = new ArrayList<>();
	}
	
	public void insertElement(int x) {					//maintaining values in list butr logic is complete BT traversal
		this.list.add(x); 
		int insertedIndex = this.list.size()-1;
		while(insertedIndex > 0) {
			int parentIndex = (insertedIndex-1)/2 ; 
			if(this.list.get(parentIndex) > this.list.get(insertedIndex)) {
				int temp = this.list.get(parentIndex);
				this.list.set(parentIndex, this.list.get(insertedIndex));
				this.list.set(insertedIndex, temp);
				insertedIndex = parentIndex;
			}
			else {
				break;
			}
		}	
	}

	public int getMin() {
		if(this.list.size()==0) {
			return -1;
		}
		return this.list.get(0);
	}
	
	
	public int getMinAndRemove() {
		int minValue = this.list.get(0);
		//swap 0, last element , remove swapped min last element , heapify the list
		//int temp = this.list.get(0);
		this.list.set(0,  this.list.get(this.list.size()-1));
		this.list.remove(this.list.size()-1);
		int rootIndex = 0;
		while(rootIndex < this.list.size()) {
			int leftChildIndex = (rootIndex*2) + 1;
			int rightChildIndex = (rootIndex*2) + 2;
			
			int leftValue = (leftChildIndex < this.list.size() ) ? this.list.get(leftChildIndex) : Integer.MAX_VALUE;
			int rightValue = (rightChildIndex < this.list.size() ) ? this.list.get(rightChildIndex) : Integer.MAX_VALUE;
		
			if(leftValue<=rightValue && leftValue<=this.list.get(rootIndex)) {
				int temp = leftValue;
				this.list.set(leftChildIndex, this.list.get(rootIndex)); 
				this.list.set(rootIndex, temp);
				rootIndex = leftChildIndex;
			}
			else if(rightValue<=leftValue && rightValue<=this.list.get(rootIndex)) {
				int temp = rightValue;
				this.list.set(rightChildIndex, this.list.get(rootIndex)); 
				this.list.set(rootIndex, temp);
				rootIndex = rightChildIndex;
			}
			else {
				break;
			}
		}
		return minValue;
	}
	
	
	//public void swap() {
	//}
	
}










