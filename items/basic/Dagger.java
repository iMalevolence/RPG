package items.basic;
import effects.Effect;
import items.Sword;
public class Dagger extends Sword {
	public Dagger() {
		super("Dagger", 1, new int[] {0, 0, 0, 0}, 3, 7, 1);
	}
	@Override
	public String getUniqueName() {
		return "Shank of Xerxes";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}