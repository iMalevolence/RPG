package items;

import effects.Effect;

public class Axe extends PhysicalWeapon {
	public Axe(String name, int weight, int[] requirements, int minDamage, int maxDamage, double effectModifier) {
		super(name, weight, requirements, minDamage, maxDamage, effectModifier);
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