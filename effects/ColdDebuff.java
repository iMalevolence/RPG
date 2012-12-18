package effects;
public class ColdDebuff extends Debuff {
	public ColdDebuff(int turns, int chance) {
		super(new int[] {0}, turns, "Frozen", false, true, chance);
	}
}