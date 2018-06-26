package com.maroy.multithreading;

public class SynchronizationExample{
	private static final Object LOCK = new Object();
	private Object lockReference1 = LOCK;
	private Object lockReference2 = LOCK;

	static SynchronizationExample se = new SynchronizationExample();

	public static void main(String ar[]){
		new Thread(new Runnable() {
			@Override
			public void run() {
				se.hello1();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				se.hello2();
			}
		}).start();

	}

	public void hello1() {
		synchronized(lockReference1) {	
			System.out.println(Thread.currentThread().getName() + " in synchronized block");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " leaving synchronized block");

		}
	}

	public void hello2() {
		synchronized(lockReference2) {
			System.out.println(Thread.currentThread().getName() + " in synchronized block");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " leaving synchronized block");
		}
	}

}
