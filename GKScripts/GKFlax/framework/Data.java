package GKScripts.GKFlax.framework;

import org.powerbot.script.Tile;

public class Data {
	
	public static class Animations {
		public static final int SPINNING = 1563;
	}
	
	public static class Ids {
		public static final int FLAX = 1779;
		public static final int BOWSTRING = 1777;
		public static final int WHEEL = 36970;
		public static final int STAIRS_UP = 36774;
		public static final int STAIRS_DOWN = 36775;
		public static final int BOOTH = 36786;
	}
	
	public static class Tiles {
		public static final Tile STAIRS = new Tile(3205, 3209);
		public static final Tile BANK = new Tile(3208, 3219);
		public static final Tile WHEEL = new Tile(3209, 3213);
	}
	
	public static class User {
		public static int START_XP;
		public static int START_LVL;
	}
}