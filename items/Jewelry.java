package items;

import effects.Effect;

public class Jewelry extends Wearable implements Item {
	public Jewelry(String name, int[] requirements, double effectModifier) {
		super(name, 1, requirements, true, false, effectModifier);
	}
	@Override
	public String getUniqueName() {
		return null;
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}