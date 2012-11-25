package schroedinger.script.dialog;

import java.util.ArrayList;

import schroedinger.Dialog;
import schroedinger.util.DialogIndexes;

public class OpeningNewton extends Dialog {

	public OpeningNewton() {
		this.messages = new ArrayList<DialogIndexes>();
		messages.add(new DialogIndexes(0,
				"Mes amis, l'heure est grave ! " +
				"Un meurtre a été commis dans notre ville de " +
				"Far, Far A Day ! Cet acte est impardonnable, " +
				"et mérite une punition exemplaire !\n"));
	}
	
	@Override
	public void answer(int answer) {
		// TODO Auto-generated method stub
		over = true;
	}

}
