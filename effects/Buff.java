package effects;
public class Buff extends GeneralEffect implements Effect {
	public Buff(int[] value, int turns, boolean permanent, String name) {
		super(value, turns, permanent, true, name);
	}
}