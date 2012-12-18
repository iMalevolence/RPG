package effects;
public class PermanentBuff extends Buff implements Effect {
	private boolean isStat;
	private int[] location;
	private boolean isResource;
	private boolean isResistance;
	public PermanentBuff(int[] value, boolean isStat, boolean isResource, boolean isResistance, int[] location, String name) {
		super(value, 0, true, name);
		this.isStat = isStat;
		this.location = location;
		this.isResource = isResource;
		this.isResistance = isResistance;
	}
	public boolean isResource() {
		return isResource;
	}
	public boolean isStat() {
		return isStat;
	}
	public boolean isResistance() {
		return isResistance;
	}
	public int[] getLocations() {
		return location;
	}
	@Override
	public String toString() {
		if (this.getLocations().length == 1) {
			return "+" + this.getValue()[0] + ((isStat) ? (this.getLocations()[0] == 0) ? " to Strength" : (this.getLocations()[0] == 1) ? " to Dexterity" : (this.getLocations()[0] == 2) ? " to Magic" : " to Vitality"
				: (isResistance) ? (this.getLocations()[0] == 0) ? " to Physical Resistance" : " to Magic Resistance" : (isResource) ? (this.getLocations()[0] == 0) ? " to Life" : " to Mana" : "% to Armor");
		} else {
			return "+" + this.getValue()[0]  + ((isStat) ? " to All Stats" : (isResistance) ? " to All Resistances" : "% to Armor");
		}
	}
}