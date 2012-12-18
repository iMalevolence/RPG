package attacks;
import items.Axe;
import items.Blade;
import items.Claw;
import items.Staff;
import items.Sword;
import items.Wand;

import java.util.ArrayList;
import java.util.Random;

import persons.Person;
import effects.Debuff;
import effects.Effect;
import effects.WeaponEffects;
public class NormalAttack implements Attack {
	private ArrayList<Effect> effects = new ArrayList<Effect>();
	private int chanceToHit;
	private Person p;
	private boolean critical;
	public NormalAttack(Person p, int cth, Person target) {
		Random r = new Random();
		critical = false;
		if (p.getWeapon() instanceof Blade || p.getWeapon() instanceof Claw && p.getPrimaryStat() == 1) {
			if (r.nextInt(100) % 10 == 0) {
				critical = true;
			}
		} else {
			if (r.nextInt(100) % 20 == 0) {
				critical = true;
			}
		}
		this.p = p;
		chanceToHit = cth;
		for (Effect e : p.getWeapon().getEffects()) {
			if (e instanceof WeaponEffects) {
				WeaponEffects we = (WeaponEffects) e;
				if (we.activateEffect()) {
					boolean add = true;
					Debuff effect = we.giveEffect();
					for (Debuff db : target.getDebuffs()) {
						if (effect.getName().equalsIgnoreCase(db.getName())) {
							add = false;
						}
					}
					if (add) {
						effects.add(effect);
					}
				}
			}
		}
	}
	
	@Override
	public int getDamage() {
		Random r = new Random();
		int damage = r.nextInt(p.getWeapon().getMaxDamage() - p.getWeapon().getMinDamage() + 1) + p.getWeapon().getMinDamage();
		if (((p.getWeapon() instanceof Sword || p.getWeapon() instanceof Axe) && p.getPrimaryStat() == 0) || ((p.getWeapon() instanceof Blade || p.getWeapon() instanceof Claw) && p.getPrimaryStat() == 1) || ((p.getWeapon() instanceof Wand || p.getWeapon() instanceof Staff) && p.getPrimaryStat() == 2)) {
			damage = (int) (damage * (1 + (p.getStats()[p.getPrimaryStat()] / 50)));
		} else {
			if (p.getWeapon() instanceof Sword || p.getWeapon() instanceof Axe) {
				damage = (int) (damage * (1 + (p.getStats()[0] / 100)));
			} else if (p.getWeapon() instanceof Claw || p.getWeapon() instanceof Blade) {
				damage = (int) (damage * (1 + (p.getStats()[1] / 100)));
			} else if (p.getWeapon() instanceof Wand || p.getWeapon() instanceof Staff) {
				damage = (int) (damage * (1 + (p.getStats()[2] / 100)));
			}
		}
		if (critical) {
			if (p.getPrimaryStat() == 0 && (p.getWeapon() instanceof Sword || p.getWeapon() instanceof Axe)) {
				if (r.nextBoolean()) {
					return 5 * damage;
				} else {
					return damage;
				}
			} else if (p.getPrimaryStat() == 2 && (p.getWeapon() instanceof Wand || p.getWeapon() instanceof Staff)) {
				return 3 * damage;
			} else {
				return 2 * damage;
			}
		} else {
			return damage;
		}
	}

	@Override
	public int getChanceToHit() {
		return chanceToHit;
	}

	@Override
	public ArrayList<Effect> getEffects() {
		return effects;
	}

	@Override
	public boolean isCritical() {
		return critical;
	}

	@Override
	public int getType() {
		if (p.getWeapon() != null) {
			return p.getWeapon().getType();
		} else {
			return 0;
		}
	}
}
