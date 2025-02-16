/**
 * 
 */


package com.example.demo.multithread;

import java.util.concurrent.Semaphore;

public class OddEvenUsingSemaphore {
	
	private int number = 1; 
	private final int MAX = 100;
	
	// Semaphores to control execution
    private final Semaphore oddSemaphore = new Semaphore(1); 
    private final Semaphore evenSemaphore = new Semaphore(0);
    
    public void printOdd() {
        while (number <= MAX) {
            try {
                oddSemaphore.acquire(); // Acquire lock for odd
                if (number <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " - Odd: " + number);
                    number++;
                }
                evenSemaphore.release(); // Release even thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void printEven() {
    	while(number <= MAX) {
    		try {
    			evenSemaphore.acquire();
    			if(number <= MAX) {
    				System.out.println(Thread.currentThread().getName() + " - Even: "+ number);
    				number++;
    			}
    			oddSemaphore.release();
    		}catch (InterruptedException e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    	}
    }
    

	public static void main(String[] args) {
		OddEvenUsingSemaphore obj = new OddEvenUsingSemaphore();
		
		Thread oddPrinter = new Thread(obj::printOdd, "Thread-odd");
		Thread evenPrinter = new Thread(obj::printEven, "Thread-even");
		oddPrinter.start();
		evenPrinter.start();
		
	}
	
	
}
