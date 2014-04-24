package GKScripts.GKFlax.tasks.spin;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

import GKScripts.GKFlax.framework.Task;

public class Widget extends Task {

	Component c = ctx.widgets.component(1370, 38);
	
	public Widget(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		return c.valid();
	}

	public void run() {
		c.click();
	}

}
