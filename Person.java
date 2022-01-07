
public abstract class Person implements Cloneable{
	//these 3 instance variables are required
	private String name;
	private Date birthday;
	
	public Person(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday.clone();
	}
	
	public Person clone() {			//better clone method to clone a Person type object
		try {
			Person newPerson = (Person) super.clone();
			newPerson.birthday = birthday.clone();
			return newPerson;
		} catch (CloneNotSupportedException e){
			return null;
		}
	}
	
	public String toString() {
		return (this.name + ", was born on "+this.birthday.getDay()+" "+this.birthday.getMonth()+", "+this.birthday.getYear());
	}
	
	public abstract String personType();
	
	public String getName() {
		return this.name;
	}
	
	public Date getBirthday() {
		return birthday.clone();
	}

	

	
	
}
