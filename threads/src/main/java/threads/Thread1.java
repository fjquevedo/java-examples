package threads;

public class Thread1 {

	public static void main(String[] args) {
		// There are two ways to create a new thread of execution.
		// 1. Create a subclass of Thread
		MyThread myThread = new MyThread(143);
		myThread.start();// execuded by new Thread
		myThread.run(); // executed by main

		// 2. Create class that implements Runnable and pass to the Thread
		// constructor
		Thread thread = new Thread(new MyRunnable(25));
		thread.start();
		thread.run();

		// thread.start() start a new thread and calls the run() method.
		// thread.run() doesn't create a new thread. It execute run() method in
		// the same thread that execute the code.
	}

	static class MyThread extends Thread {
		long minPrime;

		MyThread(long minPrime) {
			this.minPrime = minPrime;
		}

		@Override
		public void run() {
			System.out.println("MyThread executed by: " + Thread.currentThread().getName());
		}
	}

	static class MyRunnable implements Runnable {
		long minPrime;

		MyRunnable(long minPrime) {
			this.minPrime = minPrime;
		}

		@Override
		public void run() {
			System.out.println("MyRunnable executed by: " + Thread.currentThread().getName());
		}
	}

}
