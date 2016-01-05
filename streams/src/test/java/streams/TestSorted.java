package streams;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

import org.junit.Test;

/**
 * Generic java Stream test.
 *
 * @since 1.0
 * @version 1.0
 */
public class TestSorted extends BaseStreamsTest {

	@Test
	public void testSortProgrammers() {

		Comparator<Person> comparePerson = (p1, p2) -> (p1.getFirstName().compareTo(p2.getFirstName()));
		Collector<Person, ?, List<Person>> newPersonList = toList();
		List<Person> sortedJavaProgrammers = javaProgrammers.stream().sorted(comparePerson).limit(5)
				.collect(newPersonList);

		sortedJavaProgrammers.forEach(System.out::println);
	}

	@Test
	public void testSortArray() {
		String[] atp = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro" };

		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		Arrays.sort(atp, sortByName);

		Arrays.sort(atp, (s1, s2) -> (s1.compareTo(s2)));
		Arrays.sort(atp, (s1, s2) -> s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
		Arrays.sort(atp, (s1, s2) -> s1.length() - s2.length());
		Arrays.sort(atp, (s1, s2) -> s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));

		List<String> asList = Arrays.asList(atp);
		asList.forEach(System.out::println);

	}

}
