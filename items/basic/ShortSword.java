package items.basic;
import effects.Effect;
import items.Sword;
public class ShortSword extends Sword{
	public ShortSword() {
		super("Short Sword", 2, new int[] {0, 0, 0, 0}, 4, 8, 1);
	}
	@Override
	public String getUniqueName() {
		return "Sting";
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}