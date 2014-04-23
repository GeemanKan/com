package GKScripts.GKMonks.task.fight;

import org.powerbot.script.Filter;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Npc;

import GKScripts.GKMonks.task.States;
import GKScripts.GKMonks.task.Task;

public class Attack extends Task {

	public Attack(ClientContext ctx) {
		super(ctx);
	}

	public boolean activate() {
		if (States.current == States.FIGHTING) {
			Component c = ctx.widgets.component(1490, 28);
			if (c.visible()) {
				return Integer.parseInt(c.text()) == 0;
			} else {
				return true;
			}
		}
		return false;
	}

	public void execute() {

		Npc n = ctx.npcs.select().select(new Filter<Npc>() {
			public boolean accept(Npc npc) {
				return npc.name().equals("Monk") && npc.animation() == -1 ;
			}
		}).nearest().poll();


		if (n != null) {
			if (n.inViewport()) {
				n.interact("Attack");
			} else {
				if (Random.nextInt(1, 10) > 0) {
					ctx.camera.angle(n.orientation());
				}

				Tile t = n.tile();
				if (t.x() < 3044) {
					t = new Tile(3044 + (3043 - t.x()), t.y());
				}

				ctx.movement.findPath(t).traverse();
			}
		}
	}

}
