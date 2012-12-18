package effects;
public class MagicResistance extends PermanentBuff {
	public MagicResistance(int[] value) {
		super(value, false, false, true, new int[] {1}, "Magic Resistance");
	}
}