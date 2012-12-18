package effects;
public class DexterityBuff extends PermanentBuff implements Effect {
	public DexterityBuff(int[] value) {
		super(value, true, false, false, new int[] {1}, "Dexterity");
	}
}