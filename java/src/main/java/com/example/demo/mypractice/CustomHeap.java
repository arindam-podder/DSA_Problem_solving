package com.st.code_in_java.problems;

import java.util.ArrayList;
import java.util.List;

public class CustomHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(2);

        System.out.println(minHeap.getMin());

        minHeap.display();

        minHeap.insert(1);

        minHeap.display();

        System.out.println(minHeap.getMin());
        minHeap.display();

    }
}



class MinHeap{

    private List<Integer> dataList = new ArrayList<>();

    public void insert(int n){
        dataList.add(n);
        //index where n is added
        int index = dataList.size()-1;
        //do heapify bottom to up
        while (index>0){
            int parent = (index-1) / 2;

            if(dataList.get(parent) > dataList.get(index)){
                swap(dataList, parent, index);
                index = parent;
            }else{
               break;
            }
        }
    }

    public int getMin(){
        int min = dataList.get(0);
        //swap last with 0
        swap(dataList, 0, dataList.size()-1);
        //remove the min , present in last
        dataList.remove(dataList.size()-1);

        //perform top to bottom heapify
        int i=0;
        while(i<dataList.size()){
            int leftChildIdx = 2*i +1;
            int rightChildIdx = 2*i +2;

            int leftChildValue = leftChildIdx < dataList.size()? dataList.get(leftChildIdx) : Integer.MAX_VALUE;
            int rightChildValue = rightChildIdx < dataList.size()? dataList.get(rightChildIdx) : Integer.MAX_VALUE;

            if(leftChildValue <= rightChildValue && leftChildValue < dataList.get(i)){
                swap(dataList, leftChildIdx, i);
                i = leftChildIdx;
            }
            else if(rightChildValue < leftChildValue && rightChildValue < dataList.get(i)){
                swap(dataList, rightChildIdx, i);
                i = rightChildIdx;
            }else {
                break;
            }
        }

        return min;
    }

    private static void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void display(){
        System.out.println(dataList);
    }

}
