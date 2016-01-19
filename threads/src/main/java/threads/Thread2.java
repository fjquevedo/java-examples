package threads;

import java.util.concurrent.TimeUnit;

public class Thread2 {
	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test1() {
		// Runnable is functionalInteface -> we can use in labmda expressions.
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		task.run();// executed by main

		Thread thread = new Thread(task);
		thread.start();// executed by a new Thread.
		// thread.run(); //executed by current thread (main).
	}

	private static void test2() {
		Runnable runnable = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
				TimeUnit.SECONDS.sleep(1);
				Thread.sleep(1000);
				System.out.println("Bar " + name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
