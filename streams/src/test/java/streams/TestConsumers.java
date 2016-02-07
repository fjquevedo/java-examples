package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Generic java Stream test.
 *
 * @since 1.0
 * @version 1.0
 */
public class TestConsumers extends BaseStreamsTest {

	@SuppressWarnings("unused")
    @Test
	public void testRiseSalary() {
		Consumer<Person> giveRaise = p -> p.setSalary(p.getSalary() / 100 * 5 + p.getSalary());
		javaProgrammers.forEach(System.out::println);
		javaProgrammers.forEach(giveRaise.andThen(System.out::println));

		String[] strt = javaProgrammers.stream().map(j -> j.getFirstName()).toArray(String[]::new);
		
		List<String> emptyList = new ArrayList<>();
		String[] emptyArray = emptyList.stream().toArray(String[]::new);
		
		Stream<String> map = javaProgrammers.stream().map(j -> j.getFirstName());
		
	}
}
