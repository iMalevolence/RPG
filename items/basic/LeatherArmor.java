package items.basic;
import items.BodyArmor;
import java.util.Random;

import effects.Effect;
public class LeatherArmor extends BodyArmor {
	private static int min = 12;
	private static int max = 20;
	private static Random r = new Random();
	public LeatherArmor() {
		super("Leather Armor", 3, r.nextInt(max + 1 - min) + min, new int[] {0, 0, 0, 0}, 1);
	}
	@Override
	public String getUniqueName() {
		return "Suit of the Czar";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}