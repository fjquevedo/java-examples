package streams;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


class UnderTestClass {

	public String doSth() {
		return "done";
	}
}

public class UnderTestClassTest {

	//http://www.schibsted.pl/2015/04/rules-that-can-help-you-write-better-unit-tests/
	private UnderTestClass subject;

	@Before
	public void setup() {
		System.out.println("Setup...");
		subject = new UnderTestClass();
	}

	@After
	public void clean() {
		System.out.println("Cleaning after test...");
	}

	@Rule
	public TestRule rule = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("Failed " + description);
		}

		@Override
		protected void finished(Description description) {
			System.out.println("Finished " + description + "\n");
		}

		@Override
		protected void starting(Description description) {
			System.out.println("Starting " + description);
		}

		@Override
		protected void succeeded(Description description) {
			System.out.println("Passed " + description);
		}
	};

	@Test
	public void testDoSth() {
		System.out.println("In test...");
		assertEquals("done", subject.doSth());
	}

	@Test
	public void testNothingAndFail() {
		System.out.println("In test...");
		assertEquals("done", "no");
	}

}
