package items;
import effects.Effect;
import persons.Person;
public class General implements Item {
	private String name;
	private int[] requirements;
	private boolean droppable;
	private int weight;
	private boolean wearable;
	public General(String name, int weight, int[] requirements, boolean droppable, boolean wearable) {
		this.name = name;
		this.droppable = droppable;
		this.weight = weight;
		this.requirements = requirements;
		this.wearable = wearable;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public boolean isWearable() {
		return wearable;
	}
	@Override
	public boolean isDroppable() {
		return droppable;
	}
	@Override
	public int getLevelRequirement() {
		return requirements[0];
	}
	@Override
	public int getStrengthRequirement() {
		return requirements[1];
	}
	@Override
	public int getDexterityRequirement() {
		return requirements[2];
	}
	@Override
	public int getMagicRequirement() {
		return requirements[3];
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void personalize(Person p) {
		name = p.getName() + "'s " + name;
	}
	@Override
	public void setDroppable(boolean droppable) {
		this.droppable = droppable;
	}
	@Override
	public void setLevelRequirement(int level) {
		requirements[0] = level;
	}
	@Override
	public void setStrengthRequirement(int str) {
		requirements[1] = str;
	}
	@Override
	public void setDexterityRequirement(int dex) {
		requirements[2] = dex;
	}
	@Override
	public void setMagicRequirement(int magic) {
		requirements[3] = magic;
	}
	@Override
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		if (wearable) {
			if (this instanceof Armor) {
				Armor x = (Armor) this;
				return name + "\nArmor: " + x.getArmorRating() + "\nWeight: " + weight + ((requirements[0] != 0) ? "\nRequired Level: " + requirements[0] : "") + 
						((requirements[1] != 0) ? "\nRequired Strength: " + requirements[1] : "") +
						((requirements[2] != 0) ? "\nRequired Dexterity: " + requirements[2] : "") +
						((requirements[3] != 0) ? "\nRequired Magic: " + requirements[3] : "") +
						"\nDroppable: " + ((droppable) ? "Yes" : "No") + "\n";
			} else {
				if (this instanceof Weapon) {
					Weapon w = (Weapon) this;
					return name + "\nDamage: " + w.getMinDamage() + "-" + w.getMaxDamage() + "\nWeight: "+ weight + ((requirements[0] != 0) ? "\nRequired Level: " + requirements[0] : "") + 
							((requirements[1] != 0) ? "\nRequired Strength: " + requirements[1] : "") +
							((requirements[2] != 0) ? "\nRequired Dexterity: " + requirements[2] : "") +
							((requirements[3] != 0) ? "\nRequired Magic: " + requirements[3] : "") +
							"\nDroppable: " + ((droppable) ? "Yes" : "No") + "\n";
				} else {
					return name + "\nWeight: " + weight + ((requirements[0] != 0) ? "\nRequired Level: " + requirements[0] : "") + 
							((requirements[1] != 0) ? "\nRequired Strength: " + requirements[1] : "") +
							((requirements[2] != 0) ? "\nRequired Dexterity: " + requirements[2] : "") +
							((requirements[3] != 0) ? "\nRequired Magic: " + requirements[3] : "") +
							"\nDroppable: " + ((droppable) ? "Yes" : "No") + "\n";
				}
			}
		} else {
			return name + "\nWeight: " + weight + "\nDroppable: " + ((droppable) ? "Yes" : "No");
		}
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