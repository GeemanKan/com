package GKScripts.GKFlax.framework;

import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.*;

public class Methods extends ClientAccessor {

	private static ClientContext ctx;

	public Methods(ClientContext c) {
		super(c);
		ctx = c;
	}
	
	public static class Location {

		public static final int TOP_FLOOR = 2;
		public static final int MID_FLOOR = 1;
		public static final int LOW_FLOOR = 0;

		public static int current() {
			return ctx.players.local().tile().floor();
		}

	}

	public static class Objects {

		public static void interact(int id, String action, Tile t) {

			GameObject o = ctx.objects.select().id(id).nearest().first().poll();

			if (o.valid()) {
				if (o.inViewport()) {
					if (o.interact(action)) {
						try {
							Thread.sleep(Random.nextInt(500, 2000));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else {
					if (Random.nextInt(0, 10) > 5) {
						ctx.camera.turnTo(o);
					}
					if (!ctx.players.local().inMotion()) {
						if (!o.inViewport() || Random.nextInt(0, 10) > 8) {
							ctx.movement.step(o);
						}
					}

				}
			}
		}
		
	}


	public static class Paint {

		public static String time(final long time) {
			final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
			return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
					+ (s < 10 ? "0" + s : s);
		}

		public static int perHour(int in, long time) {
			return (int) ((in) * 3600000D / time);
		}

	}
}
