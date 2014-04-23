package GKScripts.GKFlax.tasks;

import org.powerbot.script.Filter;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

import GKScripts.GKFlax.framework.Task;
import GKScripts.GKFlax.framework.Data.Animations;

public class AntiBan extends Task {

	public AntiBan(ClientContext ctx) {
		super(ctx);
	}

	public boolean ready() {
		return ctx.players.local().animation() == Animations.SPINNING;
	}

	public void run() {
		if(Random.nextInt(0, 100) > 92){
			ctx.mouse.move(Random.nextInt(0, 2000), Random.nextInt(0, 2000));
		}
		if(Random.nextInt(0, 100) > 95){
			Npc o = ctx.npcs.select().select(new Filter<Npc>(){
				@Override
				public boolean accept(Npc n) {
					if(Random.nextInt(0, 1000) > 900){
						return true;
					}
					return false;
				}
			}).poll();
			ctx.camera.turnTo(o);
		}
	}

}
