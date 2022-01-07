
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

public class GuessMaster3 {
	private HashSet<GuessablePerson<? extends Person>> people; // Instance variables
	private int numPoints;
	private int numPeople;

	public GuessMaster3() { // constructor to initialize HashSet size to 0 and numPoints to 0
		people = new HashSet<GuessablePerson<?>>(0);
		this.numPoints = 0;
	}

	// method to add a person to the people HashSet
	public <M extends Person> void addPerson(M person, double difficulty) {
		if (person == null) {													//if the passed person is null then system prints invalid person
			System.out.println("Invalid Person");
		}

		numPeople++;
		GuessablePerson<Person> newPerson = new GuessablePerson<Person>(person, difficulty);
		people.add(newPerson);
	}

	// method to return the people HashSet
	public HashSet<GuessablePerson<? extends Person>> getPeople() {
		return people;
	}

	public void startGame() {
		System.out.println("Welcome! Let's start the game!");
		// variable to keep track of when the user has quit
		boolean quitGame = false;
		File myFile;
		Scanner user;
		try { // try and catch to catch FileNotFoundException
				// File path
			myFile = new File("/Users/tonyz/ELEC279/Assignment3/src/test.txt");
			user = new Scanner(new FileInputStream(myFile));
		} catch (FileNotFoundException e) {
			return;
		}
		// Iterator to iterate through person HashSet
		Iterator<GuessablePerson<? extends Person>> peopleIterator = people.iterator();

		//while the file still has text and while there are still people in the HashSet
		while (user.hasNextLine() && people.iterator().hasNext()) {
			GuessablePerson<? extends Person> currPerson = peopleIterator.next();	//current person is a person in the people HashSet
			System.out.println(currPerson.startMessage());
			// boolean value for when the user guesses correctly
			boolean correct = false;
			while (!quitGame) {
				// while loop to repeat guesses until the user is correct
				while (!correct) {
					String userInput = user.nextLine();
					if (userInput.equals("quit")) {		//quit the game if the use types quit
						user.close();
						System.exit(0);
					} else {
						try {
							// convert the users guess into a date object
							Date dateGuessed = new Date(userInput);
							// this loop could have been done in a variety of ways.
							if (dateGuessed.compareTo(currPerson.getBirthday()) == 1) { // check if dates are equal
																						// using compareTo method
								System.out.println("Incorrect. Try an earlier date.");
							}

							else if (dateGuessed.compareTo(currPerson.getBirthday()) == -1) {
								System.out.println("Incorrect. Try a later date.");
							}

							else if (dateGuessed.compareTo(currPerson.getBirthday()) == 0) {
								// display the closing message after the birthday is guessed
								System.out.println(currPerson.closingMessage());
								// Add the points won to the total number of points
								numPoints += currPerson.getAwardedPointNumber();
								// display the number of points gained, and the total number of points
								System.out.println("You won " + currPerson.getAwardedPointNumber()
										+ " points in this round. Your total number of points is " + numPoints);
								correct = true;
							}

						} catch (IncorrectDateException e) {
							System.out.println(e);
						} finally {
							System.out.println("If you would like to stop, type \"quit\" to exit");
						}

					}

				}

			}

		}

	}

	public static void main(String[] args) {
		Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), "Liberal");
		Singer dion = new Singer("Celine Dion", new Date(30, 3, 1961), "La voix du bon Dieu", new Date(6, 11, 1981));
		Singer robertson = new Singer("Ed Robertson", new Date(25, 10, 1970), " Gordon", new Date(7, 28, 1992));
		GuessMaster3 gm = new GuessMaster3();
		gm.addPerson(trudeau, 0.25);
		gm.addPerson(dion, 0.5);
		gm.addPerson(robertson, 0.75);
		System.out.println("There are " + gm.getPeople().size() + " people in the game");
		GuessablePerson<Politician> guessableTrudeau = new GuessablePerson<>(trudeau, 0.25);
		System.out.println("The next output should be -1");
		System.out.println(guessableTrudeau.compareTo(dion));
		gm.startGame();
	}

}
