package effects;
public class ArmorBuff extends PermanentBuff {
	public ArmorBuff(int[] value) {
		super(value, false, false, false, new int[] {}, "Enhanced Defense");
	}
}