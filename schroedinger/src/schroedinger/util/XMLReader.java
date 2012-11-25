package schroedinger.util;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLReader {

	public static String parse(String filename, int id) {

		String message = null;
		
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			XMLMessageHandler handler = new XMLMessageHandler(id);
			
			saxParser.parse(filename, handler);
			
			message =  handler.getMessage();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

}