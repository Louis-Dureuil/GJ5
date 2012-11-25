package schroedinger.script.task;

import schroedinger.Dialog;
import schroedinger.Task;
import schroedinger.TaskState;

public class OpeningNewton extends Task {

	boolean finished = false;
	public OpeningNewton() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1024;
	}

	@Override
	public TaskState getState() {
		// TODO Auto-generated method stub
		if (finished) {
			return TaskState.completed;
		} else {
			return TaskState.running;
		}
	}

	@Override
	public void onTalk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		finished = true;
		Dialog d = new schroedinger.script.dialog.OpeningNewton();
		d.display();
	}

	
}
