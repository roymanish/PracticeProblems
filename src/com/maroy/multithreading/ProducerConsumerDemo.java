package com.maroy.multithreading;

import java.util.LinkedList;

public class ProducerConsumerDemo {

	public static void main(String[] args) {

		LinkedList<String> resource = new LinkedList<>();
		Producer p = new Producer(resource);
		Consumer c = new Consumer(resource);

		Thread t1 = new Thread(p);

		Thread t2 = new Thread(c);

		t1.start();
		t2.start();
	}

}
class Producer implements Runnable{

	private LinkedList<String> resource;

	private int resourceLimit = 5;

	public Producer(LinkedList<String> resource) {
		this.resource = resource;
	}

	@Override
	public void run() {

		while(true){
		synchronized (resource) {

				if(resource.size() == resourceLimit){
					try {
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				resource.add("Item "+resource.size());
				System.out.println("Item "+resource.size()+" produced.");
				resource.notify();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Consumer implements Runnable{

	private LinkedList<String> resource;

	public Consumer(LinkedList<String> resource) {
		this.resource = resource;
	}
	@Override
	public void run() {

		while(true){
		synchronized (resource) {
			
				if(resource.isEmpty()){
					try {
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Item "+resource.size()+" consumed.");
				resource.removeFirst();
				resource.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
