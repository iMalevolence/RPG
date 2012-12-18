package attacks;
import java.util.ArrayList;
import effects.Effect;
public interface Attack {
	/**
	 * Calculates damage and returns the value.
	 * @return The amount of damage this weapon, on this character, will do.  Scales with primary stat.
	 */
	public int getDamage();
	/**
	 * Returns chance to hit, calculated based on target defense, level differences.
	 * @return The chance to hit.
	 */
	public int getChanceToHit();
	/**
	 * Effects of the attack, pulled from the weapon.  Yet to be written.
	 * @return Returns effects on the weapon.
	 */
	public ArrayList<Effect> getEffects();
	/**
	 * Currently a 5% chance to be critical, dealing 2x damage.
	 * @return True if it is a critical attack.
	 */
	public boolean isCritical();
	/**
	 * Returns type of attack, physical or magical.
	 * @return Type of attack.
	 */
	public int getType();
}