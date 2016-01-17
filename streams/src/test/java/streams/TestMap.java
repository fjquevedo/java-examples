package streams;

import java.util.stream.Stream;

import org.junit.Test;

/**
 * Generic java Stream test.
 *
 * @since 1.0
 * @version 1.0
 */
public class TestMap extends BaseStreamsTest {

	@SuppressWarnings("unused")
	@Test
	public void testMapNames() {
		Stream<String> map = javaProgrammers.stream().map(j -> j.getFirstName());
	}

	@Test
	public void testMapNamesToArray() {
		@SuppressWarnings("unused")
		String[] strt = javaProgrammers.stream().map(j -> j.getFirstName()).toArray(String[]::new);
	}

}
