package com.maroy.multithreading;

public class EvenOddThread {

	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadRunnable());
		Thread t2 = new Thread(new ThreadRunnable());
		
		t1.start();
		t2.start();

	}

}
class ThreadRunnable implements Runnable{

	private volatile boolean isEven = false;

	private int evenCounter = 2;

	private int oddCounter = 1;

	@Override
	public void run() {

		for(int i=1;i<=10;i++) {
			if(isEven) {
				isEven = false;
				System.out.println("Event Thread :"+evenCounter);
				evenCounter += 2;
				
			}
			else {
				isEven = true;
				System.out.println("Odd Thread :"+oddCounter);
				oddCounter = oddCounter+2;
			}
		}
	}
}

class ThreadResource{

	private volatile boolean isEven = false;

	private int evenCounter = 2;

	private int oddCounter = 1;

	public void printNum() {

		synchronized (this) {

			for(int i=1;i<=100;i++) {
				if(isEven) {
					System.out.println("Event Thread :"+evenCounter);
					evenCounter += 2;
					isEven = false;
				}
				else {
					System.out.println("Odd Thread :"+oddCounter);
					oddCounter = oddCounter+2;
					isEven = true;
				}
			}
		}
	}
}