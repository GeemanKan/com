package GKScripts.GKFlax.tasks.stairs;

import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.framework.Methods.*;
import GKScripts.GKFlax.framework.*;
import GKScripts.GKFlax.framework.Data.*;

public class Up extends Task {

	public Up(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		if(Location.current() == Location.LOW_FLOOR){
			return true;
		}
		return Location.current() == Location.MID_FLOOR && !Inventory.contains(Ids.FLAX);
	}

	public void run() {
		Objects.interact(Ids.STAIRS_UP, "Climb-up", Tiles.STAIRS);
	}

}
