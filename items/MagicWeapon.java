package items;

import effects.Effect;

public class MagicWeapon extends Weapon implements Item {
	public MagicWeapon(String name, int weight, int[] requirements, int minDamage, int maxDamage, double effectModifier) {
		super(name, weight, 1, requirements, minDamage, maxDamage, effectModifier);
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