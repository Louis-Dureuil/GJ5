package schroedinger;
import schroedinger.util.DialogIndexes;

import java.util.List;

public abstract class Dialog {
	protected List<DialogIndexes> messages;
	protected int currentMessage;
	protected boolean isQuestion;
	protected boolean over;
	
	public abstract void answer(int answer);
	
	public void display() {
		World.ffad.currentDialog = this;
	}
	
	public boolean isOver() {
		return over;
	}
}
