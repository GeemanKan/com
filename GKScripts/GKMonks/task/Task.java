package GKScripts.GKMonks.task;

import org.powerbot.script.rt6.*;

public abstract class Task extends ClientAccessor {

	public Task(ClientContext ctx) {
		super(ctx);
	}
	
	public abstract boolean activate();
	
	public abstract void execute();

}
