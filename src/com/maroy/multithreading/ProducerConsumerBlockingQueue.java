package com.maroy.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		Thread t1 = new Thread(new ProducerThread(queue), "Producer Thread");
		
		Thread t2 = new Thread(new ConsumerThread(queue), "Consumer Thread");
		
		t1.start();
		t2.start();
	}

}

class ProducerThread implements Runnable{

	BlockingQueue<String> queue;
	
	public ProducerThread(BlockingQueue<String> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		
		for(int i = 1;i<=100;i++) {
			
			try {
				Thread.sleep(i);
				queue.put("Produce - "+i);
				System.out.println("Produced :"+"Produce - "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class ConsumerThread implements Runnable{

	BlockingQueue<String> queue;
	
	public ConsumerThread(BlockingQueue<String> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		
		try {
			while(true){
				Thread.sleep(10);
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
