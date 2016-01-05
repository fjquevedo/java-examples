package character;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;


public class TestCharacter {
	private URI uri;

	@Before
	public void setUp() throws URISyntaxException {
		uri = TestCharacter.class.getClassLoader().getResource("input/texto.txt").toURI();
	}

	@Test
	public void testReadFileLine() {

		try {
			CharacterIO.readFileLine(Paths.get(uri));
		} catch (IOException ex) {
			fail(ex.getMessage());
		}
	}
}
