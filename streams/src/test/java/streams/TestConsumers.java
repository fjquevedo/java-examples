package streams;

import java.util.function.Consumer;

import org.junit.Test;

/**
 * Generic java Stream test.
 *
 * @since 1.0
 * @version 1.0
 */
public class TestConsumers extends BaseStreamsTest {

	@Test
	public void testRiseSalary() {
		Consumer<Person> giveRaise = p -> p.setSalary(p.getSalary() / 100 * 5 + p.getSalary());
		javaProgrammers.forEach(System.out::println);
		javaProgrammers.forEach(giveRaise.andThen(System.out::println));
	}

}
