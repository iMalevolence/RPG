package effects;
public class Debuff extends GeneralEffect implements Effect {
	private boolean damageDebuff;
	private boolean turnDebuff;
	private int chance;
	public Debuff(int value[], int turns, String name, boolean damage, boolean turn, int chance) {
		super(value, turns, false, false, name);
		damageDebuff = damage;
		turnDebuff = turn;
		
	}
	public boolean isDamage() {
		return damageDebuff;
	}
	public boolean isTurn() {
		return turnDebuff;
	}
	public int getChance() {
		return chance;
	}
}