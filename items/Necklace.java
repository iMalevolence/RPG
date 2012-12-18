package items;

import effects.Effect;

public class Necklace extends Jewelry implements Item {
	public Necklace(String name, int levelReq, double effectModifier) {
		super(name, new int[] {levelReq, 0, 0, 0}, effectModifier);
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