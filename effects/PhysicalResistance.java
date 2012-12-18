package effects;
public class PhysicalResistance extends PermanentBuff {
	public PhysicalResistance(int[] value) {
		super(value, false, false, true, new int[] {0}, "Physical Resistance");
	}
}