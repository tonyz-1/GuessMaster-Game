//Tony Zheng 20187099

public class Politician extends Person{
	//this one instance variable was required
	private String party;
	
	//this constructor was required, and needed to avoid privacy leaks
		public Politician(String name, Date birthday, String party) {
			super(name, birthday);
			this.party = party;
			
		}

		//better clone method
		public Politician clone() {
			Politician newPolitician = (Politician) super.clone();
			return newPolitician;
		}
		
		//this toString method was required
		public String toString() {
			return super.toString()+". They are a member of the "+this.party+" party.";
		}
		
		//this method was required
		public String personType() {
			return "politician";
		}
}
