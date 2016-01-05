package character;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class CharacterIO {
	private CharacterIO() {
	}

	public static void readFileLine(Path path) throws IOException {
		try (FileReader d = new FileReader(path.toFile())) {
			int c;
			while ((c = d.read()) != -1) {
				System.out.print(Character.toChars(c));
			}
		}
	}
}
