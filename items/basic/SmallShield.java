package items.basic;
import items.Shield;
import java.util.Random;

import effects.Effect;
public class SmallShield extends Shield {
	private static int min = 8;
	private static int max = 12;
	private static Random r = new Random();
	public SmallShield() {
		super("Small Shield", 2, r.nextInt(max - min + 1) + min, new int[] {0, 0, 0, 0}, 1);
	}
	@Override
	public String getUniqueName() {
		return "Black Oak Shield";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}