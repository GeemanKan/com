package GKScripts.GKMonks.task.fight;

import org.powerbot.script.Random;
import org.powerbot.script.rt6.Action;
import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKMonks.task.Task;

public class Abilites extends Task {

	public Abilites(ClientContext ctx) {
		super(ctx);
	}

	public boolean activate() {
		return ctx.players.local().interacting() != null && ctx.players.local().interacting().healthPercent() > 0 && ctx.players.local().inCombat();
	}

	public void execute() {
		Action[] actions = ctx.combatBar.actions();
		for(Action a : actions){
			if(a.ready()){
				if(Random.nextInt(0, 10) > 3){
					a.select();
				}
			}
		}
	}

}
