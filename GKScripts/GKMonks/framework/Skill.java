package GKScripts.GKMonks.framework;

import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.rt6.ClientContext;

public class Skill {

	private static int id;
	private static int startXp;
	private static int startLvl;
	private static ClientContext ctx;

	private static List<Skill> skillsList = new ArrayList<Skill>();

	public Skill(final ClientContext c, int i) {
		ctx = c;
		id = i;
		startXp = ctx.skills.experience(i);
		startLvl = ctx.skills.level(i);
	}

	public static void add(Skill s) {
		skillsList.add(s);
	}

	private int getXp() {
		return ctx.skills.experience(id) - startXp;
	}

	private int getLevel() {
		return ctx.skills.level(id) - startLvl;
	}

	public static int getLvlsGained() {
		int highValue = 0;

		for (int i = 0; i < skillsList.size(); i++) {
			int lvl = skillsList.get(i).getLevel();
			if (lvl > highValue) {
				highValue = lvl;
			}
		}

		return highValue;
	}

	public static int getHpXpGained() {
		if (skillsList.size() > 0) {
			Skill s = skillsList.get(4);
			int xp = s.getXp();
			return xp;
		}
		return 0;
	}

	public static int getXpGained() {

		int highValue = 0;

		for (int i = 0; i < skillsList.size(); i++) {
			int xp = skillsList.get(i).getXp();
			if (xp > highValue) {
				highValue = xp;
			}
		}

		return highValue;
	}

	public static String getTrainingSkill() {

		String[] skills = { "Attack", "Strength", "Defence", "Ranged", "Magic" };

		int highPos = 0;
		int highValue = 0;

		for (int i = 0; i < skillsList.size(); i++) {
			int xp = skillsList.get(i).getXp();
			if (xp > highValue) {
				highValue = xp;
				highPos = i;
			} else if (xp == highValue && xp > 0) {
				return "Balanced";
			}
		}

		if (highValue == 0) {
			return "Loading...";
		}

		return skills[highPos];
	}

}
