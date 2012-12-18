package effects;
import java.util.Random;
public class WeaponEffects extends GeneralEffect implements Effect {
	private int chance;
	public WeaponEffects(int[] value, int turns, int chance, String name) {
		super(value, turns, false, false, name);
		this.chance = chance;
	}
	public int getChance() {
		return chance;
	}
	public boolean activateEffect() {
		Random r = new Random();
		if (r.nextInt(100) < chance) {
			return true;
		} else {
			return false;
		}
	}
	public Debuff giveEffect() {
		return null;
	}
}