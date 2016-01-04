package streams;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Generic java Stream test.
 *
 * @since 1.0
 * @version 1.0
 */
public class TestStreams {

	private static List<Person> javaProgrammers;
	private static List<Person> phpProgrammers;

	/**
	 * Set up.
	 */
	@SuppressWarnings("serial")
	@Before
	public void setUp() {
		javaProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
				add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
				add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
				add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
				add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
				add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
				add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
				add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
				add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			}
		};

		phpProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
				add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
				add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
				add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
				add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
				add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
				add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
				add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
				add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
				add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
			}
		};
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
	}

	@Test
	public void testFiters() {
		// http://www.developer.com/java/start-using-java-lambda-expressions.html

		Consumer<Person> printPerson = (p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName());
		javaProgrammers.forEach(printPerson);

		Consumer<Person> giveRaise = p -> p.setSalary(p.getSalary() / 100 * 5 + p.getSalary());
		javaProgrammers.forEach(giveRaise);

		phpProgrammers.stream().filter((p) -> (p.getSalary() > 1400)).forEach(giveRaise);

		Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
		Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
		Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

		phpProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter)
		.forEach(printPerson);

		Comparator<Person> comparePerson = (p1, p2) -> (p1.getFirstName().compareTo(p2.getFirstName()));
		Collector<Person, ?, List<Person>> newPersonList = toList();
		List<Person> sortedJavaProgrammers = javaProgrammers.stream()
				.sorted(comparePerson).limit(5).collect(newPersonList);
		sortedJavaProgrammers.forEach((p) -> System.out.println(p.getFirstName()));


		String[] atp = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro" };

		// Arrays.sort(atp, new Comparator<String>() {
		// @Override
		// public int compare(String s1, String s2) {
		// return (s1.compareTo(s2));
		// }
		// });

		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		//Arrays.sort(atp, sortByName);
		Arrays.sort(atp, (s1, s2) -> (s1.compareTo(s2)));
		Arrays.sort(atp, (s1, s2) -> s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
		Arrays.sort(atp, (s1, s2) -> s1.length() - s2.length());
		Arrays.sort(atp, (s1, s2) -> s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));

		List<String> asList = Arrays.asList(atp);
		asList.forEach(System.out::println);
	}

}
