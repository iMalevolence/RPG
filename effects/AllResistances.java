package effects;
public class AllResistances extends PermanentBuff {
	public AllResistances(int[] value) {
		super(value, false, false, true, new int[] {0, 1}, "All Resistances");
	}
}