package effects;
public class VitalityBuff extends PermanentBuff implements Effect {
	public VitalityBuff(int[] value) {
		super(value, true, false, false, new int[] {3}, "Vitality");
	}
}