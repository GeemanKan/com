package GKScripts.GKMonks.framework;

import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

public abstract class Methods {

	private static ClientContext ctx;

	public Methods(ClientContext c) {
		ctx = c;
	}
	public static class Paint {

		public static String getTime(final long time) {
			final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
			return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
					+ (s < 10 ? "0" + s : s);
		}

		public static int getPerHour(int in, long time) {
			return (int) ((in) * 3600000D / time);
		}

	}

	public static class Health {
		public static boolean needsToHeal() {
			return getLifePointsPercent() < Info.HEAL_PERCENT
					+ Random.nextInt(-5, 5);
		}

		public static int getLifePoints(boolean isCurrent) {
			Component c;
			try {
				c = ctx.widgets.component(1430, 104).component(7);

			} catch (Exception e) {
				return -1;
			}

			String lp = c.text();

			int current = -1;
			int max = -1;
			int index = 0;

			index = lp.indexOf("/");
			current = Integer.parseInt(lp.substring(0, index));
			max = Integer.parseInt(lp.substring(index + 1));

			if (isCurrent) {
				return current;
			}
			return max;
		}

		public static int getLifePointsPercent() {
			float current = getLifePoints(true);
			float max = getLifePoints(false);
			float calc = (float) current / max * 100;
			return (int) calc;

		}
	}

}
