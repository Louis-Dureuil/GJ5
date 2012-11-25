package schroedinger.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLMessageHandler extends DefaultHandler {

	public XMLMessageHandler(int id) {
		super();
		this.id = id;
	}
	
	private int id;
	private String message = "";
	private boolean isMessage;

	public String getMessage() { return message; }
	
	public void startElement(String uri, String localName,String qName, 
			Attributes attributes) throws SAXException { 
		System.out.println("startelement");
		if (qName.equalsIgnoreCase("MESSAGE") && 
				Integer.parseInt(attributes.getValue("id")) == id) {
			isMessage = true;
			System.out.println("Message found");
		}

	}

	public void endElement(String uri, String localName,
			String qName) throws SAXException {
		isMessage = false;
		System.out.println("endElement");
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		System.out.println("characters");
		if (isMessage) {
			message += new String(ch, start, length).trim();
			//System.out.println("Message: " + message.trim());
		} 
	}


}
