package GKScripts.GKMonks.task;

import org.powerbot.script.Filter;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.*;

public class Antiban extends Task {

	public Antiban(ClientContext ctx) {
		super(ctx);
	}

	public boolean activate() {
		Actor a = ctx.players.local().interacting();
		return ctx.players.local().inCombat() && a != null && a.healthPercent() > 0;
	}

	public void execute() {
		
		if (Random.nextInt(0, 100) > 85) {
			ctx.mouse.move(Random.nextInt(0, 3000), Random.nextInt(0, 3000));
		} else if (Random.nextInt(0, 100) > 0) {
			ctx.camera.angleTo(Random.nextInt(-360, 360));
		}
		else if (Random.nextInt(0, 100) > 90) {
			Player p = ctx.players.select().select(new Filter<Player>(){
				public boolean accept(Player p1) {
					return !p1.equals(ctx.players.local());
				}
			}).nearest().poll();
			
			if(p != null){
				p.click(false);
			}
		}
		try {
			Thread.sleep(50, 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
