package GKScripts.GKFlax.tasks.spin;

import org.powerbot.script.rt6.*;

import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.framework.Methods.*;
import GKScripts.GKFlax.framework.Methods.Objects;
import GKScripts.GKFlax.framework.Data.*;

public class Interact extends Task {

	public Interact(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		Component c = ctx.widgets.component(1370, 38);
		Component c1 = ctx.widgets.component(1251, 8);
		return Inventory.contains(Ids.FLAX) && !c.valid() && !c1.valid() && Location.current() == Location.MID_FLOOR;
	}

	public void run() {
		Objects.interact(Ids.WHEEL, "Spin", Tiles.WHEEL);
	}
	
}