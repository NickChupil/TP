package TeamP.TP;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

public class App {
	public static void main(String[] args) {

		try {

			JsonFactory jfactory = new JsonFactory();
			JsonParser jParser = jfactory.createJsonParser(new File("" + "src/main/java/TeamP/TP/students.json"));

			while (jParser.nextToken() != JsonToken.END_ARRAY) {

				String fieldname = jParser.getCurrentName();
				if ("surname".equals(fieldname)) {

					jParser.nextToken();
					System.out.println(jParser.getText());
				}

				if ("age".equals(fieldname)) {

					jParser.nextToken();
					System.out.println(jParser.getIntValue());
				}

				if ("course".equals(fieldname)) {

					jParser.nextToken();
					System.out.println(jParser.getText());
					System.out.println("\n");
				}

			}
			jParser.close();

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}