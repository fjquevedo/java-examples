package generics;

import org.junit.Test;

public class TestGenerics {

	@Test
	public void testGenerics() {
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		GenericMethod.printArray(intArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		GenericMethod.printArray(doubleArray); // pass a Double array

		System.out.println("\nArray characterArray contains:");
		GenericMethod.printArray(charArray); // pass a Character array

		// ****************************************************
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, GenericMethod.maximum(3, 4, 5));

		System.out.printf("Maxm of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
				GenericMethod.maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s\n\n", "pear", "apple", "orange",
				GenericMethod.maximum("pear", "apple", "orange"));

		// ******************************************************

		Box<Integer> integerBox = new Box<>();
		Box<String> stringBox = new Box<>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));

		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());
	}

}
