package GKScripts.GKFlax.tasks.stairs;

import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.data.Ids;
import GKScripts.GKFlax.data.Methods.Objects;
import GKScripts.GKFlax.data.Tiles;
import GKScripts.GKFlax.data.Methods.Location;
import GKScripts.GKFlax.framework.Task;

public class Down extends Task {

	public Down(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		return ctx.backpack.select().id(Ids.FLAX).count() > 0
				&& Location.current() == Location.TOP_FLOOR && !ctx.bank.opened();
	}

	public void run() {
		Objects.interact(Ids.STAIRS_DOWN, "Climb-down", Tiles.STAIRS);
	}

}
