package effects;
public class LifeBuff extends PermanentBuff implements Effect {
	public LifeBuff(int[] value) {
		super(value, false, true, false, new int[] {0}, "Life");
	}
}