package items;

import effects.Effect;

public class Armor extends Wearable implements Item {
	private int armorRating;
	public Armor(String name, int weight, int armorRating, int[] requirements, double effectModifier) {
		super(name, weight, requirements, true, false, effectModifier);
		this.armorRating = armorRating;
	}
	public int getArmorRating() {
		return armorRating;
	}
	public void setArmorRating(int armorRating) {
		this.armorRating = armorRating;
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