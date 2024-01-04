package com.example.demo.multithread;

import java.io.IOException;

public class TimerSleep {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//working in main thread 
		
		for(int i=1; i<=60; i++) {
			if(i<10) {
				System.out.println("00:0"+i);
			}
			else {
				if(i==60) {
					System.out.println("01:00");
				}else {
					System.out.println("00:"+i);
				}
			}
			Thread.sleep(1000);
		}

	}

}
