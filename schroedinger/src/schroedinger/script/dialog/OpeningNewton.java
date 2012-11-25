package schroedinger.script.dialog;

import java.util.ArrayList;
import java.util.List;


import schroedinger.Dialog;
import schroedinger.util.DialogIndexes;

public class OpeningNewton extends Dialog {

	public OpeningNewton() {
		this.messages = new ArrayList<DialogIndexes>();
		messages.add(new DialogIndexes(0,
				"\nMes amis, l'heure est grave ! " +
				"Un meurtre a été commis dans notre ville de " +
				"Far, Far A Day ! Cet acte est impardonnable, " +
				"et mérite une punition exemplaire !"));
	}
	
	@Override
	public List<DialogIndexes> answer(int answer) {
		// TODO Auto-generated method stub
		if (this.currentMessage == 0) {
			ArrayList<DialogIndexes> ret = new ArrayList<DialogIndexes>();
			ret.add(messages.get(0));
			//ret.addAll(0, messages);
			return ret;
		}
		over = true;
		return null;
	}

}
