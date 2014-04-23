package GKScripts.GKFlax.tasks;

import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.framework.Methods.Inventory;
import GKScripts.GKFlax.framework.Methods.Location;
import GKScripts.GKFlax.framework.Methods.Objects;
import GKScripts.GKFlax.framework.Data.Ids;
import GKScripts.GKFlax.framework.Data.Tiles;

public class Bank extends Task {

	public Bank(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		if(ctx.bank.opened()){
			return true;
		}
		return Location.current() == Location.TOP_FLOOR && !Inventory.contains(Ids.FLAX);
	}

	public void run() {
		if(!ctx.bank.opened()){
			Objects.interact(Ids.BOOTH, "Bank", Tiles.BANK);
		} else if(Inventory.contains(Ids.FLAX)){
			ctx.bank.close();
		} else if(ctx.backpack.select().isEmpty()){
			ctx.bank.withdraw(Ids.FLAX, 0);
		} else {
			ctx.bank.depositInventory();
		}
		
	}

}
