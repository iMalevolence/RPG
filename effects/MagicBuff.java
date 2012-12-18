package effects;
public class MagicBuff extends PermanentBuff implements Effect {
	public MagicBuff(int[] value) {
		super(value, true, false, false, new int[] {2}, "Magic");
	}
}