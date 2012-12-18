package items.basic;
import items.Belt;
import java.util.Random;

import effects.Effect;
public class LeatherBelt extends Belt {
	private static int min = 3;
	private static int max = 5;
	private static Random r = new Random();
	public LeatherBelt() {
		super("Leather Belt", 1, r.nextInt(max + 1 - min) + min, new int[] {0, 0, 0, 0}, 1);
	}
	@Override
	public String getUniqueName() {
		return "Stranglehold";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}