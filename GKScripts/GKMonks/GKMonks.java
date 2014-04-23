package GKScripts.GKMonks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.*;
import org.powerbot.script.Script.*;
import org.powerbot.script.rt4.Skills;
import org.powerbot.script.rt6.ClientContext;

import GKScripts.GKMonks.framework.Methods;
import GKScripts.GKMonks.framework.Skill;
import GKScripts.GKMonks.task.*;
import GKScripts.GKMonks.task.fight.*;
import GKScripts.GKMonks.task.heal.*;

@Manifest(name = "GKScripts.GKMonks", description = "Kills monks at the monestary in west Edgeville. Automatically replenishes health to save money while earning great combat exp")
public class GKMonks extends PollingScript<ClientContext> implements
		PaintListener {

	private List<Task> tasks = new ArrayList<Task>();

	private BufferedImage paintImage = null;

	public void start() {

		tasks.add(new States(ctx));
		tasks.add(new Interact(ctx));
		tasks.add(new Widget(ctx));
		tasks.add(new Attack(ctx));
		tasks.add(new Abilites(ctx));
		tasks.add(new Antiban(ctx));

		Skill.add(new Skill(ctx, Skills.ATTACK));
		Skill.add(new Skill(ctx, Skills.STRENGTH));
		Skill.add(new Skill(ctx, Skills.DEFENSE));
		Skill.add(new Skill(ctx, Skills.RANGE));
		Skill.add(new Skill(ctx, Skills.MAGIC));
		Skill.add(new Skill(ctx, Skills.HITPOINTS));

		paintImage = downloadImage("http://i.imgur.com/qClTOQU.png");
	}

	public void repaint(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		g.drawImage(paintImage, 0, 150, null);

		g.drawString("Time Running: " + Methods.Paint.getTime(getRuntime()),
				12, 220);
		g.drawString("Training: " + Skill.getTrainingSkill(), 12, 235);
		g.drawString("HP Exp Gained: " + Skill.getHpXpGained(), 12, 250);
		g.drawString("Exp Gained: " + Skill.getXpGained(), 12, 265);
		g.drawString(
				"Exp/Hour: "
						+ Methods.Paint.getPerHour(Skill.getXpGained(),
								getRuntime()), 12, 280);
		g.drawString("Lvls Gained: " + Skill.getLvlsGained(), 12, 295);
	}

	public void poll() {

		try {
			for (Task task : tasks) {
				if (task.activate()) {
					task.execute();
				}
			}
			Thread.sleep(500, 1300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
