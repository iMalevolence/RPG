package items;
import java.util.Random;

import effects.AllResistances;
import effects.AllStats;
import effects.ArmorBuff;
import effects.ColdEffectWeapon;
import effects.DexterityBuff;
import effects.Effect;
import effects.LifeBuff;
import effects.MagicBuff;
import effects.MagicResistance;
import effects.PhysicalResistance;
import effects.StrengthBuff;
import effects.VitalityBuff;
public class Wearable extends General implements Item {
	private Effect[] effects;
	private boolean isWeapon;
	private boolean hasSuffix;
	private static Random r = new Random();
	public Wearable(String name, int weight, int[] requirements, boolean droppable, boolean isWeapon, double effectModifier) {
		super(name, weight, requirements, droppable, true);
		this.isWeapon = isWeapon;
		hasSuffix = false;
		effects = randomizeEffects(effectModifier);
	}
	public Effect[] getEffects() {
		return effects;
	}
	public boolean isWeapon() {
		return isWeapon;
	}
	public Effect[] randomizeEffects(double effectModifier) {
		int effects = 0;
		if (r.nextInt(100) < 40) {
			effects++;
			if (r.nextBoolean()) {
				effects++;
			} else {
				if (r.nextBoolean() && r.nextBoolean()) {
					effects++;
					if (r.nextBoolean()) {
						effects++;
						if (r.nextBoolean()) {
							effects++;
						}
					}
				}
			}
		}
		Effect[] ef = new Effect[0];
		if (effects <= 2) {
			ef = generateEffect(true, effectModifier, effects);
		} else if (effects <= 4) {
			ef = generateEffect(false, effectModifier, effects);
		} else {
			ef = getUnique();
		}
		return ef;
	}
	private Effect[] generateEffect(boolean magic, double modifier, int size) {
		if (!magic) {
			this.setName("Rare " + this.getName());
		}
		Effect[] ef = new Effect[size];
		for (int i = 0; i < size; i++) {
			int selector = r.nextInt(10);
			if (selector == 0) {
				ef[i] = new LifeBuff(new int[] {(int) ((r.nextInt(16) + 5) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Longevity");
						hasSuffix = true;
					} else {
						this.setName("Immortals' " + this.getName());
					}
				}
			} else if (selector == 1) {
				ef[i] = new MagicBuff(new int[] {(int) ((r.nextInt(6) + 5) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Sorcery");
						hasSuffix = true;
					} else {
						this.setName("Magicians' " + this.getName());
					}
				}
			} else if (selector == 2) {
				ef[i] = new StrengthBuff(new int[] {(int) ((r.nextInt(6) + 5) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Fortitude");
						hasSuffix = true;
					} else {
						this.setName("Knights' " + this.getName());
					}
				}
			} else if (selector == 3) {
				ef[i] = new DexterityBuff(new int[] {(int) ((r.nextInt(6) + 5) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Finesse");
						hasSuffix = true;
					} else {
						this.setName("Assassins' " + this.getName());
					}
				}
			} else if (selector == 4) {
				ef[i] = new VitalityBuff(new int[] {(int) ((r.nextInt(6) + 5) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Vigor");
						hasSuffix = true;
					} else {
						this.setName("Ancients' " + this.getName());
					}
				}
			} else if (selector == 5) {
				ef[i] = new PhysicalResistance(new int[] {(int) ((r.nextInt(5) + 1) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Resilience");
						hasSuffix = true;
					} else {
						this.setName("Guardians' " + this.getName());
					}
				}
			} else if (selector == 6) {
				ef[i] = new MagicResistance(new int[] {(int) ((r.nextInt(5) + 1) * modifier)});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of the Arcane");
						hasSuffix = true;
					} else {
						this.setName("Occultists' " + this.getName());
					}
				}
			} else if (selector == 7) {
				int value = (int) ((r.nextInt(3) + 1) * modifier);
				ef[i] = new AllResistances(new int[] {value, value});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Sanctity");
						hasSuffix = true;
					} else {
						this.setName("Monks' " + this.getName());
					}
				}
			} else if (selector == 8) {
				int value = (int) ((r.nextInt(6) + 2) * modifier);
				ef[i] = new AllStats(new int[] {value, value, value, value});
				if (magic) {
					if (!hasSuffix) {
						this.setName(this.getName() + " of Perfection");
						hasSuffix = true;
					} else {
						this.setName("Masters' " + this.getName());
					}
				}
			} else if (selector == 9) {
				if (this.isWeapon()) {
					ef[i] = new ColdEffectWeapon();
					if (magic) {
						if (!hasSuffix) {
							this.setName(this.getName() + " of Frost");
							hasSuffix = true;
						} else {
							if (this.getName().endsWith("of Frost")) {
								i--;
							} else {
								this.setName("Freezing " + this.getName());
							}
						}
					} else {
						for (int j = 0; j < i; j++) {
							if (ef[j] instanceof ColdEffectWeapon) {
								i--;
							}
						}
					}
				} else if (this instanceof Armor) {
					ef[i] = new ArmorBuff(new int[] {(int) ((r.nextInt(11) + 5) * modifier)});
					Armor x = (Armor) this;
					x.setArmorRating((int) Math.floor(x.getArmorRating() + (1.0 * ef[i].getValue()[0] / 100)));
					if (magic) {
						if (!hasSuffix) {
							this.setName(this.getName() + " of Protection");
							hasSuffix = true;
						} else {
							this.setName("Defenders' " + this.getName());
						}
					}
				} else if (this instanceof Jewelry) {
					i--;
				}
			}
		}
		return ef;
	}
	@Override
	public String getUniqueName() {
		return null;
	}
	@Override
	public Effect[] getUnique() {
		return null;
	}
}