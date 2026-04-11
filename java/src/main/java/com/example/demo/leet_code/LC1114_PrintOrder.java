/**
 * 1114. Print in Order

Suppose we have a class:
public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread
 C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Note:
We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. 
The input format you see is mainly to ensure our tests' comprehensiveness.

 
Example 1:
Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), 
thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.

Example 2:
Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 

Constraints:
nums is a permutation of [1, 2, 3].
 
 */

package com.example.demo.leet_code;

import java.util.concurrent.Semaphore;

public class LC1114_PrintOrder {

	public static void main(String[] args) {
		Foo foo = new Foo();
		
		Runnable first = new PrintFirst(); 
		Runnable second = new PrintSecond();
		Runnable third = new PrintThird();
		
		Thread thread1 = new Thread(() -> {
			try {
				foo.first(first);
			} catch (Exception e) {
				System.err.print("exc");
			}
			
		});
		
		Thread thread2 = new Thread(() -> {
			try {
				foo.second(second);
			} catch (Exception e) {
				System.err.print("exc");
			}
			
		});
		
		
		Thread thread3 = new Thread(() -> {
			try {
				foo.third(third);
			} catch (Exception e) {
				System.err.print("exc");
			}
			
		});
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}

}



class Foo {
	
	Semaphore first; 
	Semaphore second; 
	Semaphore third; 
	

    public Foo() {
        first = new Semaphore(1);  //this will have presmit becoz first has to execute first 
        second = new Semaphore(0); 
        third = new Semaphore(0); 
    }

    public void first(Runnable printFirst) throws InterruptedException {
        first.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        second.release();
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        
    }
}


class PrintFirst implements Runnable{
	@Override
	public void run() {
		System.out.print("first");
	}
}

class PrintSecond implements Runnable{
	@Override
	public void run() {
		System.out.print("second");
	}
}

class PrintThird implements Runnable{
	@Override
	public void run() {
		System.out.print("third");
	}
}

