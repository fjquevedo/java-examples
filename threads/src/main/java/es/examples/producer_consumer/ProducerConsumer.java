package es.examples.producer_consumer;

public class ProducerConsumer {

	public static void main(String[] args) {
		CubbyHole c = new CubbyHole();

		// Create a thread object that calls pc.produce()
		Thread p1 = new Thread(new Producer(c, 1));
		Thread c1 = new Thread(new Consumer(c, 1));
		p1.start();
		c1.start();

	}

}
