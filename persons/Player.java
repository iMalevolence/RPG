package persons;
import items.Armor;
import items.Belt;
import items.BodyArmor;
import items.Boots;
import items.Gloves;
import items.Helm;
import items.Item;
import items.ItemToHeavyException;
import items.Necklace;
import items.NoSuchItemException;
import items.Ring;
import items.Shield;
import items.Weapon;
import items.Wearable;
import items.WrongItemTypeException;
import java.util.ArrayList;
import java.util.Random;
import attacks.Attack;
import attacks.NormalAttack;
import effects.Debuff;
import effects.Effect;
import effects.PermanentBuff;
public class Player implements Person {
	private String name;
	private ArrayList<Debuff> debuffs = new ArrayList<Debuff>();
	private ArrayList<Item> inventory;
	private Wearable[] onPerson;
	private int primaryStat;
	private int[] stats;
	private int[] resistances;
	private int[] resources;
	private int carryWeight;
	private int level;
	private int experience;
	private int armorRating;
	public Player(String name, int primaryStat) {
		this.name = name;
		inventory = new ArrayList<Item>();
		onPerson = new Wearable[10];
		stats = new int[] {20, 20, 20, 20};
		if (primaryStat < 0 || primaryStat > 2) {
			this.primaryStat = 0;
		} else {
			this.primaryStat = primaryStat;
		}
		if (primaryStat == 2) {
			resistances = new int[] {0, 5};
		} else {
			resistances = new int[] {5, 0};
		}
		stats[this.primaryStat] += 5;
		level = 1;
		resources = new int[] {40, 40};
		carryWeight = 100;
		armorRating = 6;
	}
	@Override
	public int chanceToHit(Person target) {
		int cth = (level - target.getLevel() > 0) ? 95 : 80;
		if (cth == 95) {
		} else {
		}
		return Math.max(5, Math.min(95, cth));
	}
	@Override
	public Attack getAttack(int chanceToHit, Person target) {
		return new NormalAttack(this, chanceToHit, target);
	}
	@Override
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	@Override
	public int dropItem(Item toDrop) {
		if (toDrop == null) {
			return 0;
		}
		if (toDrop.isDroppable()) {
			if (inventory.remove(toDrop)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}
	@Override
	public void pickupItem(Item toPickup) throws ItemToHeavyException {
		if (getWeight() + toPickup.getWeight() <= carryWeight) {
			inventory.add(toPickup);
		} else {
			throw new ItemToHeavyException();
		}
	}
	@Override
	public boolean setHelm(Wearable helm) throws NoSuchItemException, WrongItemTypeException {
		if (helm != null) {
			if (helm instanceof Helm) {
				if (helm.getLevelRequirement() > level || helm.getStrengthRequirement() > stats[0]
						|| helm.getDexterityRequirement() > stats[1] || helm.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(helm)) {
					if (onPerson[0] != null) {
						removeItem(0);
					}
					putOnItem(helm, 0);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(0);
			return true;
		}
	}
	@Override
	public boolean setNecklace(Wearable necklace) throws NoSuchItemException, WrongItemTypeException {
		if (necklace != null) {
			if (necklace instanceof Necklace) {
				if (necklace.getLevelRequirement() > level || necklace.getStrengthRequirement() > stats[0]
						|| necklace.getDexterityRequirement() > stats[1] || necklace.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(necklace)) {
					if (onPerson[1] != null) {
						removeItem(1);
					}
					putOnItem(necklace, 1);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(1);
			return true;
		}
	}
	@Override
	public boolean setWeapon(Wearable weapon) throws NoSuchItemException, WrongItemTypeException {
		if (weapon != null) {
			if (weapon instanceof Weapon) {
				if (weapon.getLevelRequirement() > level || weapon.getStrengthRequirement() > stats[0]
						|| weapon.getDexterityRequirement() > stats[1] || weapon.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(weapon)) {
					if (onPerson[2] != null) {
						removeItem(2);
					}
					putOnItem(weapon, 2);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(2);
			return true;
		}
	}
	@Override
	public boolean setArmor(Wearable armor) throws NoSuchItemException, WrongItemTypeException {
		if (armor != null) {
			if (armor instanceof BodyArmor) {
				if (armor.getLevelRequirement() > level || armor.getStrengthRequirement() > stats[0]
						|| armor.getDexterityRequirement() > stats[1] || armor.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(armor)) {
					if (onPerson[3] != null) {
						removeItem(3);
					}
					putOnItem(armor, 3);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(3);
			return true;
		}
	}
	@Override
	public boolean setShield(Wearable shield) throws NoSuchItemException, WrongItemTypeException {
		if (shield != null) {
			if (shield instanceof Shield) {
				if (shield.getLevelRequirement() > level || shield.getStrengthRequirement() > stats[0]
						|| shield.getDexterityRequirement() > stats[1] || shield.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(shield)) {
					if (onPerson[4] != null) {
						removeItem(4);
					}
					putOnItem(shield, 4);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(4);
			return true;
		}
	}
	@Override
	public boolean setGloves(Wearable gloves) throws NoSuchItemException, WrongItemTypeException {
		if (gloves != null) {
			if (gloves instanceof Gloves) {
				if (gloves.getLevelRequirement() > level || gloves.getStrengthRequirement() > stats[0]
						|| gloves.getDexterityRequirement() > stats[1] || gloves.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(gloves)) {
					if (onPerson[5] != null) {
						removeItem(5);
					}
					putOnItem(gloves, 5);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(5);
			return true;
		}
	}
	@Override
	public boolean setRingLeft(Wearable ring) throws NoSuchItemException, WrongItemTypeException {
		if (ring != null) {
			if (ring instanceof Ring) {
				if (ring.getLevelRequirement() > level || ring.getStrengthRequirement() > stats[0]
						|| ring.getDexterityRequirement() > stats[1] || ring.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(ring)) {
					if (onPerson[6] != null) {
						removeItem(6);
					}
					putOnItem(ring, 6);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(6);
			return true;
		}
	}
	@Override
	public boolean setBelt(Wearable belt) throws NoSuchItemException, WrongItemTypeException {
		if (belt != null) {
			if (belt instanceof Belt) {
				if (belt.getLevelRequirement() > level || belt.getStrengthRequirement() > stats[0]
						|| belt.getDexterityRequirement() > stats[1] || belt.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(belt)) {
					if (onPerson[7] != null) {
						removeItem(7);
					}
					putOnItem(belt, 7);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(7);
			return true;
		}
	}
	@Override
	public boolean setRingRight(Wearable ring) throws NoSuchItemException, WrongItemTypeException {
		if (ring != null) {
			if (ring instanceof Ring) {
				if (ring.getLevelRequirement() > level || ring.getStrengthRequirement() > stats[0]
						|| ring.getDexterityRequirement() > stats[1] || ring.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(ring)) {
					if (onPerson[8] != null) {
						removeItem(8);
					}
					putOnItem(ring, 8);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(8);
			return true;
		}
	}
	@Override
	public boolean setBoots(Wearable boots) throws NoSuchItemException, WrongItemTypeException {
		if (boots != null) {
			if (boots instanceof Boots) {
				if (boots.getLevelRequirement() > level || boots.getStrengthRequirement() > stats[0]
						|| boots.getDexterityRequirement() > stats[1] || boots.getMagicRequirement() > stats[2]) {
					return false;
				}
				if (inventory.remove(boots)) {
					if (onPerson[9] != null) {
						removeItem(9);
					}
					putOnItem(boots, 9);
					return true;
				} else {
					throw new NoSuchItemException();
				}
			}
			throw new WrongItemTypeException();
		} else {
			removeItem(9);
			return true;
		}
	}
	@Override
	public int getHealth() {
		return resources[0];
	}
	@Override
	public int getTotalHealth() {
		return resources[1];
	}
	@Override
	public int getStrength() {
		return stats[0];
	}
	@Override
	public int getDexterity() {
		return stats[1];
	}
	@Override
	public int getMagic() {
		return stats[2];
	}
	@Override
	public int getVitality() {
		return stats[3];
	}
	@Override
	public int getArmorRating() {
		return armorRating;
	}
	@Override
	public int getWeight() {
		int weight = 0;
		for (Item e : inventory) {
			weight += e.getWeight();
		}
		return weight;
	}
	@Override
	public int getLevel() {
		return level;
	}
	@Override
	public int getExperience() {
		return experience;
	}
	@Override
	public void addExperience(int experience) {
		this.experience += experience;
		
	}
	@Override
	public boolean levelUp() {
		if (experience >= 100 + (10 * (level - 1))) {
			experience -= (100 + (10 * (level - 1)));
			if (level < 100) {
				level++;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	@Override
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public void addStrength(int str) {
		stats[0] += str;
	}
	@Override
	public void setStrength(int str) {
		stats[0] = str;
	}
	@Override
	public void addDexterity(int dex) {
		stats[1] += dex;
	}

	@Override
	public void setDexterity(int dex) {
		stats[1] = dex;
	}

	@Override
	public void addMagic(int magic) {
		stats[2] = magic;
	}

	@Override
	public void setMagic(int magic) {
		stats[2] = magic;
	}

	@Override
	public void setVitality(int vita) {
		stats[3] = vita;
	}

	@Override
	public void addVitality(int vita) {
		stats[3] += vita;
	}

	@Override
	public int[] getResistances() {
		return resistances;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean receiveAttack(Attack attack) {
		Random r = new Random();
		if (r.nextInt(100) < attack.getChanceToHit()) {
			double modifier = 1;
			modifier = (100.0 - Math.min(resistances[attack.getType()], 75) / 100) * modifier;
			resources[0] -= (int) Math.floor(modifier * attack.getDamage());
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Helm getHelm() {
		if (onPerson[0] != null) {
			return (Helm) onPerson[0];
		} else {
			return null;
		}
	}
	
	@Override
	public Necklace getNecklace() {
		if (onPerson[1] != null) {
			return (Necklace) onPerson[1];
		} else {
			return null;
		}
	}
	@Override
	public Weapon getWeapon() {
		if (onPerson[2] != null) {
			return (Weapon) onPerson[2];
		} else {
			return null;
		}
	}
	@Override
	public BodyArmor getArmor() {
		if (onPerson[3] != null) {
			return (BodyArmor) onPerson[3];
		} else {
			return null;
		}
	}
	@Override
	public Shield getShield() {
		if (onPerson[4] != null) {
			return (Shield) onPerson[4];
		} else {
			return null;
		}
	}
	@Override
	public Gloves getGloves() {
		if (onPerson[5] != null) {
			return (Gloves) onPerson[5];
		} else {
			return null;
		}
	}
	@Override
	public Ring getRingLeft() {
		if (onPerson[6] != null) {
			return (Ring) onPerson[6];
		} else {
			return null;
		}
	}
	@Override
	public Belt getBelt() {
		if (onPerson[7] != null) {
			return (Belt) onPerson[7];
		} else {
			return null;
		}
	}
	@Override
	public Ring getRingRight() {
		if (onPerson[8] != null) {
			return (Ring) onPerson[8];
		} else {
			return null;
		}
	}
	@Override
	public Boots getBoots() {
		if (onPerson[9] != null) {
			return (Boots) onPerson[9];
		} else {
			return null;
		}
	}
	@Override
	public void removeItem(int location) {
		if (onPerson[location] != null) {
			if (onPerson[location] instanceof Armor) {
				Armor x = (Armor) onPerson[location];
				armorRating -= x.getArmorRating();
			}
			inventory.add(onPerson[location]);
			for (Effect e : onPerson[location].getEffects()) {
				if (e.isPermanent() && e.isBuff()) {
					PermanentBuff pb = (PermanentBuff) e;
					if (pb.isStat()) {
						for (int i = 0; i < pb.getValue().length; i++) {
							stats[pb.getLocations()[i]] -= pb.getValue()[i];
							if (pb.getLocations()[i] == 3) {
								resources[1] -= pb.getValue()[i] * 2;
								if (resources[0] > resources[1]) {
									resources[0] = resources[1];
								}
							}
						}
					} else if (pb.isResource()) {
						for (int i = 0; i < pb.getValue().length; i++) {
							resources[pb.getLocations()[i]] -= pb.getValue()[i];
							resources[pb.getLocations()[i] + 1] -= pb.getValue()[i];
						}
					} else if (pb.isResistance()) {
						for (int i = 0; i < pb.getValue().length; i++) {
							resistances[pb.getLocations()[i]] -= pb.getValue()[i];
						}
					}
				}
			}
			onPerson[location] = null;
		}
	}
	@Override
	public void putOnItem(Wearable w, int location) {
		if (w instanceof Armor) {
			Armor x = (Armor) w;
			armorRating += x.getArmorRating();
		}
		onPerson[location] = w;
		Effect[] e = w.getEffects();
		for (Effect ef : e) {
			if (ef.isPermanent() && ef.isBuff()) {
				PermanentBuff pb = (PermanentBuff) ef;
				if (pb.isStat()) {
					for (int i = 0; i < pb.getValue().length; i++) {
						stats[pb.getLocations()[i]] += pb.getValue()[i];
						if (pb.getLocations()[i] == 3) {
							resources[0] += pb.getValue()[i] * 2;
							resources[1] += pb.getValue()[i] * 2;
						}
					}
				} else if (pb.isResource()) {
					for (int i = 0; i < pb.getValue().length; i++) {
						resources[pb.getLocations()[i]] += pb.getValue()[i];
						resources[pb.getLocations()[i] + 1] += pb.getValue()[i];
					}
				} else if (pb.isResistance()) {
					for (int i = 0; i < pb.getValue().length; i++) {
						resistances[pb.getLocations()[i]] += pb.getValue()[i];
					}
				}
			}
		}
	}
	@Override
	public int getPrimaryStat() {
		return primaryStat;
	}
	@Override
	public int[] getStats() {
		return stats;
	}
	@Override
	public Wearable[] getEquipment() {
		return onPerson;
	}
	@Override
	public ArrayList<Debuff> getDebuffs() {
		return debuffs;
	}
	@Override
	public void addDebuff(Debuff db) {
		debuffs.add(db);
	}
	@Override
	public void removeDebuff(Debuff db) {
		debuffs.remove(db);
	}
	@Override
	public int getPhysicalResistance() {
		return resistances[0];
	}
	@Override
	public int getMagicResistance() {
		return resistances[1];
	}
}