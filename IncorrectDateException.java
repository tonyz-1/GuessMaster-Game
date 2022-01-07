
public class IncorrectDateException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectDateException(String dateString) {		//IncorrectDateException exception method
		super("The date you have entered, "+dateString+" is not a valid input");
	}
}
