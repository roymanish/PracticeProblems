package com.maroy.multithreading;

import java.util.concurrent.Semaphore;

public class SemaforeExample {

	public static void main(String[] args) throws InterruptedException{
		
		Semaphore lock = new Semaphore(3);
		
		Thread t1 = new Thread(new SemaphoreRunnable(lock));
		
		Thread t2 = new Thread(new SemaphoreRunnable(lock));
		
		Thread t3 = new Thread(new SemaphoreRunnable(lock));
		
		Thread t4 = new Thread(new SemaphoreRunnable(lock));
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		t4.start();
		t4.join();
		
		System.out.println("In Main Thread : "+Thread.currentThread());
	}

}

class SemaphoreRunnable implements Runnable{

	private Semaphore lock;
	
	public SemaphoreRunnable(Semaphore lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {

		try {
			lock.acquire();
			Thread.sleep(1000);
			System.out.println("Running Thread : "+Thread.currentThread());
			lock.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}