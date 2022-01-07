//Tony Zheng 20187099

public abstract class Person implements Cloneable{
	//these 3 instance variables are required
	private String name;
	private Date birthday;
	
	//While not "required" students will have needed to make this constructor
	//All methods needed to avoid privacy leaks
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
	
	//this method was required, and should return a string in this exact format
	public String toString() {
		return (this.name + ", was born on "+this.birthday.getDay()+" "+this.birthday.getMonth()+", "+this.birthday.getYear());
	}
	
	//this abstract method was required
	public abstract String personType();
	
	//the following accessor methods were not required (though they were likely created and used). 
	//These are the ones that allowed me to complete this example assignment
	public String getName() {
		return this.name;
	}
	
	//note they needed to avoid a privacy leak when doing this
	public Date getBirthday() {
		return birthday.clone();
	}

	

	
	
}
