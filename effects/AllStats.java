package effects;
public class AllStats extends PermanentBuff {
	public AllStats(int[] value) {
		super(value, true, false, false, new int[]{0, 1, 2, 3}, "All Stats");
	}
}