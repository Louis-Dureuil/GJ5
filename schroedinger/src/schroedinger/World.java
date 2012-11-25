package schroedinger;

import schroedinger.script.pnj.Newton;

public class World {
	// Variables booleenes publiques degeulasses
	public boolean actionStopped;
	public Dialog currentDialog;
	public int currentDialogFaceID;
	public int lastAnswer;
	// Variables booleenes publiques degeulasses FIN
	
	// PNJ
	public Newton newton = new Newton();
	// PNJ FIN
	
	private int clock;
	public int getClock() { return clock; }
	public void incClock(int delta) { clock+=delta; }
	
	public void update() {
		if (!actionStopped) {
			clock++;
		}
		// Autre modifs
		
	}
	
	
	public static World ffad = new World();
}
