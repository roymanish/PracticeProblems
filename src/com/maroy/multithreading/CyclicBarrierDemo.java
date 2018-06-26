package com.maroy.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(5,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Barrier is broken.");
				
			}
		});
		
		DummyWorkerThread dt = new DummyWorkerThread(barrier);
		
		Thread t1 = new Thread(dt, "First Thread");
		Thread t2 = new Thread(dt, "Second Thread");
		Thread t3 = new Thread(dt, "Third Thread");
		Thread t4 = new Thread(dt, "Fourth Thread");
		Thread t5 = new Thread(dt, "Fifth Thread");
		
		t1.start();
		sleep(1000);
		t2.start();
		sleep(1000);
		t3.start();
		sleep(1000);
		t4.start();
		sleep(1000);
		t5.start();
		
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
class DummyWorkerThread implements Runnable{

	private CyclicBarrier barrier;
	
	public DummyWorkerThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	@Override
	public void run() {

			System.out.println(Thread.currentThread().getName()+" reached barrier.");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}