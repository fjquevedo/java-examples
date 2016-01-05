package generics;

public class GenericMethod {

	// Generic Method: printArray
	public static <E> void printArray(E[] elements) {
		for (E element : elements) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	// Bounded Type Parameters: maximum
	public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
		T max = a;

		if (b.compareTo(max) > 0) {
			max = b;
		}
		if (c.compareTo(max) > 0) {
			max = c;
		}

		return max;
	}


}
