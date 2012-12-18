package items.basic;
import java.util.Random;

import effects.Effect;
import items.Boots;
public class LeatherBoots extends Boots {
	private static int min = 3;
	private static int max = 5;
	private static Random r = new Random();
	public LeatherBoots() {
		super("Leather Boots", 2, r.nextInt(max + 1 - min) + min, new int[] {0, 0, 0, 0}, 1);
	}
	@Override
	public String getUniqueName() {
		return "Soul Striders";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}