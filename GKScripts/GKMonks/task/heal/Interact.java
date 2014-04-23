package GKScripts.GKMonks.task.heal;

import java.awt.Dimension;

import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.*;

import GKScripts.GKMonks.task.States;
import GKScripts.GKMonks.task.Task;

public class Interact extends Task {

	Tile tile = new Tile(3058, 3484, 0);

	public Interact(ClientContext ctx) {
		super(ctx);
	}

	public boolean activate() {

		Dimension c = new Dimension(1191, 11);
		Dimension c1 = new Dimension(1184, 11);
		Dimension c2 = new Dimension(1186, 3);
		Dimension h = new Dimension(1188, 12);

		Dimension[] array = { c, c1, c2, h };
		for (Dimension d : array) {
			int x = d.width;
			int y = d.height;
			if (ctx.widgets.component(x, y).valid()) {
				return false;
			}
		}

		if (ctx.players.local().interacting() != null) {
			return ctx.players.local().interacting().healthPercent() < 1
					&& States.current == States.HEALING;
		}
		return States.current == States.HEALING;
	}

	public void execute() {

		Npc n = ctx.npcs.select().id(801).nearest().first().poll();

		if (n != null) {
			if (n.inViewport()) {
				n.interact("Attack");
			} else {
				if (Random.nextInt(1, 10) > 0) {
					ctx.camera.angle(n.orientation());
				}
				ctx.movement.findPath(n.tile()).traverse();
			}
		}

	}

}
