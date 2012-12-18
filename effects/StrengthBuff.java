package effects;
public class StrengthBuff extends PermanentBuff implements Effect {
	public StrengthBuff(int[] value) {
		super(value, true, false, false, new int[] {0}, "Strength");
	}
}