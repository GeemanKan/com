package GKScripts.GKMonks.task;

import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKMonks.framework.Methods;

public class States extends Task {

	public static byte current = 0;
	public static final byte FIGHTING = 0;
	public static final byte HEALING = 1;

	public States(ClientContext ctx) {
		super(ctx);
	}

	public boolean activate() {
		return true;
	}

	public void execute() {

		if (current == HEALING) {
			if (Methods.Health.getLifePointsPercent() >= 100 - (Random.nextInt(
					0, 20))) {
				current = FIGHTING;
			}
		} else if (Methods.Health.needsToHeal()) {
			current = HEALING;
		}

	}

}