package com.maroy.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(5);
		
		DummyThread dt = new DummyThread(latch);
		
		Thread t1 = new Thread(dt, "First Thread");
		Thread t2 = new Thread(dt, "Second Thread");
		Thread t3 = new Thread(dt, "Third Thread");
		Thread t4 = new Thread(dt, "Fourth Thread");
		Thread t5 = new Thread(dt, "Fifth Thread");
		
		t1.start();
		//sleep(1000);
		t2.start();
		//sleep(1000);
		t3.start();
		//sleep(1000);
		t4.start();
		//sleep(1000);
		t5.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count Down Over.");

	}

	private static void sleep(int time){
		
		try{
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class DummyThread implements Runnable{

	private CountDownLatch latch;
	
	public DummyThread(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {

			System.out.println(Thread.currentThread().getName()+" count down.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
	}
	
}