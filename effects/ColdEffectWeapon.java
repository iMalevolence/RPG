package effects;
import java.util.Random;
public class ColdEffectWeapon extends WeaponEffects implements Effect {
	private static int minTurn = 1;
	private static int maxTurn = 5;
	private static int minChance = 10;
	private static int maxChance = 40;
	private static int debuffChancePerTurn = 35;
	private static Random r = new Random();
	public ColdEffectWeapon() {
		super(new int[] {0}, r.nextInt(1 + maxTurn - minTurn) + minTurn, r.nextInt(maxChance + 1 - minChance) + minChance, "Cold Weapon");
	}
	@Override
	public Debuff giveEffect() {
		return new ColdDebuff(this.getTurns(), debuffChancePerTurn);
	}
}