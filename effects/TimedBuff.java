package effects;
public class TimedBuff extends Buff implements Effect {
	public TimedBuff(int[] value, int turns, String name) {
		super(value, turns, false, name);
	}
}