package GKScripts.GKFlax.tasks.stairs;

import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.framework.Methods.Inventory;
import GKScripts.GKFlax.framework.Methods.Location;
import GKScripts.GKFlax.framework.Methods.Objects;
import GKScripts.GKFlax.framework.Data.Ids;
import GKScripts.GKFlax.framework.Data.Tiles;

public class Down extends Task {

	public Down(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		return Inventory.contains(Ids.FLAX)
				&& Location.current() == Location.TOP_FLOOR && !ctx.bank.opened();
	}

	public void run() {
		Objects.interact(Ids.STAIRS_DOWN, "Climb-down", Tiles.STAIRS);
	}

}
