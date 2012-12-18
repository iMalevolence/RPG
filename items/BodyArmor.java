package items;

import effects.Effect;

public class BodyArmor extends Armor implements Item {
	public BodyArmor(String name, int weight, int armorRating, int[] requirements, double effectModifier) {
		super(name, weight, armorRating, requirements, effectModifier);
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