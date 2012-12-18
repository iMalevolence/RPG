package items.basic;
import java.util.Random;

import effects.Effect;
import items.Gloves;
public class LeatherGloves extends Gloves {
	private static int min = 3;
	private static int max = 5;
	private static Random r = new Random();
	public LeatherGloves() {
		super("Leather Gloves", 1, r.nextInt(max + 1 - min) + min, new int[] {0, 0, 0, 0}, 1);
	}
	@Override
	public String getUniqueName() {
		return "Grip of Death";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}
