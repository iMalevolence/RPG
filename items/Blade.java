package items;

import effects.Effect;

public class Blade extends PhysicalWeapon {
	public Blade(String name, int weight, int[] requirements, int minDamage, int maxDamage, double effectModifier) {
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