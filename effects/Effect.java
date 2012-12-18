package effects;
public interface Effect {
	public int[] getValue();
	public int getTurns();
	public int getTurnsLeft();
	public boolean updateTurn();
	public boolean isPermanent();
	public boolean isBuff();
	public String toString();
	public String getName();
}
