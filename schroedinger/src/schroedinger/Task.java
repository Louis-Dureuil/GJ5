package schroedinger;

public abstract class Task implements Comparable<Task> {

	private boolean isPaused;	
	
	abstract public int getPriority();
	abstract public TaskState getState();
	
	public boolean isPaused() { return isPaused; }
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
	public abstract void onTalk();
	public abstract void update();
	
	@Override
	public int compareTo(Task o) {
		// TODO Auto-generated method stub
		return o.getPriority() - this.getPriority();
	}
	
}
