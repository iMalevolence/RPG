package items;
@SuppressWarnings("serial")
public class WrongItemTypeException extends Exception {
	public WrongItemTypeException() {
		super();
	}
	public WrongItemTypeException(String msg) {
		super(msg);
	}
}
