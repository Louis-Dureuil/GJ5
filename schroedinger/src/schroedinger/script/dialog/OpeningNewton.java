package schroedinger.script.dialog;

import java.util.ArrayList;
import java.util.List;


import schroedinger.Dialog;
import schroedinger.util.DialogIndexes;
import schroedinger.util.XMLReader;

public class OpeningNewton extends Dialog {

	public OpeningNewton() {
		this.messages = new ArrayList<DialogIndexes>();
		String message = XMLReader.parse("data/text/messages/newton.xml", 0);
		messages.add(new DialogIndexes(0, message
				));
		message = XMLReader.parse("data/text/messages/newton.xml", 1);
		messages.add(new DialogIndexes(1, message
				));
		message = XMLReader.parse("data/text/messages/newton.xml", 2);
		messages.add(new DialogIndexes(2, message
				));
		
	}
	
	@Override
	public List<DialogIndexes> answer(int answer) {
		// TODO Auto-generated method stub
		if (this.currentMessage == 0) {
			ArrayList<DialogIndexes> ret = new ArrayList<DialogIndexes>();
			ret.add(messages.get(0));
			this.currentMessage++;
			return ret;
		} else if (this.currentMessage == 1) {
			ArrayList<DialogIndexes> ret = new ArrayList<DialogIndexes>();
			ret.add(messages.get(1));
			this.currentMessage++;
			return ret;
		} 
		over = true;
		return null;
	}

}
