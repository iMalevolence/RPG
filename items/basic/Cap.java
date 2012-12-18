package items.basic;
import items.Helm;
import java.util.Random;

import effects.Effect;
public class Cap extends Helm {
	private static int min = 2;
	private static int max = 5;
	private static Random r = new Random();
	public Cap() {
		super("Cap", 2, r.nextInt(max - min + 1) + min, new int[] {0, 0, 0, 0}, 1);
	}
	@Override
	public String getUniqueName() {
		return "Sacred Cap of Amun-Dar";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}
