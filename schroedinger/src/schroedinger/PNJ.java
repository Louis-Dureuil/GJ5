package schroedinger;

import java.util.PriorityQueue;

public abstract class PNJ {
	protected PriorityQueue<Task> tasks = new PriorityQueue<Task>();
	private int x;
	private int y;
	private String name;
	static private int pnjID;
	static int maxID = 0;
	
	public Task getCurrentTask() { return tasks.peek(); }

	public static int getID() { return pnjID; }
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	public String getName() { return name; }
	
	public abstract boolean isAlive();
	
	public abstract void update();
	
	public PNJ(String name) {
		this.name = name;
		pnjID = maxID++;
	}
	
	public abstract void OnTalk();
}
