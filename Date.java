//Tony Zheng 20187099

public class Date implements Cloneable{
	private static class Months{					//inner class Months
		private static int getDays(int month) {		//method to determine the number of days in a month
			switch(month) {
			case 1:
				return 31;
			case 2:
				return 28;
			case 3:
				return 31;
			case 4:
				return 30;
			case 5:
				return 31;
			case 6:
				return 30;
			case 7:
				return 31;
			case 8:
				return 31;
			case 9:
				return 30;
			case 10:
				return 31;
			case 11:
				return 30;
			case 12:
				return 31;
			}
			return 0;
		}
	}
	
	private int day;		//these 3 instance variables are required
	private int month;
	private int year;

	public Date(int day, int month, int year) {		//date constructor
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(Date otherDate) {
		this.day = otherDate.day;
		this.month = otherDate.month;
		this.year = otherDate.year;
	}

	public Date clone() { 								// better clone method to clone a Date type object
		try {											 // try and catch to catch CloneNotSupportedExceptions
			Date newDate = (Date) super.clone();
			return newDate;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public int compareTo(Date otherDate) { // compareTo method that returns -1 if calling object is
		if (this.getYear() < otherDate.getYear()) { // earlier than the passed parameter, 1 if later, and 0 if the dates are equal
			return 1;
		}

		if (this.getYear() > otherDate.getYear()) {
			return -1;
		}

		if (this.getMonth() < otherDate.getMonth()) {
			return 1;
		}

		if (this.getMonth() > otherDate.getMonth()) {
			return -1;
		}

		if (this.getDay() < otherDate.getDay()) {
			return 1;
		}

		if (this.getDay() > otherDate.getDay()) {
			return -1;
		}

		else {
			return 0;
		}
	}
	
	public Date(String sDate) throws IncorrectDateException {		//method to determine if program needs to throw IncorrectDateException
		if(sDate.length() < 10 || sDate.length() > 10) {
			throw new IncorrectDateException(sDate);
		}
		day = Integer.parseInt(sDate.substring(0, 2));
		month = Integer.parseInt(sDate.substring(3, 5));
		year = Integer.parseInt(sDate.substring(6));
		if(year < 1 || month < 1 || day < 1 || month > 12 || day > Date.Months.getDays(month)) {
			throw new IncorrectDateException(sDate);
		}
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean equals(Date date) {		//equals method
		if (this.day == date.day && this.month == date.month && this.year == date.year)
			return true;
		else
			return false;
	}

	public String toString() {		//toString method
		return day + ", " + month + ", " + year;
	}

}
