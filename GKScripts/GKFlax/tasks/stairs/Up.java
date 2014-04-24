package GKScripts.GKFlax.tasks.stairs;

import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.data.Ids;
import GKScripts.GKFlax.data.Tiles;
import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.framework.Methods.*;

public class Up extends Task {

	public Up(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		if(Location.current() == Location.LOW_FLOOR){
			return true;
		}
		return Location.current() == Location.MID_FLOOR && ctx.backpack.select().id(Ids.FLAX).count() == 0;
	}

	public void run() {
		Objects.interact(Ids.STAIRS_UP, "Climb-up", Tiles.STAIRS);
	}

}
