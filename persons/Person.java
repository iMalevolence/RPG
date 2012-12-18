package persons;
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
import attacks.Attack;
import effects.Debuff;
public interface Person {
	public String getName();
	/**
	 * Calculates the chance that the attacker will hit the target.
	 * @param target The person being attacked.
	 * @return An integer representing a % chance. >= 0 and <= 95.
	 */
	public int chanceToHit(Person target);
	/**
	 * Creates an attack object to pass to the target.
	 * @param chanceToHit Percent chance to hit the target. 
	 * @param target Person being attacked.
	 * @return An attack object containing various stats.
	 */
	public Attack getAttack(int chanceToHit, Person target);
	/**
	 * Selects the target from an array list of possible targets based on life of characters, chance to hit, etc.
	 * @param possibleTargets ArrayList of all possible targets.
	 * @return Person being attacked.
	 */
	public ArrayList<Item> getInventory();
	/**
	 * Drops an item from the inventory.
	 * @param toDrop The item to be dropped.
	 * @return Returns 1 if the item was dropped, -1 otherwise, 0 if the item wasn't found.
	 */
	public int dropItem(Item toDrop);
	/**
	 * Picks up an item an adds it to the inventory.
	 * @param toPickup Item to be picked up.
	 * @throws ItemToHeavyException 
	 */
	public void pickupItem(Item toPickup) throws ItemToHeavyException;
	/**
	 * Changes helmet of character to the given parameter.
	 * @param helm Helm to be worn.
	 * @return Returns true if the item is instance of helm, is wearable, and is now being worn.
	 * @throws NoSuchItemException Throws this exception if the item is not in the inventory.
	 * @throws WrongItemTypeException Throws this if the person tries to equip say, boots on their head.
	 */
	public boolean setHelm(Wearable helm) throws NoSuchItemException, WrongItemTypeException;
	/**
	 * Gets the helm on this player.
	 * @return Helm on this player.  Null if the player isn't wearing one.
	 */
	public Helm getHelm();
	/**
	 * Changes necklace of character to given necklace.
	 * @param necklace Necklace to be worn.
	 * @return Returns true if the item is instance of necklace and is wearable.
	 * @throws NoSuchItemException  Throws if item is not in the inventory of the character.
	 * @throws WrongItemTypeException Throws if items is not a necklace.
	 */
	public boolean setNecklace(Wearable necklace) throws NoSuchItemException, WrongItemTypeException;
	public Necklace getNecklace();
	public boolean setWeapon(Wearable weapon) throws NoSuchItemException, WrongItemTypeException;
	public Weapon getWeapon();
	public boolean setArmor(Wearable armor) throws NoSuchItemException, WrongItemTypeException;
	public BodyArmor getArmor();
	public boolean setShield(Wearable shield) throws NoSuchItemException, WrongItemTypeException;
	public Shield getShield();
	public boolean setGloves(Wearable gloves) throws NoSuchItemException, WrongItemTypeException;
	public Gloves getGloves();
	public boolean setRingLeft(Wearable ring) throws NoSuchItemException, WrongItemTypeException;
	public Ring getRingLeft();
	public boolean setBelt(Wearable belt) throws NoSuchItemException, WrongItemTypeException;
	public Belt getBelt();
	public boolean setRingRight(Wearable ring) throws NoSuchItemException, WrongItemTypeException;
	public Ring getRingRight();
	public boolean setBoots(Wearable boots) throws NoSuchItemException, WrongItemTypeException;
	public Boots getBoots();
	public int getLevel();
	public int getExperience();
	public int getHealth();
	public int getTotalHealth();
	public int getMagic();
	public int getDexterity();
	public int getStrength();
	public int getVitality();
	public int getArmorRating();
	public int getWeight();
	public void addExperience(int experience);
	public boolean levelUp();
	public void setLevel(int level);
	public void addDexterity(int dex);
	public void setDexterity(int dex);
	public void addStrength(int str);
	public void setStrength(int str);
	public void setVitality(int vita);
	public void addVitality(int vita);
	public void addMagic(int magic);
	public void setMagic(int magic);
	public int getPrimaryStat();
	public int[] getStats();
	public int[] getResistances();
	public boolean receiveAttack(Attack attack);
	public void removeItem(int location);
	public void putOnItem(Wearable w, int location);
	public Wearable[] getEquipment();
	public ArrayList<Debuff> getDebuffs();
	public void addDebuff(Debuff db);
	public void removeDebuff(Debuff db);
	public int getPhysicalResistance();
	public int getMagicResistance();
}
