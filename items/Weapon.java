package items;

import effects.Effect;

public class Weapon extends Wearable implements Item {
	private int type;
	private int minDamage;
	private int maxDamage;
	private double effectModifier;
	public Weapon(String name, int weight, int type, int[] requirements, int minDamage, int maxDamage, double effectModifier) {
		super(name, weight, requirements, true, true, effectModifier);
		this.type = type;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.effectModifier = effectModifier;
	}
	public double getModifier() {
		return effectModifier;
	}
	public int getType() {
		return type;
	}
	public int getMinDamage() {
		return minDamage;
	}
	public int getMaxDamage() {
		return maxDamage;
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