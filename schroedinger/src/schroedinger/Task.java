package schroedinger;

public abstract class Task {

	private boolean isPaused;
	
	
	
	abstract public int getPriority();
	abstract public TaskState getState();
	
	public boolean isPaused() { return isPaused; }
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
	public abstract void onTalk();
	public abstract void update();
	
}
