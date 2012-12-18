package items;

import effects.Effect;

public class PhysicalWeapon extends Weapon implements Item {
	public PhysicalWeapon(String name, int weight, int[] requirements, int minDamage, int maxDamage, double effectModifier) {
		super(name, weight, 0, requirements, minDamage, maxDamage, effectModifier);
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