package schroedinger;

public class World {
	// Variables booleenes publiques degeulasses
	public boolean actionStopped;
	public Dialog currentDialog;
	public int currentDialogFaceID;
	public int lastAnswer;
	
	// Variables booleenes publiques degeulasses FIN
	private int clock;
	public int getClock() { return clock; }
	
	public void update() {
		if (!actionStopped) {
			clock++;
		}
		// Autre modifs
		
	}
	
	public static World ffad = new World();
}
