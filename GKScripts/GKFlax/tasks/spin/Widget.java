package GKScripts.GKFlax.tasks.spin;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

import GKScripts.GKFlax.framework.Task;

public class Widget extends Task {

	public Widget(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		Component c = ctx.widgets.component(1370, 38);
		return c.valid();
	}

	public void run() {
		Component c = ctx.widgets.component(1370, 38);
		c.click();
	}

}
