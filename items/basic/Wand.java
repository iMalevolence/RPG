package items.basic;

import effects.Effect;

public class Wand extends items.Wand {
	public Wand() {
		super("Wand", 1, new int[] {0, 0, 0, 0}, 2, 9, 1);
	}
	@Override
	public String getUniqueName() {
		return "The Elder Wand";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}