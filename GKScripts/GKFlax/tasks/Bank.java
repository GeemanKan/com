package GKScripts.GKFlax.tasks;

import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKFlax.data.Ids;
import GKScripts.GKFlax.data.Methods.Objects;
import GKScripts.GKFlax.data.Tiles;
import GKScripts.GKFlax.data.Methods.Location;
import GKScripts.GKFlax.framework.Task;

public class Bank extends Task {

	public Bank(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		if(ctx.bank.opened()){
			return true;
		}
		return Location.current() == Location.TOP_FLOOR && ctx.backpack.select().id(Ids.FLAX).count() == 0;
	}

	public void run() {
		if(!ctx.bank.opened()){
			Objects.interact(Ids.BOOTH, "Bank", Tiles.BANK);
		} else if(ctx.backpack.select().id(Ids.FLAX).count() > 0){
			ctx.bank.close();
		} else if(ctx.backpack.select().isEmpty()){
			ctx.bank.withdraw(Ids.FLAX, 0);
		} else {
			ctx.bank.depositInventory();
		}
		
	}

}
