package schroedinger.script.pnj;

import schroedinger.PNJ;
import schroedinger.Task;
import schroedinger.TaskState;
import schroedinger.script.task.OpeningNewton;
import schroedinger.script.task.Ronde;

public class Newton extends PNJ {

	public Newton() {
		super("Newton");
		this.tasks.add(new Ronde());
		this.tasks.add(new OpeningNewton());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Task cur = this.getCurrentTask();
		if (cur.getState() == TaskState.running) {
			cur.update();
		} else if (cur.getState() == TaskState.completed) {
			this.tasks.remove();
		}
	}

	@Override
	public void OnTalk() {
		// TODO Auto-generated method stub
		this.getCurrentTask().onTalk();
	}

}
