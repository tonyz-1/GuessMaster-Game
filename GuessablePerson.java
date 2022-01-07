
public class GuessablePerson<T extends Person> implements Guessable, Cloneable {
	protected T person;				//instance variables
	private double difficulty;
	
	public GuessablePerson(T person, double difficulty) {		//constructor to initialize instance variables
		this.person = person;
		this.difficulty = difficulty;
	}
	
	public int compareTo(Person otherPerson) {					//compareTo method that returns -1 if calling object 
		if(getBirthday().compareTo(otherPerson.getBirthday()) == -1){	//comes before the passed 
			return -1;																//parameter and returns 1 if it comes
		}																			//before
																					
		else if(getBirthday().compareTo(otherPerson.getBirthday()) == 0) {
			if(this.person.getName().compareTo(otherPerson.getName()) == -1) {
				return -1;
			}
			
			else {
				return 1;
			}
		}
		
		return 1;
	}
	
	public String startMessage() {		//method to print start message
		return "Guess the birthday of the "+person.personType()+" "+person.getName();
	}
	
	public String closingMessage() {	//method to print closing message
		return "Congratulations! You were correct, "+person.toString();
	}
	
	public int getAwardedPointNumber() {		//method to return awarded points for a correct guess
		double points = this.difficulty*100;
		return (int) points;
	}
	
	public GuessablePerson<T> clone() { 								// better clone method to clone a T type object
		try {											 // try and catch to catch CloneNotSupportedExceptions
			GuessablePerson<T> newT = (GuessablePerson<T>) super.clone();
			return newT;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public Date getBirthday() {					
		return person.getBirthday().clone();
	}
}
