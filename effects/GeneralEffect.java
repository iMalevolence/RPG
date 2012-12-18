package effects;
public class GeneralEffect implements Effect {
	private int[] value;
	private int turns;
	private int turnsLeft;
	private boolean permanent;
	private boolean buff;
	private String effectName;
	public GeneralEffect(int[] value, int turns, boolean permanent, boolean buff, String name) {
		this.value = value;
		this.turns = turns;
		turnsLeft = turns;
		this.permanent = permanent;
		this.buff = buff;
		effectName = name;
	}
	@Override
	public int[] getValue() {
		return value;
	}
	@Override
	public int getTurns() {
		return turns;
	}
	@Override
	public boolean updateTurn() {
		if (!permanent) {
			turnsLeft--;
			if (turnsLeft == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	@Override
	public int getTurnsLeft() {
		return turnsLeft;
	}
	@Override
	public boolean isPermanent() {
		return permanent;
	}
	@Override
	public boolean isBuff() {
		return buff;
	}
	@Override
	public String toString() {
		return effectName;
	}
	@Override
	public String getName() {
		return effectName;
	}
}