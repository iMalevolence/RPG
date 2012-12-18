package items.basic;
import effects.Effect;
import items.Claw;
public class Knuckles extends Claw {
	public Knuckles() {
		super("Knuckles", 1, new int[] {0, 0, 0, 0}, 4, 7, 1);
	}
	@Override
	public String getUniqueName() {
		return "Iron Fists";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}