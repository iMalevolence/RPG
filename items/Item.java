package items;
import effects.Effect;
import persons.Person;
public interface Item {
	public String getName();
	public void setName(String name);
	public void personalize(Person p);
	public boolean isDroppable();
	public void setDroppable(boolean droppable);
	public int getLevelRequirement();
	public void setLevelRequirement(int level);
	public int getStrengthRequirement();
	public void setStrengthRequirement(int str);
	public int getDexterityRequirement();
	public void setDexterityRequirement(int dex);
	public int getMagicRequirement();
	public void setMagicRequirement(int magic);
	public int getWeight();
	public boolean isWearable();
	public String getUniqueName();
	public Effect[] getUnique();
}